package finder.character.comic.comiccharacterfinder.comicsList;

import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import finder.character.comic.comiccharacterfinder.data.DataRepository;
import finder.character.comic.comiccharacterfinder.data.model.CaptainAmericaModel;
import finder.character.comic.comiccharacterfinder.data.model.ComicModel;
import finder.character.comic.comiccharacterfinder.data.model.ComicsListModel;
import finder.character.comic.comiccharacterfinder.network.GetCaptainAmericaComicsService;
import finder.character.comic.comiccharacterfinder.network.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by sllamas on 30/8/16.
 */
public class FindComicsInteractorImpl implements FindComicsInteractor, Callback<CaptainAmericaModel> {

    private OnFinishedListener listener;

    @Override
    public void findComics(OnFinishedListener listener, String characterId) {
        this.listener = listener;
        if (DataRepository.comicsList != null && !DataRepository.comicsList.isEmpty()) {
            listener.onFinished(DataRepository.comicsList);
            return;
        }
        Retrofit retrofit = RetrofitUtil.getRetrofit();
        GetCaptainAmericaComicsService getCaptainAmericaComicsService =
                retrofit.create(GetCaptainAmericaComicsService.class);
        long ts = System.currentTimeMillis();
        Call<CaptainAmericaModel> call = getCaptainAmericaComicsService.getcomicsList(
                characterId, RetrofitUtil.PUBLIC_KEY, ts,
                md5Encript(String.valueOf(ts) + RetrofitUtil.PRIVATE_KEY + RetrofitUtil.PUBLIC_KEY),
                0
        );
        call.enqueue(this);
    }

    private String md5Encript(String s) {
        MessageDigest m = null;

        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String hash = "";
        if (m != null) {
            m.update(s.getBytes(), 0, s.length());
            hash = new BigInteger(1, m.digest()).toString(16);
        }

        return hash;
    }

    private void populateComicsList(CaptainAmericaModel captainAmericaModel) {
        if (captainAmericaModel != null) {
            List<ComicModel> comicsList = new ArrayList<>();
            if (captainAmericaModel.getComicsList() != null) {
                ComicsListModel comicsListModel = captainAmericaModel.getComicsList();
                if (comicsListModel.getComicsList() != null)
                    comicsList = comicsListModel.getComicsList();
            }
            listener.onFinished(comicsList);
        }
    }

    @Override
    public void onResponse(Call<CaptainAmericaModel> call, Response<CaptainAmericaModel> response) {
        if (response != null) {
            populateComicsList(response.body());
            CaptainAmericaModel captainAmericaModel = response.body();
            if (captainAmericaModel != null) {
                if (captainAmericaModel.getComicsList() != null) {
                    DataRepository.comicsList = captainAmericaModel.getComicsList().getComicsList();
                }
            }
        }
    }

    @Override
    public void onFailure(Call<CaptainAmericaModel> call, Throwable t) {
        Log.d("Retrofit onFailure", t.getMessage());
    }

}
