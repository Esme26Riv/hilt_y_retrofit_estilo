package com.example.hilt_y_retrofit.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Constructor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServidorJSONPlaceholder{
    @Provides
    @Singleton
    fun crea_consultas_de_servicio(constructor: Retrofit.Builder): JSONPlaceholder{
        return constructor
            .build()
            .create(JSONPlaceholder::class.java)
    }

    // cualqeuir cosa que requiera conexion llamara a crea_consultas_de_serivicio(provee_conexion_a_placeholder())

    @Provides
    @Singleton
    fun provee_conexion_a_placeholder(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
    }
}