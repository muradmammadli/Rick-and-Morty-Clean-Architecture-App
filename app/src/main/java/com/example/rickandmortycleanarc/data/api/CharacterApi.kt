package com.example.rickandmortycleanarc.data.api

import com.example.rickandmortycleanarc.data.model.CharacterList
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {

    @GET("/api/character")
    suspend fun getCharacters():Response<CharacterList>

}