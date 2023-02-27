package com.example.rickandmortycleanarc.presentation.viewModel

import androidx.lifecycle.*
import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getSearchedChractersUseCase: GetSearchedChractersUseCase,
    private val saveCharacterUseCase: SaveCharacterUseCase,
    private val deleteCharacterUseCase: DeleteCharacterUseCase,
    private val getSavedCharactersUseCase: GetSavedCharactersUseCase
):ViewModel() {
    private val _characters = MutableLiveData<List<Result>>()
    val characters: LiveData<List<Result>> = _characters

    init {
        getCharacters()
    }

    private fun getCharacters(){
        viewModelScope.launch {
            _characters.value = getCharactersUseCase().results
        }
    }

    fun getSearchedCharacters(characterName: String?){
        viewModelScope.launch {
            _characters.value = getSearchedChractersUseCase(characterName)?.results
        }
    }

    fun saveCharacters(result: Result) = viewModelScope.launch {
        saveCharacterUseCase(result)
    }

    fun getSavedCharacters() = liveData {
        getSavedCharactersUseCase().collect{
            emit(it)
        }
    }

    fun deletCharacterUseCase(result: Result) = CoroutineScope(Dispatchers.IO).launch {
        deleteCharacterUseCase(result)
    }


}