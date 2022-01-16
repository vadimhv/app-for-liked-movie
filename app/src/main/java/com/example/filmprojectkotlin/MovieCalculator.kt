package com.example.filmprojectkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MovieCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_calculator);

        val calculatorBtn = findViewById<Button>(R.id.calculatorBtn);

        calculatorBtn.setOnClickListener(btnsListener);

    }

    private val btnsListener: View.OnClickListener = View.OnClickListener { view ->
        val calculatorDays = findViewById<TextInputLayout>(R.id.calculatorDays)
        val calculatorTimeOnDay = findViewById<TextInputLayout>(R.id.calculatorTimeOnDay)
        val calculatorResult = findViewById<TextView>(R.id.calculatorResult);
        when(view.id) {
            R.id.calculatorBtn -> {
                calculatorResult.text = calculateMovies(calculatorDays.editText?.text.toString(), calculatorTimeOnDay.editText?.text.toString()).toString();
            }
        }
    }

    private fun calculateMovies(days: String, time: String): Int {
        val averageMovieDuration = 1.5;

        val result = days.toDouble() * (time.toDouble() / averageMovieDuration);
        return result.toInt();
    }
}