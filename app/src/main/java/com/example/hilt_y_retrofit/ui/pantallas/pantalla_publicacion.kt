package com.example.hilt_y_retrofit.ui.pantallas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.hilt_y_retrofit.controladores.ControladorPublicaciones

@Composable
fun PantallaPublicacion(
    modificador: Modifier = Modifier,
    controlador_publicaciones: ControladorPublicaciones = hiltViewModel()
) {
    val publicacion = controlador_publicaciones.publicacion_seleccionada.value
    val comentarios by controlador_publicaciones.comentarios

    Log.v("PantallaPublicacion", "Valor del cotnrolador: ${controlador_publicaciones}")

    Column(
        modifier = modificador
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Fondo claro
            .padding(16.dp)
    ) {
        // Título de la publicación
        Text(
            text = publicacion.title,
            style = MaterialTheme.typography.headlineSmall, //Estilo de texto prediseñados con Material Desing 3
            color = Color(0xFF1565C0)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Cuerpo
        Text(
            text = publicacion.body,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
       Divider(color = Color.Gray, thickness = 1.dp) //dibuja una linea para separar secciones
        Spacer(modifier = Modifier.height(8.dp)) //espacio vertical

        // Lista de comentarios
        Text(
            "Comentarios:",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF424242)
        )
        Spacer(modifier = Modifier.height(4.dp))

        for (comentario in comentarios) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .border(1.dp, Color(0xFFBBDEFB), RoundedCornerShape(8.dp)) //suaviza las esquinas
                    .background(Color(0xFFE3F2FD))
                    .padding(8.dp)
            ) {
                Text(
                    text = comentario.body,
                    color = Color(0xFF0D47A1)
                )
            }
        }
    }
}
