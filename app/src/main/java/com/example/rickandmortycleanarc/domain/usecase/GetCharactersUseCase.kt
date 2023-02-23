package com.example.rickandmortycleanarc.domain.usecase

import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke():CharacterList{
        return characterRepository.getCharacters()
    }
}