package com.example.rickandmortycleanarc.data.repository.dataSourceImpl

import com.example.rickandmortycleanarc.data.db.CharacterDAO
import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.data.repository.dataSource.CharactersLocalDataSource
import kotlinx.coroutines.flow.Flow

class CharactersLocatDataSourceImpl(
    private val characterDAO: CharacterDAO
) : CharactersLocalDataSource {
    override suspend fun saveCharactersToDB(result: Result) {
        characterDAO.insert(result)
    }

    override fun getSavedCharacters(): Flow<List<Result>> {
       return characterDAO.getAllCharacters()
    }

    override fun deleteCharacter(result: Result) {
       characterDAO.deleteCharacter(result)
    }
}