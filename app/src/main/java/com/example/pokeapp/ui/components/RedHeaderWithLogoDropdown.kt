package com.example.pokeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.pokeapp.R

@Composable
fun RedHeaderWithLogoAndDropdown(onMenuItemClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Hamburger icon
        IconButton(
            onClick = { /* Handle menu click */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_hamburger_menu),
                contentDescription = "Menu",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
    // Dropdown menu
    OwnDropdownMenu(context = LocalContext.current, onMenuItemClicked)
    // Logo
    PokemonLogo()
}