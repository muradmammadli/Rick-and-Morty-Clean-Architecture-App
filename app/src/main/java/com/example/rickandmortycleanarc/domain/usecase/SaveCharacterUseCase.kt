package com.example.rickandmortycleanarc.domain.usecase

import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import com.example.rickandmortycleanarc.data.model.Result
import javax.inject.Inject

class SaveCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(result: Result) = repository.saveNews(result)

}