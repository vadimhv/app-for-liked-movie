package com.example.filmprojectkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.filmprojectkotlin.DataBase.DataBaseHelper
import com.google.android.material.textfield.TextInputLayout

class DeleteMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_movie)
        btnsInit();
    }

    private fun btnsInit() {
        val deleteMovieBtn = findViewById<Button>(R.id.deleteMovieBtn);

        deleteMovieBtn.setOnClickListener(btnListeners);
    }

    private val btnListeners: View.OnClickListener = View.OnClickListener { view ->
        when(view.id) {
            R.id.deleteMovieBtn -> {
                deletePlayer();
            }
        }
    }

    private fun deletePlayer() {
        val movieName = findViewById<TextInputLayout>(R.id.movieNameToDelete)

        val dataBaseHandler = DataBaseHelper(this, null, null, 1)

        val result = dataBaseHandler.deletePlayer(movieName.editText?.text.toString())

        if (result) {
            Toast.makeText(this, "Movie deleted!", Toast.LENGTH_LONG).show();
            val i = Intent(this, MainActivity::class.java);
            startActivity(i);
        } else {
            Toast.makeText(this, "Unknown movie!", Toast.LENGTH_LONG).show()
        }

    }
}