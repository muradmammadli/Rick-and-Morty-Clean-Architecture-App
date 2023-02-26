package com.example.rickandmortycleanarc.data.repository.dataSourceImpl

import com.example.rickandmortycleanarc.data.api.CharacterApi
import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.data.repository.dataSource.CharactersRemoteDataSource
import javax.inject.Inject

class CharactersRemoteDataSourceImpl @Inject constructor(
    private val characterApi: CharacterApi
) :CharactersRemoteDataSource {
    override suspend fun getCharacters(): CharacterList {
        return  characterApi.getCharacters().body()!!
    }

    override suspend fun getCharactersInfo(characterId: Int): Result {
        return characterApi.getCharacterInfo(characterId).body()!!
    }

    override suspend fun getSearchedCharacters(characterName: String?): CharacterList? {

        return characterApi.getSearchedCharacters(characterName).body()
    }

}