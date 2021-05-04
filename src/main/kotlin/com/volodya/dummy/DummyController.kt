package com.volodya.dummy

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.time.LocalDateTime

@Controller("/dummy")
class DummyController(
    private val dummyClient: DummyClient
) {
    @Get("/time")
    fun getTime(): CurrentTimeResponse {
        return CurrentTimeResponse(dummyClient.getTime())
    }

    class CurrentTimeResponse(
        val currentTime: LocalDateTime
    )
}