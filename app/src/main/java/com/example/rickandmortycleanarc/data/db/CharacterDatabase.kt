package com.example.rickandmortycleanarc.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rickandmortycleanarc.data.model.Result


@Database(
    entities = [Result::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class CharacterDatabase: RoomDatabase() {
    abstract fun getCharacterDao():CharacterDAO
}