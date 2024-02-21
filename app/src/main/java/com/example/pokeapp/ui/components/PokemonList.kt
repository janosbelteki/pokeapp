package com.example.pokeapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PokemonList(pokemonList: List<String>, onPokemonSelected: (String) -> Unit) {
    LazyColumn {
        items(pokemonList) { pokemon ->
            PokemonListItem(pokemon = pokemon, onPokemonSelected = onPokemonSelected)
        }
    }
}

@Composable
fun PokemonListItem(pokemon: String, onPokemonSelected: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = pokemon, modifier = Modifier.weight(1f))
            Button(onClick = { onPokemonSelected(pokemon) }) {
                Text("Details")
            }
        }
    }
}