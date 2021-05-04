package com.volodya.movies.crew

import com.volodya.movies.MoviesTable
import com.volodya.people.PeopleTable
import org.jetbrains.exposed.sql.Table

object MovieComposerTable : Table("movie_composers") {
    val movieId = reference("movie_id", MoviesTable)
    val personId = reference("person_id", PeopleTable)
}

object MovieDirectorTable : Table("movie_directors") {
    val movieId = reference("movie_id", MoviesTable)
    val personId = reference("person_id", PeopleTable)
}