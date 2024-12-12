package com.capstone.mysunsign

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        questionsList.add(
            Question(
                0, "What letter is this?",
                R.drawable.huruf_f,
                listOf("E", "F", "G", "H"),
                correctAnswer = 1
            )
        )

        questionsList.add(
            Question(
                1, "What letter is this?",
                R.drawable.huruf_i,
                listOf("G", "H", "I", "J"),
                correctAnswer = 2
            )
        )

        questionsList.add(
            Question(
                2, "What letter is this?",
                R.drawable.huruf_r,
                listOf("R", "S", "O", "P"),
                correctAnswer = 0
            )
        )

        questionsList.add(
            Question(
                3, "What does this sign mean?",
                R.drawable.hello,
                listOf("Thank You", "Hello", "Welcome", "Hope"),
                correctAnswer = 1
            )
        )

        questionsList.add(
            Question(
                4, "What does this sign mean?",
                R.drawable.no,
                listOf("Lazy", "Dirty", "No", "Ugly"),
                correctAnswer = 2
            )
        )

        return questionsList
    }
}