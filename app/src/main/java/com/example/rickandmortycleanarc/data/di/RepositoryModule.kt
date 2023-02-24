package com.example.rickandmortycleanarc.data.di

import com.example.rickandmortycleanarc.data.repository.CharacterRepositoryImpl
import com.example.rickandmortycleanarc.data.repository.dataSource.CharactersRemoteDataSource
import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(dataSource: CharactersRemoteDataSource):CharacterRepository{
        return CharacterRepositoryImpl(dataSource)
    }



}