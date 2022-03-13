package com.camilo.product.command.api.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.math.BigDecimal

data class CreateProductCommand(
    @TargetAggregateIdentifier
    val productId: String,
    val name: String,
    val price: BigDecimal,
    val quantity: Int
)