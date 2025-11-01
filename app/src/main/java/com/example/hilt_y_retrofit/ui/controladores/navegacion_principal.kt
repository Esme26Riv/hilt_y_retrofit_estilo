package com.example.hilt_y_retrofit.ui.controladores

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hilt_y_retrofit.ui.pantallas.ListaPublicaciones
import com.example.hilt_y_retrofit.ui.pantallas.PantallaPublicacion

@Composable
fun NavegacionPrincipal(modificador: Modifier = Modifier){
    val control_navegacion = rememberNavController()

    NavHost(navController = control_navegacion, startDestination = PantallaListaPublicaiciones){
        composable<PantallaListaPublicaiciones> {
            ListaPublicaciones(modificador, navegar_a_publiacion = { control_navegacion.navigate(PantallaPublicacion) })
        }

        composable<PantallaPublicacion> {
           PantallaPublicacion(modificador)
        }

    }
}