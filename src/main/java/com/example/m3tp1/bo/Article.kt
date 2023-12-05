package com.example.m3tp1.bo

import java.util.Date

data class Article(
    val id: Long = 0L,
    var titre: String,
    var description: String,
    var prix: Double,
    var urlImage: String,
    var dateSortie: Date
) {}
