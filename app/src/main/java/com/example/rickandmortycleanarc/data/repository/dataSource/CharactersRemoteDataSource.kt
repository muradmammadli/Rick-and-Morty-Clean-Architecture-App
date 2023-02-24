package com.example.rickandmortycleanarc.data.repository.dataSource

import com.example.rickandmortycleanarc.data.model.CharacterList

interface CharactersRemoteDataSource {
    suspend fun getCharacters(): CharacterList
}