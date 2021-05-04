package com.volodya.dummy

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import java.time.LocalDateTime

@Client("https://postman-echo.com")
interface DummyClient {

    @Get("/time/now")
    @Consumes(MediaType.TEXT_PLAIN)
    fun getTime(): LocalDateTime
}