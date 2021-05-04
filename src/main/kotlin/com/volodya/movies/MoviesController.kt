package com.volodya.movies

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.QueryValue

@Controller("/movies")
class MoviesController(
    private val service: MovieService
) {
    @Get
    suspend fun getMovies(@QueryValue() limit: Int = 20, @QueryValue offset: Int = 0): List<MovieView> {
        return service.getMovies(limit, offset)
    }

    @Get("/{id}")
    suspend fun getMovie(@PathVariable id: Int): MovieView {
        return service.getMovieById(id)
    }
}