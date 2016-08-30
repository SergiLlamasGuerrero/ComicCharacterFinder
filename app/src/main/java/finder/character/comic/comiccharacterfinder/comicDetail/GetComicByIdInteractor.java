package finder.character.comic.comiccharacterfinder.comicDetail;

import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public interface GetComicByIdInteractor {

    interface OnFinishedListener {
        void onFinished(ComicModel comic);
    }

    void getComicById(long comicId, OnFinishedListener listener);

}
