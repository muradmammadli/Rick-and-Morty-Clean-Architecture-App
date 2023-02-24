package com.example.rickandmortycleanarc.data.di

import com.example.rickandmortycleanarc.data.api.CharacterApi
import com.example.rickandmortycleanarc.data.repository.dataSource.CharactersRemoteDataSource
import com.example.rickandmortycleanarc.data.repository.dataSourceImpl.CharactersRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(characterApi: CharacterApi):CharactersRemoteDataSource{
        return CharactersRemoteDataSourceImpl(characterApi)
    }
}