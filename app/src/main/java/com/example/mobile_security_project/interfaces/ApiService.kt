package com.example.mobile_security_project.interfaces

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("jokes/random")
    suspend fun getRandomJoke(): Response<ChuckNorrisJoke>
}

data class ChuckNorrisJoke(
    val categories: List<String>,
    val created_at: String,
    val icon_url: String,
    val id: String,
    val updated_at: String,
    val url: String,
    val value: String
)
