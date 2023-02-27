package com.example.rickandmortycleanarc.data.repository.dataSource

import com.example.rickandmortycleanarc.data.model.Result
import kotlinx.coroutines.flow.Flow

interface CharactersLocalDataSource {
    suspend fun saveCharactersToDB(result: Result)
    fun getSavedCharacters(): Flow<List<Result>>
    fun deleteCharacter(result: Result)

}