package com.camilo.product.command.api.model

import java.math.BigDecimal

data class ProductRestModel(val name: String, val price: BigDecimal, val quantity: Int)