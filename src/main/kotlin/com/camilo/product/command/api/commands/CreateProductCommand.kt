package com.camilo.product.command.api.commands

import java.math.BigDecimal

data class CreateProductCommand(val name: String, val price: BigDecimal, val quantity: Int)