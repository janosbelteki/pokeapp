package com.example.pokeapp.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.pokeapp.R

@Composable
fun OwnDropdownMenu(context: Context, onMenuItemClicked: () -> Unit) {
    var isMenuVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { isMenuVisible = !isMenuVisible }) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_hamburger_menu),
                contentDescription = "Menu",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        if (isMenuVisible) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(vertical = 16.dp, horizontal = 8.dp)
                    .paddingFromBaseline(top = 72.dp) // Adjust the top padding to position it below the header
                    .background(Color(0xFF800000)) // Burgundy red color
                    .heightIn(max = 300.dp)
            ) {
                Text(
                    text = "PokeAPI Documentation",
                    color = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            // Open the URL in a web browser
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://pokeapi.co/docs/v2"))
                            context.startActivity(intent)
                        }
                )
            }
        }
    }
}