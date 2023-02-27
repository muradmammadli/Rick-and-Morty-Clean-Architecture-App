package com.example.rickandmortycleanarc.data.db

import androidx.room.*
import com.example.rickandmortycleanarc.data.model.Result
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(result: Result)

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Flow<List<Result>>

    @Delete
    fun deleteCharacter(result: Result)
}