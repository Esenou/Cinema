package app.superesenou.ru.cinema.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    public static final String URL="https://kinoafisha.ua";

    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class);
    }
}
