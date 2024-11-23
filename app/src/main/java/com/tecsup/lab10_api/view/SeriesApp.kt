package com.tecsup.lab10_api.view

import com.tecsup.lab10_api.data.SerieApiService
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BotonFAB(navController: NavHostController, servicio: SerieApiService) {
    val cbeState by navController.currentBackStackEntryAsState()
    val rutaActual = cbeState?.destination?.route
    if (rutaActual == "series") {
        FloatingActionButton(
            containerColor = Color.Red,
            contentColor = Color.White,
            onClick = { navController.navigate("serieNuevo") }
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "SERIES APP",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF0D253F) // Azul oscuro Disney+
        )
    )
}


@Composable
fun BarraInferior(navController: NavHostController) {
    NavigationBar(
        containerColor = Color(0xFF0D253F), // Azul oscuro estilo Disney+
        tonalElevation = 8.dp // Añade una ligera sombra
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Outlined.Home,
                    contentDescription = "Inicio",
                    tint = if (navController.currentDestination?.route == "inicio") Color(0xFF01B4E4) else Color.White
                )
            },
            label = {
                Text(
                    "Inicio",
                    color = if (navController.currentDestination?.route == "inicio") Color(0xFF01B4E4) else Color.White
                )
            },
            selected = navController.currentDestination?.route == "inicio",
            onClick = { navController.navigate("inicio") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = "Series",
                    tint = if (navController.currentDestination?.route == "series") Color(0xFF01B4E4) else Color.White
                )
            },
            label = {
                Text(
                    "Series",
                    color = if (navController.currentDestination?.route == "series") Color(0xFF01B4E4) else Color.White
                )
            },
            selected = navController.currentDestination?.route == "series",
            onClick = { navController.navigate("series") }
        )
    }
}

