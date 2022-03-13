package com.camilo.product.command.api.mapper

import com.camilo.product.command.api.commands.CreateProductCommand
import com.camilo.product.command.api.database.data.Product
import com.camilo.product.command.api.events.ProductCreatedEvent
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface ProductMapper {

    fun fromCommandToEvent(createProductCommand: CreateProductCommand): ProductCreatedEvent

    @Mapping(target = "id", ignore = true)
    fun fromEventToEntity(productCreatedEvent: ProductCreatedEvent): Product
}