package com.example.pokeapp

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokeapp.data.api.PokeApiService
import com.example.pokeapp.ui.components.RedHeaderWithLogoAndDropdown
import com.example.pokeapp.ui.screens.MainScreen
import com.example.pokeapp.ui.viewmodel.PokemonViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun PokeApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            RedHeaderWithLogoAndDropdown(onMenuItemClicked = {
            })
        }
    ) {
        MainScreen(
            viewModel = PokemonViewModel(apiService = PokeApiService.create()),
            onPokemonSelected = { pokemonName ->
            },
            onCatchClicked = {
            },
            onSelectedTypesChanged = {
            },
            selectedTypes = listOf<String>(),
            pokemonTypes = listOf<String>(),
        )
    }
}
