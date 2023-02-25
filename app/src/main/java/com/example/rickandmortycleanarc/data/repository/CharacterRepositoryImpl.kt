package com.example.rickandmortycleanarc.data.repository

import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.data.repository.dataSource.CharactersRemoteDataSource
import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSource: CharactersRemoteDataSource
) : CharacterRepository {

    override suspend fun getCharacters(): CharacterList {
        return dataSource.getCharacters()
    }

    override suspend fun getCharactersInfo(characterId: Int): Result {
        return dataSource.getCharactersInfo(characterId)
    }


}