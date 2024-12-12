package com.capstone.mysunsign.ui.quiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.capstone.mysunsign.QuizQuestionActivity
import com.capstone.mysunsign.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private val quizViewModel: QuizViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizBinding.inflate(inflater, container, false)

        setupObservers()
        setupListeners()

        return binding.root
    }

    private fun setupObservers() {
        // Observasi status kuis
        quizViewModel.quizStarted.observe(viewLifecycleOwner) { started ->
            if (started) {
                val intent = Intent(requireContext(), QuizQuestionActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setupListeners() {
        // Tombol Start
        binding.btnStart.setOnClickListener {
            quizViewModel.startQuiz()
        }

    }
}

