package com.example.rickandmortycleanarc.domain.usecase

import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke():Flow<List<Result>>{
        return repository.getSavedNews()
    }
}