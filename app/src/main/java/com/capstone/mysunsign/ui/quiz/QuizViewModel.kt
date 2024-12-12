package com.capstone.mysunsign.ui.quiz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    val quizStarted = MutableLiveData(false)

    fun startQuiz() {
        quizStarted.value = true
    }
}
