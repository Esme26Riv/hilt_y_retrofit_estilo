package com.example.hilt_y_retrofit.api.repositorio

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.hilt_y_retrofit.modelos.Comentario
import com.example.hilt_y_retrofit.modelos.Publicacion
import java.util.Collections.emptyList

class AlmacenPlaceholder(
    override val publicaciones: MutableState<List<Publicacion>> = mutableStateOf(emptyList<Publicacion>()),
    override val comentarios: MutableState<List<Comentario>> = mutableStateOf(emptyList<Comentario>()),
    override val publicacion_seleccionada: MutableState<Publicacion> = mutableStateOf(Publicacion(
        userId = 0,
        id = 0,
        title = "404",
        body = "no encontrado"
    ))
): InterfazAlmacenPlaceholder{}

interface  InterfazAlmacenPlaceholder{
    val publicaciones: MutableState<List<Publicacion>>
    val comentarios: MutableState<List<Comentario>>
    val publicacion_seleccionada: MutableState<Publicacion>
}