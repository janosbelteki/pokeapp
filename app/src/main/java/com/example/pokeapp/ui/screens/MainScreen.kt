package com.example.pokeapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokeapp.ui.components.PokemonList
import com.example.pokeapp.ui.components.PokemonListItem
import com.example.pokeapp.ui.components.PokemonTypeDropdown
import com.example.pokeapp.ui.components.SearchBar
import com.example.pokeapp.ui.viewmodel.PokemonViewModel

@Composable
fun MainScreen(
    viewModel: PokemonViewModel,
    onPokemonSelected: (String) -> Unit,
    onCatchClicked: () -> Unit,
    onSelectedTypesChanged: (List<String>) -> Unit,
    selectedTypes: List<String>,
    pokemonTypes: List<String>
) {
    val pokemonList by viewModel.pokemonList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        PokemonTypeDropdown(
            pokemonTypes = pokemonTypes,
            selectedTypes = selectedTypes,
            onSelectedTypesChanged = onSelectedTypesChanged
        )


        if (pokemonList.isEmpty()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            // Display Pokémon list
            LazyColumn {
                items(pokemonList.size) { index ->
                    val pokemon = pokemonList[index]
                    PokemonListItem(pokemon = pokemon.name, onPokemonSelected = onPokemonSelected)
                }
            }
        }



        // Dropdown menu for selecting Pokemon type
        // Replace with your actual implementation
        Text(text = "Pokemon types")

        // Search bar
        // Replace with your actual implementation
        SearchBar(onSearch = {})

        // List of Pokemon
        PokemonList(pokemonList = pokemonList.map { it.name }, onPokemonSelected = onPokemonSelected)

        // Catch button
        Button(onClick = onCatchClicked) {
            Text("Catch Pokemon")
        }
    }

    // Fetch Pokémon list when MainScreen is initially composed
    LaunchedEffect(Unit) {
        viewModel.fetchPokemonList()
    }

}