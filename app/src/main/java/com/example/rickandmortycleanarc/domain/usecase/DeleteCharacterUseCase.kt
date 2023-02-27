package com.example.rickandmortycleanarc.domain.usecase

import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import javax.inject.Inject

class DeleteCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    suspend operator fun invoke(result: Result){
        repository.deleteCharacters(result)
    }


}