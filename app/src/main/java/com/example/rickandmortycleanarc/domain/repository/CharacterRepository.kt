package com.example.rickandmortycleanarc.domain.repository

import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.data.model.Result

interface CharacterRepository {
    suspend fun getCharacters():CharacterList
    suspend fun getCharactersInfo(characterId:Int):Result
    suspend fun getSearchedCharacters(characterName: String?):CharacterList?
    suspend fun saveNews(result: Result)
}