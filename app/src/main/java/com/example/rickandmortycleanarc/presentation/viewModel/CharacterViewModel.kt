package com.example.rickandmortycleanarc.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.domain.usecase.GetCharactersUseCase
import com.example.rickandmortycleanarc.domain.usecase.GetSearchedChractersUseCase
import com.example.rickandmortycleanarc.domain.usecase.SaveCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getSearchedChractersUseCase: GetSearchedChractersUseCase,
    private val saveCharacterUseCase: SaveCharacterUseCase
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


}