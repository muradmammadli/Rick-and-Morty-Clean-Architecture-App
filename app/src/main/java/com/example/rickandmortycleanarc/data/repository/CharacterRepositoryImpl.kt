package com.example.rickandmortycleanarc.data.repository

import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.domain.repository.CharacterRepository

class CharacterRepositoryImpl:CharacterRepository {
    override suspend fun getCharacters(): CharacterList {
        TODO("Not yet implemented")
    }
}