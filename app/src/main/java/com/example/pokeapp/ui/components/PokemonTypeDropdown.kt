package com.example.pokeapp.ui.components

import androidx.compose.material.Text
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.pokeapp.data.model.PokemonType
import com.example.pokeapp.ui.viewmodel.PokemonViewModel

@Composable
fun PokemonTypeDropdown(
    //viewModel: PokemonViewModel,
    pokemonTypes: List<String>,
    selectedTypes: List<String>,
    onSelectedTypesChanged: (List<String>) -> Unit,
    modifier: Modifier = Modifier,
) {
    //val pokemonTypes by remember { viewModel.pokemonTypeList }.collectAsState(initial = emptyList())

    DropdownMenu(
        modifier = Modifier,
        expanded = true,
        onDismissRequest = {}
    ) {
        pokemonTypes.forEach { type ->
            DropdownMenuItem(
                onClick = {
                    // Handle the selection of a Pokémon type
                }
            ) {
                Text(
                    text = type,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}