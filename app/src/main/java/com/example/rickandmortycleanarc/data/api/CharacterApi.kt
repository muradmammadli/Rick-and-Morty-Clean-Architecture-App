package com.example.rickandmortycleanarc.data.api

import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.data.model.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("/api/character")
    suspend fun getCharacters(): Response<CharacterList>

    @GET("/api/character/{id}")
    suspend fun getCharacterInfo(@Path("id") characterId: Int): Response<Result>
}