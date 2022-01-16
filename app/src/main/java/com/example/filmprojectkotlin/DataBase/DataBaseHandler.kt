package com.example.filmprojectkotlin.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.filmprojectkotlin.DAO.Movie

class DataBaseHandler(
    context: Context,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "moviesDB.db"
        val TABLE_MOVIES = "movies"

        val COLUMN_ID = "id"
        val COLUMN_FILMNAME = "movie_name"
        val COLUMN_FILMDESCRIPTION = "movie_description"
        val COLUMN_FILMMARK = "movie_mark"
        val COLUMN_FILMGENRE = "movie_genre"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_MOVIES_TABLE =("CREATE TABLE " +
                TABLE_MOVIES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_FILMNAME + " TEXT,"
                + COLUMN_FILMDESCRIPTION + " TEXT,"
                + COLUMN_FILMMARK + " TEXT,"
                + COLUMN_FILMGENRE + " TEXT" + ")"
                )
        db?.execSQL(CREATE_MOVIES_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_MOVIES)
        onCreate(db)
    }

    fun addMovie(movie: Movie) {
        val values = ContentValues();

        values.put(COLUMN_FILMNAME, movie.name);
        values.put(COLUMN_FILMDESCRIPTION, movie.description);
        values.put(COLUMN_FILMMARK, movie.mark);
        values.put(COLUMN_FILMGENRE, movie.genre);

        val db = this.writableDatabase;

        db.insert(TABLE_MOVIES, null, values)
        db.close()
    }

    fun searchMovie(movieName: String): Movie? {
        val query =
            "SELECT * from $TABLE_MOVIES WHERE $COLUMN_FILMNAME = \"$movieName\"";
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        var movie: Movie? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            val id = cursor.getString(0).toInt()
            val movieName = cursor.getString(1)
            val movieDesc = cursor.getString(2)
            val movieMark = cursor.getString(3).toDouble()
            val movieGenre = cursor.getString(4)

            movie = Movie(id, movieName, movieDesc, movieMark, movieGenre);
            cursor.close()
        }
        db.close()
        return movie
    }

    fun getAllAddedMovies(): ArrayList<Movie> {
        val db: SQLiteDatabase = this.readableDatabase;

        val cursorCourses: Cursor = db.rawQuery("SELECT * FROM " + TABLE_MOVIES, null);

        val movieArrayList: ArrayList<Movie> = ArrayList<Movie>();

        if (cursorCourses.moveToFirst()) {
            do {
                movieArrayList.add(Movie(cursorCourses.getString(1),
                    cursorCourses.getString(2),
                    cursorCourses.getString(3).toDouble(),
                    cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return movieArrayList;
    }

    fun deletePlayer(movieName: String): Boolean {
        var result = false

        val query =
            "SELECT * from $TABLE_MOVIES WHERE $COLUMN_FILMNAME = \"$movieName\""

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            val id = Integer.parseInt(cursor.getString(0))
            db.delete(
                TABLE_MOVIES, COLUMN_ID + " = ?",
                arrayOf(id.toString()))
            cursor.close()
            result = true
        }
        db.close()
        return result
    }
}