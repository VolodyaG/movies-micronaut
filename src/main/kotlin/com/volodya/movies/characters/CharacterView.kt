package com.volodya.movies.characters

import com.volodya.people.PersonView

class CharacterView(
    val id: Int,
    val name: String,
    val order: Int,
    val actor: PersonView,
)