package com.volodya.configuration

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import org.jetbrains.exposed.sql.Database
import javax.inject.Scope
import javax.inject.Singleton
import javax.sql.DataSource

@Factory
class Exposed {
    @Bean
    @Singleton
    fun database(dataSource: DataSource): Database {
        return Database.connect(dataSource).also {
            println("Connected to database")
        }
    }
}