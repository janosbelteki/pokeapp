package com.example.pokeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokeapp.R

@Composable
fun PokemonLogo() {
    Image(
        painter = painterResource(id = R.drawable.pokemon_logo),
        contentDescription = "Pokemon Logo",
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(vertical = 16.dp)
            .size(200.dp, 73.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}
