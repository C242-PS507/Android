package com.capstone.mysunsign

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.capstone.mysunsign.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizQuestionBinding
    private var questionsList: ArrayList<Question>? = null
    private var currentPosition = 0
    private var selectedOption = -1
    private var score = 0
    private var isAnswerSubmitted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionsList = Constants.getQuestions()
        setQuestion()

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnSubmit.setOnClickListener {
            if (selectedOption == -1) {
                // Jika jawaban belum dipilih
                binding.tvQuestion.text = "Please select an option first!"
            } else {
                validateAnswer()
                isAnswerSubmitted = true
                binding.btnSubmit.isEnabled = false
                binding.btnNext.isEnabled = true
            }
        }

        binding.btnNext.setOnClickListener {
            if (!isAnswerSubmitted) {
                // Tidak bisa next jika jawaban belum di-submit
                binding.tvQuestion.text = "Please submit your answer first!"
            } else {
                goToNextQuestion()
                isAnswerSubmitted = false
            }
        }

        listOf(
            binding.tvOptionOne,
            binding.tvOptionTwo,
            binding.tvOptionThree,
            binding.tvOptionFour
        ).forEachIndexed { index, textView ->
            textView.setOnClickListener {
                selectOption(textView, index)
            }
        }
    }

    private fun setQuestion() {
        val question = questionsList!![currentPosition]
        binding.tvQuestion.text = question.question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question.options[0]
        binding.tvOptionTwo.text = question.options[1]
        binding.tvOptionThree.text = question.options[2]
        binding.tvOptionFour.text = question.options[3]
        resetOptions()

        // Reset tombol
        binding.btnSubmit.isEnabled = true
        binding.btnNext.isEnabled = false

        // Perbarui progress bar
        updateProgressBar()

    }

    private fun resetOptions() {
        listOf(
            binding.tvOptionOne, binding.tvOptionTwo,
            binding.tvOptionThree, binding.tvOptionFour
        ).forEach {
            it.setBackgroundResource(R.drawable.rounded_edittext)
            it.isClickable = true
        }
        selectedOption = -1
    }

    private fun selectOption(option: TextView, index: Int) {
        resetOptions()
        option.setBackgroundResource(R.drawable.selected_option)
        selectedOption = index
    }

    private fun validateAnswer() {
        val question = questionsList!![currentPosition]
        val correctIndex = question.correctAnswer

        // Tandai jawaban benar dan salah
        listOf(
            binding.tvOptionOne, binding.tvOptionTwo,
            binding.tvOptionThree, binding.tvOptionFour
        ).forEachIndexed { index, textView ->
            if (index == correctIndex) {
                textView.setBackgroundResource(R.drawable.correct_option)
            } else if (index == selectedOption) {
                textView.setBackgroundResource(R.drawable.wrong_option)
            }
            textView.isClickable = false
        }

        if (selectedOption == correctIndex) {
            score++
        }

        // Jika ini soal terakhir, sembunyikan tombol Next
        if (currentPosition == questionsList!!.size - 1) {
            binding.btnNext.text = "Finish"
            binding.btnNext.setOnClickListener {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("totalQuestions", questionsList!!.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun goToNextQuestion() {
        if (currentPosition < questionsList!!.size - 1) {
            currentPosition++
            setQuestion()
        }
        updateProgressBar()

    }

    private fun updateProgressBar() {
        val progress = ((currentPosition + 1).toDouble() / questionsList!!.size * 100).toInt()
        binding.progressBar.progress = progress
        binding.tvProgress.text = "${currentPosition + 1}/${questionsList!!.size}"
    }

}
