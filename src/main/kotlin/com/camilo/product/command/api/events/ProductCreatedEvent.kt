package com.camilo.product.command.api.events

import java.math.BigDecimal

data class ProductCreatedEvent(val productId: String, val name: String, val price: BigDecimal, val quantity: Int)