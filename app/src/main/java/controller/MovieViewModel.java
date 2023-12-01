package controller;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import model.MovieModel;

public class MovieViewModel {
    private MovieRepository repository;
    private LiveData<List<MovieModel>> popularMovies;

    public MovieViewModel() {
        this.repository = new MovieRepository();
        this.popularMovies = new MutableLiveData<>();
    }

    public void fetchPopularMovies(String apiKey) {
        popularMovies = repository.getPopularMovies(apiKey);
    }

    public LiveData<List<MovieModel>> getPopularMovies() {
        return popularMovies;
    }
}
