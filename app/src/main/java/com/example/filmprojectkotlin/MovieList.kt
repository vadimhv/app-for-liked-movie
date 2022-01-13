package com.example.filmprojectkotlin

import androidx.appcompat.app.AppCompatActivity
import com.example.filmprojectkotlin.DataBase.DataBaseHelper
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmprojectkotlin.DAO.Movie
import java.util.ArrayList

class MovieList : AppCompatActivity() {
    private lateinit var moviesArrayList: ArrayList<Movie>;
    private var dbHandler: DataBaseHelper? = null
    private var movieRVAdapter: MovieRVAdapter? = null
    private lateinit var moviesRV: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        // initializing our all variables.
        moviesArrayList = ArrayList()
        dbHandler = DataBaseHelper(this@MovieList, null, null, 1)

        // getting our course array
        // list from db handler class.
        moviesArrayList = dbHandler!!.getAllAddedMovies()

        // on below line passing our array lost to our adapter class.
        movieRVAdapter = MovieRVAdapter(moviesArrayList, this@MovieList)
        moviesRV = findViewById(R.id.idRVMovies)

        // setting layout manager for our recycler view.
        val linearLayoutManager = LinearLayoutManager(this@MovieList, RecyclerView.VERTICAL, false)
        moviesRV.layoutManager = linearLayoutManager

        // setting our adapter to recycler view.
        moviesRV.adapter = movieRVAdapter
    }
}