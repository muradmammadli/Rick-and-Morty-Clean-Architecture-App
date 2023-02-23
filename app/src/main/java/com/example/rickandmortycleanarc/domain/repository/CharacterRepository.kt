package com.example.rickandmortycleanarc.domain.repository

import com.example.rickandmortycleanarc.data.model.CharacterList

interface CharacterRepository {
    suspend fun getCharacters():CharacterList
}