package com.example.rickandmortycleanarc.data.di

import android.app.Application
import androidx.room.Room
import com.example.rickandmortycleanarc.data.db.CharacterDAO
import com.example.rickandmortycleanarc.data.db.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideCharacterDatabase(app:Application): CharacterDatabase{
        return Room.databaseBuilder(app,CharacterDatabase::class.java, name = "character_db")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun provideCharacterDao(characterDatabase: CharacterDatabase):CharacterDAO{
        return characterDatabase.getCharacterDao()
    }

}