package com.capstone.mysunsign

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val options: List<String>,
    val correctAnswer: Int
)