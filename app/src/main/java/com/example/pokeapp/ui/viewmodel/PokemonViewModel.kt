package com.example.pokeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.data.api.PokeApiService
import com.example.pokeapp.data.model.Pokemon
import com.example.pokeapp.data.model.PokemonType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonViewModel(private val apiService: PokeApiService) : ViewModel() {
    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    private val _pokemonTypeList = MutableStateFlow<List<PokemonType>>(emptyList())
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList
    val pokemonTypeList: StateFlow<List<PokemonType>> = _pokemonTypeList

    fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                val pokemonList = apiService.getPokemonList().results
                _pokemonList.value = pokemonList

                val pokemonTypeList = apiService.getPokemonTypes().results
                _pokemonTypeList.value = pokemonTypeList

            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
