package com.barbbecker.fundatec.apifilmes

import com.google.gson.annotations.SerializedName
import java.util.ArrayList


data class ApiFilmes(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val movies: ArrayList<Movie>,
    @SerializedName("totalResults")
    val totalResults: String
)

data class Movie(
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Year")
    val year: String
)