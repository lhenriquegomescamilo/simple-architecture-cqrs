package com.camilo.product.command.api.controller

import com.camilo.product.command.api.commands.CreateProductCommand
import com.camilo.product.command.api.model.ProductRestModel
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter
import java.util.*

@Component
class ProductCommandController(private val commandGateway: CommandGateway) {

    @Bean(name = ["productRouter"])
    fun router() = coRouter {
        (accept(MediaType.APPLICATION_JSON) and "/products").nest {
            POST("") {
                val productRequest = it.awaitBody(ProductRestModel::class)

                val productCommand = CreateProductCommand(
                    productId = UUID.randomUUID().toString(),
                    name = productRequest.name,
                    price = productRequest.price,
                    quantity = productRequest.quantity
                )
                val result = commandGateway.send<CreateProductCommand>(productCommand)
                ServerResponse.ok().bodyValueAndAwait(mapOf("productId" to productCommand.productId))
            }
        }
    }
}