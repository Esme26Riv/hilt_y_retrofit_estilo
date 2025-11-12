package com.example.hilt_y_retrofit.ui.pantallas

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.hilt_y_retrofit.controladores.ControladorPublicaciones

@Composable
fun PantallaPublicacion(
    modificador: Modifier = Modifier,
    controlador_publicaciones: ControladorPublicaciones = hiltViewModel()
) {
    val publicacion = controlador_publicaciones.publicacion_seleccionada.value
    val comentarios by controlador_publicaciones.comentarios
    val autor = controlador_publicaciones.usuario_seleccionado.value

    Column(
        modifier = modificador
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
            .padding(16.dp)
    ) {
        // Título de la publicación
        Text(
            text = publicacion.title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color(0xFF1565C0)

        )

        Spacer(modifier = Modifier.height(8.dp))

        // Mostrar autor (si existe)
        Text(
            text = "Autor: ${autor?.name ?: "Desconocido"} (@${autor?.username ?: "—"})",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF2E7D32),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Cuerpo
        Text(
            text = publicacion.body,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.height(8.dp))

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
                    .border(1.dp, Color(0xFFBBDEFB), RoundedCornerShape(8.dp))
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
