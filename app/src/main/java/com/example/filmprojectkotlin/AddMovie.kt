package com.example.filmprojectkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.filmprojectkotlin.DAO.Movie
import com.example.filmprojectkotlin.DataBase.DataBaseHandler
import com.google.android.material.textfield.TextInputLayout

class AddMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        btnsInit();
    }

    private fun btnsInit() {
        val addMovieBtn: Button = findViewById(R.id.addMovieBtn);

        addMovieBtn.setOnClickListener(btnListeners);
    }

    private val btnListeners: View.OnClickListener = View.OnClickListener { view ->
        when(view.id){
            R.id.addMovieBtn -> {
                addMovie();
            }
        }
    }

    private fun addMovie() {
        val movieName = findViewById<TextInputLayout>(R.id.addNameInput);
        val movieDesc = findViewById<TextInputLayout >(R.id.addDescInput);
        val movieMark = findViewById<TextInputLayout>(R.id.addMarkInput);
        val movieGenre = findViewById<TextInputLayout >(R.id.addGenreInput);

        val dataBaseHelper = DataBaseHandler(this, null, null, 1);

        val movie = Movie(movieName.editText?.text.toString(), movieDesc.editText?.text.toString(), movieMark.editText?.text.toString().toDouble(), movieGenre.editText?.text.toString());

        dataBaseHelper.addMovie(movie);

        val mainIntent = Intent(this, MainActivity::class.java);
        startActivity(mainIntent);

        Toast.makeText(this, "Movie was added", Toast.LENGTH_SHORT).show();
    }
}