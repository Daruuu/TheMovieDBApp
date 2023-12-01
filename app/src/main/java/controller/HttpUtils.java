package controller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class   HttpUtils {


    // Connectin with TMBD
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(serviceClass);
    }

}