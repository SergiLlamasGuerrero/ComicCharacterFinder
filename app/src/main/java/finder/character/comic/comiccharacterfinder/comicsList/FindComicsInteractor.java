package finder.character.comic.comiccharacterfinder.comicsList;

import java.util.List;

import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public interface FindComicsInteractor {

    interface OnFinishedListener {
        void onFinished(List<ComicModel> comics);
    }

    void findComics(OnFinishedListener listener, String characterId);

}
