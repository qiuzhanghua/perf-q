package com.example

import io.smallrye.mutiny.Uni
import io.vertx.mutiny.core.Vertx
import io.vertx.mutiny.redis.RedisClient
import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/hello")
class ExampleResource {

    @Inject
    lateinit var vertx: Vertx

    lateinit var client: RedisClient

    @PostConstruct
    fun init() {
        this.client = RedisClient.create(vertx)
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): Uni<Response> {
//        println(vertx)
//        var redis = Redis.createClient(vertx!!)
//        var api = RedisAPI.api(redis!!);
        return client.get("key").onItem().transform { r -> Response.ok(r).build() }
//        "hello"
    }
}