package com.camilo.product.command.api.controller

import io.netty.handler.codec.http.HttpHeaderValues.APPLICATION_JSON
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Component
class ProductCommandController(private val commandGateway: CommandGateway) {

    @Bean(name = ["productRouter"])
    fun router() = coRouter {
        (accept(MediaType.APPLICATION_JSON) and "/products").nest {
            POST("") {
                ServerResponse.noContent().buildAndAwait()
            }
        }
    }
}