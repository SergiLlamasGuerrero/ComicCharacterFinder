package finder.character.comic.comiccharacterfinder.network;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sllamas on 30/8/16.
 */
public class RetrofitUtil {
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