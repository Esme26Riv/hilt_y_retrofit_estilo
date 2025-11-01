package com.example.hilt_y_retrofit.api

import com.example.hilt_y_retrofit.modelos.Comentario
import com.example.hilt_y_retrofit.modelos.Publicacion
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONPlaceholder{
    @GET("/posts")
    suspend fun obtener_publicaciones(): List<Publicacion>

    @GET("/posts/{id}/comments")
    suspend fun obtener_comentarios_de_publicacion(@Path("id") id: Int): List<Comentario>
}

