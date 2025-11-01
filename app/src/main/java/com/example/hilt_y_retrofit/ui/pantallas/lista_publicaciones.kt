package com.example.hilt_y_retrofit.ui.pantallas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.hilt_y_retrofit.controladores.ControladorPublicaciones

@Composable
fun ListaPublicaciones(
    modificador: Modifier = Modifier,
    controlodar_publicaciones: ControladorPublicaciones = hiltViewModel(),
    navegar_a_publiacion: () -> Unit = {}
) {
    Log.v("PantallaPublicacion", "Valor del cotnrolador: ${controlodar_publicaciones}")

    controlodar_publicaciones.obtener_publicaciones()

    if (controlodar_publicaciones.publicaciones.value.size > 0) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF9F9F9))
                .padding(12.dp)
        ) {
            for (publicacion in controlodar_publicaciones.publicaciones.value) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(1.dp, Color(0xFF90CAF9), RoundedCornerShape(10.dp))
                        .background(Color(0xFFE3F2FD))
                        .clickable {
                            controlodar_publicaciones.seleccionar_publicacion(id = publicacion.id)
                            navegar_a_publiacion()
                        }
                        .padding(10.dp)
                ) {
                    Text(
                        text = publicacion.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFF1565C0)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = publicacion.body,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF424242)
                    )
                }
            }
        }
    } else {
        Text(
            "Obteniendo las últimas publicaciones, por favor espera...",
            modifier = Modifier.padding(16.dp),
            color = Color.Gray
        )
    }
}

@Preview
@Composable
fun Previsualizacion() {
    ListaPublicaciones()
}
