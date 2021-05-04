package com.volodya

import com.volodya.configuration.Exposed
import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
            title = "movies-micronaut",
            version = "0.1"
    )
)
object Api {
}
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.volodya")
        .eagerInitSingletons(true)
		.start()
}

