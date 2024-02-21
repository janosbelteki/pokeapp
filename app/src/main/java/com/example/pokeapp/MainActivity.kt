package com.example.pokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.pokeapp.ui.theme.PokeAppTheme

// Define the different types of Pokemon
val pokemonTypes = listOf("Type1", "Type2", "Type3")

// Dummy data for the list of Pokemon
val pokemonList = listOf(
    "Pokemon 1",
    "Pokemon 2",
    "Pokemon 3",
    // Add more Pokemon as needed
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeAppTheme {
                MainScreen(
                    onPokemonSelected = { pokemonName ->
                        // Handle Pokemon selection
                    },
                    onCatchClicked = {
                        // Handle catch button click
                    }
                )
            }
        }
    }
}

@Composable
fun MainScreen(onPokemonSelected: (String) -> Unit, onCatchClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Dropdown menu for selecting Pokemon type
        // Replace with your actual implementation
        Text(text = "Select Pokemon type")

        // Search bar
        // Replace with your actual implementation
        SearchBar(onSearch = {})

        // List of Pokemon
        PokemonList(pokemonList = pokemonList, onPokemonSelected = onPokemonSelected)

        // Catch button
        Button(onClick = onCatchClicked) {
            Text("Catch Pokemon")
        }
    }
}

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

@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    val searchQuery = remember { mutableStateListOf("") }

    OutlinedTextField(
        value = searchQuery.first(),
        onValueChange = { searchQuery[0] = it },
        label = { Text("Search Pokemon") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(searchQuery.first())
            }
        )
    )
}

@Composable
fun ProfileScreen(pokemonName: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Display Pokemon details
        Text(text = "Name: $pokemonName")
        // Add more details as needed (e.g., weight, height, abilities, etc.)
    }
}
