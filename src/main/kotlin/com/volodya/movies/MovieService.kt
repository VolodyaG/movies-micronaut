package com.volodya.movies

import com.volodya.movies.characters.CharacterDao
import com.volodya.movies.characters.CharacterView
import com.volodya.people.PersonDao
import com.volodya.people.PersonView
import org.jetbrains.exposed.dao.load
import org.jetbrains.exposed.dao.with
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import javax.inject.Singleton

@Singleton
class MovieService {
    suspend fun getMovieById(id: Int): MovieView = newSuspendedTransaction {
        val movie = MovieDao.findById(id) ?: throw IllegalArgumentException("Movie with id $id not found")

        movie.load(MovieDao::composers, MovieDao::directors, MovieDao::characters, CharacterDao::person)
        movie.toView()
    }

    suspend fun getMovies(limit: Int, offset: Int): List<MovieView> = newSuspendedTransaction {
        MovieDao
            .all().limit(limit, offset.toLong())
            .with(MovieDao::composers, MovieDao::directors, MovieDao::characters, CharacterDao::person)
            .toList().map { it.toView() }
    }

    private fun MovieDao.toView(): MovieView {
        return MovieView(
            id = this.id.value,
            title = this.title,
            originalTitle = this.originalTitle,
            url = this.url,
            tagline = this.tagline,
            description = this.description,
            releaseDate = this.releaseDate,
            budgedUsd = this.budgedUsd,
            revenueUsd = this.revenueUsd,
            rating = this.rating,
            votesCount = this.votesCount,

            directors = this.directors.map { it.toView() },
            composers = this.composers.map { it.toView() },
            characters = this.characters.map { it.toView() },
        )
    }

    private fun PersonDao.toView(): PersonView {
        return PersonView(this.id.value, this.name, this.gender)
    }

    private fun CharacterDao.toView(): CharacterView {
        return CharacterView(this.id.value, this.playedCharacter, this.priorityOrder, this.person.toView())
    }
}

