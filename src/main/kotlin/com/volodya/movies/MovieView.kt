package com.volodya.movies

import com.volodya.movies.characters.CharacterView
import com.volodya.movies.genres.GenreView
import com.volodya.movies.tags.TagView
import com.volodya.people.PersonView
import java.time.LocalDate

class MovieView(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val url: String?,
    val tagline: String?,
    val description: String,
    val releaseDate: LocalDate?,
    val budgedUsd: Long?,
    val revenueUsd: Long?,
    val rating: Double?,
    val votesCount: Int?,

    val tags: List<TagView> = emptyList(),
    val genres: List<GenreView> = emptyList(),
    val directors: List<PersonView> = emptyList(),
    val composers: List<PersonView> = emptyList(),
    val characters: List<CharacterView> = emptyList(),
)