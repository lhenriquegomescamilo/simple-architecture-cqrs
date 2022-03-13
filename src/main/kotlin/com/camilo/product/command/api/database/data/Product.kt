package com.camilo.product.command.api.database.data

import java.math.BigDecimal
import javax.persistence.*


@Entity
@Table(name = "tb_product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "product_id")
    val productId: String,

    val name: String,

    val price: BigDecimal,

    val quantity: Int
)
