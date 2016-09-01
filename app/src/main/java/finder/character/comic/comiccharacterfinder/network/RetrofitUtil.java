package finder.character.comic.comiccharacterfinder.network;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sllamas on 30/8/16.
 */
public class RetrofitUtil {
    public static final String PUBLIC_KEY = "6a7ed890b4b941a925202a5630d5b162";
    public static final String PRIVATE_KEY = "0f1d0fdf46a0bf32f962b0b9997233c0395cdf8e";
    private static final String ENDPOINT = "http://gateway.marvel.com";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(ENDPOINT).addConverterFactory
                    (GsonConverterFactory.create(new GsonBuilder().create())).build();
        }
        return retrofit;
    }
}