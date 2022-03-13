package com.camilo.product.command.api.database.repository

import com.camilo.product.command.api.database.data.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
}