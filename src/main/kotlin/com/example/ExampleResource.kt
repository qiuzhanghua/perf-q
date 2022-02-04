package com.example

import io.smallrye.mutiny.Uni
import io.vertx.mutiny.core.Vertx
import io.quarkus.redis.client.reactive.ReactiveRedisClient
import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class ExampleResource {

    @Inject
    lateinit var vertx: Vertx

    @Inject
    lateinit var reactiveRedisClient: ReactiveRedisClient

    @PostConstruct
    fun init() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): Uni<String> {
        return reactiveRedisClient.get("name").onItem()
            .ifNotNull().transform { r -> r.toString() }
            .onFailure().recoverWithNull()
    }
}