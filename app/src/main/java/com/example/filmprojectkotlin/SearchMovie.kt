package com.example.filmprojectkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class SearchMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        btnsInit();
    }

    private fun btnsInit() {
        val searchBtn: Button = findViewById(R.id.searchMovieBtn);

        searchBtn.setOnClickListener(btnListeners);
    }

    private val btnListeners: View.OnClickListener = View.OnClickListener { view ->
        when(view.id) {
            R.id.searchMovieBtn -> {
                val searchMovieName = findViewById<TextInputLayout>(R.id.outlinedTextField);
                val searchMovieIntent = Intent(this, SearchResult::class.java);
                searchMovieIntent.putExtra("name", searchMovieName.editText?.text.toString());
                startActivity(searchMovieIntent);
            }
        }
    }



}