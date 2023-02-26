package com.example.rickandmortycleanarc.domain.usecase

import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import javax.inject.Inject

class GetSearchedChractersUseCase @Inject constructor(
    private val repository: CharacterRepository
){
    suspend operator fun invoke(characterName: String?):CharacterList?{
        return repository.getSearchedCharacters(characterName)
    }
}