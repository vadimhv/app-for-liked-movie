package com.example.filmprojectkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.filmprojectkotlin.DataBase.DataBaseHandler

class SearchResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        val intent = intent;
        val message: String? = intent.getStringExtra("name");
        searchMovie(message);
    }


    private fun searchMovie(searchMovieName: String?) {
        val searchMovieNameRes = findViewById<TextView>(R.id.searchNameResult);
        val searchMovieDescRes = findViewById<TextView>(R.id.searchDescResult);
        val searchMovieMarkRes = findViewById<TextView>(R.id.searchMarkResult);
        val searchMovieGenreRes = findViewById<TextView>(R.id.searchGenreResult);

        val dataBaseHelper = DataBaseHandler(this, null, null, 1);

        val movie = dataBaseHelper.searchMovie(searchMovieName.toString());

        if (movie != null) {
            searchMovieNameRes.text = movie.name;
            searchMovieDescRes.text = movie.description;
            searchMovieMarkRes.text = movie.mark.toString();
            searchMovieGenreRes.text = movie.genre;
            Toast.makeText(this, "Movie data loaded!", Toast.LENGTH_SHORT).show()

        } else {
            searchMovieNameRes.text = "No data";
            searchMovieDescRes.text = "No data";
            searchMovieMarkRes.text = "No data";
            searchMovieGenreRes.text = "No data";
            Toast.makeText(this, "This movie is not in the list", Toast.LENGTH_SHORT).show()
        }
    }
}