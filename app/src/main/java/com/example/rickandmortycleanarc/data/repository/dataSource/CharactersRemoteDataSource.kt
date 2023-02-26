package com.example.rickandmortycleanarc.data.repository.dataSource

import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.data.model.Result

interface CharactersRemoteDataSource {
    suspend fun getCharacters(): CharacterList
    suspend fun getCharactersInfo(characterId:Int):Result
    suspend fun getSearchedCharacters(characterName:String?):CharacterList?
}