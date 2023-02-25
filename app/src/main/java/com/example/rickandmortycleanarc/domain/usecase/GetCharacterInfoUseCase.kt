package com.example.rickandmortycleanarc.domain.usecase

import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import com.example.rickandmortycleanarc.data.model.Result
import javax.inject.Inject

class GetCharacterInfoUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(characterId:Int):Result{
        return characterRepository.getCharactersInfo(characterId)
    }
}