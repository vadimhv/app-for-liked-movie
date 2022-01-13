package com.example.filmprojectkotlin.DAO

class Movie {

    var id: Int = 0;
    var name: String = "";
    var description: String = "";
    var mark: Double = 0.0;
    var genre: String = "";

    constructor(id: Int, name: String, description: String, mark: Double, genre: String) {
        this.id = id
        this.name = name
        this.description = description
        this.mark = mark
        this.genre = genre
    }

    constructor(name: String, description: String, mark: Double, genre: String) {
        this.name = name
        this.description = description
        this.mark = mark
        this.genre = genre
    }

}