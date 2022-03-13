package com.camilo.product.api.mapper

import com.camilo.product.command.api.commands.CreateProductCommand
import com.camilo.product.command.api.database.data.Product
import com.camilo.product.command.api.events.ProductCreatedEvent
import com.camilo.product.command.api.mapper.ProductMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import java.math.BigDecimal
import java.util.*

class ProductMapperTest {

    @Test
    fun `it should map from CreateProductCommand to ProductCreatedEvent`() {
        val mapperInstance = Mappers.getMapper(ProductMapper::class.java)
        val productId = UUID.randomUUID().toString()
        val command = CreateProductCommand(
            productId = productId,
            name = "Product 01",
            price = BigDecimal.valueOf(100.01),
            quantity = 1
        )

        val result = mapperInstance.fromCommandToEvent(command)
        val expected = ProductCreatedEvent(
            productId = productId,
            name = "Product 01",
            price = BigDecimal.valueOf(100.01),
            quantity = 1
        )

        Assertions.assertEquals(expected, result)

    }

    @Test
    fun `it should mapp from ProductCreatedEvent to Product entity`() {
        val mapperInstance = Mappers.getMapper(ProductMapper::class.java)
        val productId = UUID.randomUUID().toString()
        val event = ProductCreatedEvent(
            productId = productId,
            name = "Product 01",
            price = BigDecimal.valueOf(100.01),
            quantity = 1
        )

        val result = mapperInstance.fromEventToEntity(event)

        val expected = Product(
            id = null,
            productId = productId,
            name = "Product 01",
            price = BigDecimal.valueOf(100.01),
            quantity = 1
        )

        Assertions.assertEquals(expected, result)

    }
}