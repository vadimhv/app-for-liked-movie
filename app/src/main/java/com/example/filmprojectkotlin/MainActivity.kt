package com.example.filmprojectkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.filmprojectkotlin.DAO.Movie
import com.example.filmprojectkotlin.DataBase.DataBaseHandler
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        btnInit();
        moviesCountToShow();
    }

    private fun btnInit() {
        val addMovieBtn = findViewById<Button>(R.id.addMovieMainBtn);
        val searchMovieBtn = findViewById<Button>(R.id.searchMovieMainBtn);
        val movieListBtn = findViewById<Button>(R.id.movieListMainBtn);
        val deleteMovieBtn = findViewById<Button>(R.id.deleteMovieBtn);
        val calculatorBtn = findViewById<Button>(R.id.movieCalculatorMainBtn);
        val authorBtn: Button = findViewById(R.id.authorMainBtn);

        addMovieBtn.setOnClickListener(btnListeners);
        searchMovieBtn.setOnClickListener(btnListeners);
        movieListBtn.setOnClickListener(btnListeners);
        deleteMovieBtn.setOnClickListener(btnListeners);
        calculatorBtn.setOnClickListener(btnListeners);
        authorBtn.setOnClickListener(btnListeners);
    }


    private fun moviesCountToShow() {
        val moviesArrayList: ArrayList<Movie>
        val dbHandler = DataBaseHandler(this, null, null, 1)

        moviesArrayList = dbHandler.getAllAddedMovies()

        val movieRVAdapter = MovieRVAdapter(moviesArrayList, this);

        val movieCount = findViewById<TextView>(R.id.movieCount);
        movieCount.text = movieRVAdapter.itemCount.toString();
    }

    private val btnListeners: View.OnClickListener = View.OnClickListener { view ->
        when(view.id) {
            R.id.addMovieMainBtn -> {
                val addMovieIntent = Intent(this, AddMovie::class.java);
                startActivity(addMovieIntent);
            }
            R.id.searchMovieMainBtn -> {
                val searchMovieIntent = Intent(this, SearchMovie::class.java);
                startActivity(searchMovieIntent);
            }
            R.id.movieListMainBtn -> {
                val movieListIntent = Intent(this, MovieList::class.java);
                startActivity(movieListIntent);
            }
            R.id.deleteMovieBtn -> {
                val deleteMovieIntent = Intent(this, DeleteMovie::class.java);
                startActivity(deleteMovieIntent);
            }
            R.id.movieCalculatorMainBtn -> {
                val calculatorIntent = Intent(this, MovieCalculator::class.java);
                startActivity(calculatorIntent);
            }
            R.id.authorMainBtn -> {
                val authorIntent = Intent(this, AuthorData::class.java);
                startActivity(authorIntent);
            }
        }
    }
}