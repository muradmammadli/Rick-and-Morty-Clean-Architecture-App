package com.example.rickandmortycleanarc.data.repository

import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.data.repository.dataSource.CharactersLocalDataSource
import com.example.rickandmortycleanarc.data.repository.dataSource.CharactersRemoteDataSource
import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource,
    private val localDataSource: CharactersLocalDataSource
) : CharacterRepository {

    override suspend fun getCharacters(): CharacterList {
        return remoteDataSource.getCharacters()
    }

    override suspend fun getCharactersInfo(characterId: Int): Result {
        return remoteDataSource.getCharactersInfo(characterId)
    }

    override suspend fun getSearchedCharacters(characterName: String?): CharacterList? {
        return remoteDataSource.getSearchedCharacters(characterName)
    }

    override suspend fun saveNews(result: Result) {
        localDataSource.saveCharactersToDB(result)
    }

    override suspend fun deleteCharacters(result: Result) {
        localDataSource.deleteCharacter(result)
    }

    override fun getSavedNews(): Flow<List<Result>> {
        return localDataSource.getSavedCharacters()
    }


}