package com.example.pokeapp.data.api

import com.example.pokeapp.data.model.Pokemon
import com.example.pokeapp.data.model.PokemonListResponse
import com.example.pokeapp.data.model.PokemonTypeListResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    @GET("type")
    suspend fun getPokemonTypes(): PokemonTypeListResponse
    @GET("pokemon")
    suspend fun getPokemonList(): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): Pokemon

    @GET("type/{type}")
    suspend fun getPokemonByType(@Path("type") type: String): PokemonListResponse

    @GET("pokemon")
    suspend fun searchPokemonByName(@Query("name") name: String): PokemonListResponse

    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"

        fun create(): PokeApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            return retrofit.create(PokeApiService::class.java)
        }
    }
}
