package com.example.hilt_y_retrofit.api.repositorio

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.hilt_y_retrofit.modelos.Comentario
import com.example.hilt_y_retrofit.modelos.Publicacion
import com.example.hilt_y_retrofit.modelos.Usuario
import java.util.Collections.emptyList

class AlmacenPlaceholder(
    override val publicaciones: MutableState<List<Publicacion>> = mutableStateOf(emptyList<Publicacion>()),
    override val comentarios: MutableState<List<Comentario>> = mutableStateOf(emptyList<Comentario>()),
    override val usuarios: MutableState<List<Usuario>> = mutableStateOf(emptyList<Usuario>()),
    override val publicacion_seleccionada: MutableState<Publicacion> = mutableStateOf(
        Publicacion(
            userId = 0,
            id = 0,
            title = "404",
            body = "no encontrado"
        )
    ),
    //usuario seleccionado
    override val usuario_seleccionado: MutableState<Usuario?> = mutableStateOf(null)

): InterfazAlmacenPlaceholder{}

interface InterfazAlmacenPlaceholder{
    val publicaciones: MutableState<List<Publicacion>>
    val comentarios: MutableState<List<Comentario>>
    val usuarios: MutableState<List<Usuario>>
    val publicacion_seleccionada: MutableState<Publicacion>
    val usuario_seleccionado: MutableState<Usuario?>
}