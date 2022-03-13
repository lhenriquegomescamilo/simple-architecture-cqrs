package com.camilo.product.command.api.aggregate

import com.camilo.product.command.api.commands.CreateProductCommand
import com.camilo.product.command.api.events.ProductCreatedEvent
import com.camilo.product.command.api.mapper.ProductMapper
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import org.mapstruct.factory.Mappers
import java.math.BigDecimal
import kotlin.properties.Delegates

@Aggregate
class ProductAggregate {

    @AggregateIdentifier
    private lateinit var productId: String
    private lateinit var name: String
    private lateinit var price: BigDecimal
    private var quantity by Delegates.notNull<Int>()

    private val productMapper = Mappers.getMapper(ProductMapper::class.java)

    constructor()

    @CommandHandler
    constructor(command: CreateProductCommand) {
        val productCreatedEvent = productMapper.fromCommandToEvent(command)
        AggregateLifecycle.apply(productCreatedEvent)
    }

    @EventSourcingHandler
    fun onCreateProductEvent(productCreatedEvent: ProductCreatedEvent) {
        this.productId = productCreatedEvent.productId
        this.name = productCreatedEvent.name
        this.price = productCreatedEvent.price
        this.quantity = productCreatedEvent.quantity
    }
}