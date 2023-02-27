package com.example.rickandmortycleanarc.data.di

import com.example.rickandmortycleanarc.data.db.CharacterDAO
import com.example.rickandmortycleanarc.domain.repository.CharacterRepository
import com.example.rickandmortycleanarc.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCharactersUseCase(characterRepository: CharacterRepository): GetCharactersUseCase {
        return GetCharactersUseCase(characterRepository)
    }

    @Provides
    @Singleton
    fun provideGetSearchedCharacterUseCse(characterRepository: CharacterRepository): GetSearchedChractersUseCase{
        return GetSearchedChractersUseCase(characterRepository)
    }

    @Provides
    @Singleton
    fun provideSaveCharacterUseCase(characterRepository: CharacterRepository):SaveCharacterUseCase{
        return SaveCharacterUseCase(characterRepository)
    }


    @Provides
    @Singleton
    fun provideGetCharacterInfoUseCase(characterRepository: CharacterRepository):GetCharacterInfoUseCase{
        return GetCharacterInfoUseCase(characterRepository)
    }

    @Provides
    @Singleton
    fun provideGetSavedCharactersUseCase(characterRepository: CharacterRepository):GetSavedCharactersUseCase{
        return GetSavedCharactersUseCase(characterRepository)
    }


    @Provides
    @Singleton
    fun providesDeleteCharacter(characterRepository: CharacterRepository):DeleteCharacterUseCase{
        return DeleteCharacterUseCase(characterRepository)
    }




}