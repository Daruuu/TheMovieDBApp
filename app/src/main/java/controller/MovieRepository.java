package controller;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.List;

import model.MovieModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private MovieDbApi movieDbApi;
    public MovieRepository() {
        this.movieDbApi = HttpUtils.createService(MovieDbApi.class);
    }

    public LiveData<List<MovieModel>> getPopularMovies(String apiKey) {
        MutableLiveData<List<MovieModel>> data = new MutableLiveData<>();
        Call<MovieResponse> call = movieDbApi.getPopularMovies(apiKey);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<MovieModel> movies = response.body().getResults();
                    data.setValue(movies);
                } else {

                    try {
                        String errorBody = response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                // para crear el fallo de la solicitud
            }
        });+

        return data;
    }
}
