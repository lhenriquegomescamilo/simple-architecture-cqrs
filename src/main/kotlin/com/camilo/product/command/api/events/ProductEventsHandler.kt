package com.camilo.product.command.api.events

import com.camilo.product.command.api.database.repository.ProductRepository
import com.camilo.product.command.api.mapper.ProductMapper
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component

@Component
class ProductEventsHandler(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper
) {

    @EventHandler
    fun onCreate(productCreatedEvent: ProductCreatedEvent) {
        val product = productMapper.fromEventToEntity(productCreatedEvent)
        productRepository.save(product)
    }
}