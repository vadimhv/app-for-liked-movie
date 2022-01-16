package com.example.filmprojectkotlin

import androidx.appcompat.app.AppCompatActivity
import com.example.filmprojectkotlin.DataBase.DataBaseHandler
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmprojectkotlin.DAO.Movie
import java.util.ArrayList

class MovieList : AppCompatActivity() {
    private lateinit var moviesArrayList: ArrayList<Movie>;
    private var dbHandler: DataBaseHandler? = null
    private var movieRVAdapter: MovieRVAdapter? = null
    private lateinit var moviesRV: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        moviesArrayList = ArrayList()
        dbHandler = DataBaseHandler(this@MovieList, null, null, 1)

        moviesArrayList = dbHandler!!.getAllAddedMovies()

        movieRVAdapter = MovieRVAdapter(moviesArrayList, this@MovieList)
        moviesRV = findViewById(R.id.idRVMovies)

        val linearLayoutManager = LinearLayoutManager(this@MovieList, RecyclerView.VERTICAL, false)
        moviesRV.layoutManager = linearLayoutManager

        moviesRV.adapter = movieRVAdapter
    }
}