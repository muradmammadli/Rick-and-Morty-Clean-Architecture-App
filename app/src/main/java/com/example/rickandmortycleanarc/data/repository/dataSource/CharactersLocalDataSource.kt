package com.example.rickandmortycleanarc.data.repository.dataSource

import com.example.rickandmortycleanarc.data.model.Result

interface CharactersLocalDataSource {
    suspend fun saveCharactersToDB(result:Result)
}