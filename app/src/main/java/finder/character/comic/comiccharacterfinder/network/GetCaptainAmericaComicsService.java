package finder.character.comic.comiccharacterfinder.network;

import finder.character.comic.comiccharacterfinder.data.model.CaptainAmericaModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sllamas on 29/8/16.
 */
public interface GetCaptainAmericaComicsService {

    @GET("/v1/public/characters/{characterId}/comics")
    Call<CaptainAmericaModel> getcomicsList(@Path("characterId") String usecharacterId,
                                            @Query("apikey") String apikey,
                                            @Query("ts") long ts,
                                            @Query("hash") String hash,
                                            @Query("offset") int offset);

}
