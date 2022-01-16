package com.example.filmprojectkotlin

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.filmprojectkotlin.R
import android.widget.TextView
import com.example.filmprojectkotlin.DAO.Movie
import java.util.ArrayList

class MovieRVAdapter
    (
    private val moviesArrayList: ArrayList<Movie>, private val context: Context
) : RecyclerView.Adapter<MovieRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modal = moviesArrayList[position]
        holder.movieName.text = modal.name
        holder.movieDesc.text = modal.description
        holder.movieMark.text = String.format("%s", modal.mark)
        holder.movieGenre.text = modal.genre
    }

    override fun getItemCount(): Int {
        return moviesArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieName: TextView
        val movieDesc: TextView
        val movieMark: TextView
        val movieGenre: TextView

        init {
            movieName = itemView.findViewById(R.id.movieNameFromList)
            movieDesc = itemView.findViewById(R.id.movieDescFromList)
            movieMark = itemView.findViewById(R.id.movieMarkFromList)
            movieGenre = itemView.findViewById(R.id.movieGenreFromList)
        }
    }
}