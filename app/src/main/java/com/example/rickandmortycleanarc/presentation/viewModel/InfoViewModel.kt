package com.example.rickandmortycleanarc.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycleanarc.domain.usecase.GetCharacterInfoUseCase
import com.example.rickandmortycleanarc.data.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val getCharacterInfoUseCase: GetCharacterInfoUseCase
):ViewModel() {

    private val _characterInfo:MutableLiveData<Result> = MutableLiveData()
    val characterInfo: LiveData<Result> = _characterInfo


    fun getCharacterInfo(characterId:Int){
        viewModelScope.launch{
            _characterInfo.value = getCharacterInfoUseCase(characterId)
        }
    }
}