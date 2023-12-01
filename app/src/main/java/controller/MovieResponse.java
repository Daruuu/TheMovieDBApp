package controller;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.MovieModel;

public class MovieResponse {
    @SerializedName("results")
    private List<MovieModel> results;

    public List<MovieModel> getResults() {
        return results;
    }
}
