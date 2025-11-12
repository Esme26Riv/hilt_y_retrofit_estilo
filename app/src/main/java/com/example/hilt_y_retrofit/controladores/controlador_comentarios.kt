package com.example.hilt_y_retrofit.controladores

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt_y_retrofit.api.JSONPlaceholder
import com.example.hilt_y_retrofit.api.repositorio.InterfazAlmacenPlaceholder
import com.example.hilt_y_retrofit.modelos.Comentario
import com.example.hilt_y_retrofit.modelos.Publicacion
import com.example.hilt_y_retrofit.modelos.Usuario
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Collections.emptyList
import javax.inject.Inject

@HiltViewModel
class ControladorPublicaciones @Inject constructor(
    private val api_placeholder: JSONPlaceholder,
    private val base_de_datos: InterfazAlmacenPlaceholder
) : ViewModel() {
    val publicaciones: State<List<Publicacion>> = base_de_datos.publicaciones
    val publicacion_seleccionada: State<Publicacion> = base_de_datos.publicacion_seleccionada
    val comentarios: State<List<Comentario>> = base_de_datos.comentarios

    // NUEVO: exponer usuarios y usuario seleccionado (solo lectura desde UI)
    val usuarios: State<List<Usuario>> = base_de_datos.usuarios
    val usuario_seleccionado = base_de_datos.usuario_seleccionado

    fun obtener_comentarios() {
        viewModelScope.launch {
            try {
                val comentarios_obtenidos =
                    api_placeholder.obtener_comentarios_de_publicacion(publicacion_seleccionada.value.id)
                base_de_datos.comentarios.value = comentarios_obtenidos
            } catch (error: Exception) {
                Log.wtf("Peticion API", "LA api respondio con un ${error.message}")
            }
        }
    }

    fun seleccionar_publicacion(id: Int) {
        Log.wtf("Controlodar De Publicaciones", "Se ha seleccionado la publicacion: ${id}")
        for (publicacion in publicaciones.value) {
            if (publicacion.id == id) {
                base_de_datos.publicacion_seleccionada.value = publicacion
                // obtener comentarios de la publicacion seleccionada
                obtener_comentarios()
                // establecer usuario seleccionado buscando en la lista de usuarios
                val autor = base_de_datos.usuarios.value.find { it.id == publicacion.userId }
                base_de_datos.usuario_seleccionado.value = autor
                break
            }
        }
    }

    fun obtener_publicaciones() {
        viewModelScope.launch {
            try {
                val publicaciones_obtenidas = api_placeholder.obtener_publicaciones()
                base_de_datos.publicaciones.value = publicaciones_obtenidas
            } catch (error: Exception) {
                Log.wtf("Peticion API", "LA api respondio con un ${error.message}")
            }
        }
    }

    // NUEVO: obtener usuarios y guardarlos en el almacen
    fun obtener_usuarios() {
        viewModelScope.launch {
            try {
                val usuarios_obtenidos = api_placeholder.obtener_usuarios()
                base_de_datos.usuarios.value = usuarios_obtenidos
            } catch (error: Exception) {
                Log.wtf("Peticion API", "LA api respondio con un ${error.message}")
            }
        }
    }
}
