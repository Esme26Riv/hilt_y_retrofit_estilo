package com.example.hilt_y_retrofit.api.repositorio

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProveerAlmacenJsonPlaceholder{
    @Provides
    @Singleton
    fun crea_un_almacen_placeholder(): InterfazAlmacenPlaceholder{
        return AlmacenPlaceholder()
    }
}
