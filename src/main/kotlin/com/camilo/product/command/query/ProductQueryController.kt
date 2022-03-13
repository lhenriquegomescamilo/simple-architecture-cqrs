package com.camilo.product.command.query

import com.camilo.product.command.api.database.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Component
class ProductQueryController(private val productRepository: ProductRepository) {

    @Bean(name = ["productQueryRouter"])
    fun router() = coRouter {
        (accept(MediaType.APPLICATION_JSON) and "/products").nest {
            GET("") {
                val products = withContext(Dispatchers.IO) {
                    productRepository.findAll()
                }
                ServerResponse.ok().bodyValueAndAwait(products)
            }
        }
    }
}