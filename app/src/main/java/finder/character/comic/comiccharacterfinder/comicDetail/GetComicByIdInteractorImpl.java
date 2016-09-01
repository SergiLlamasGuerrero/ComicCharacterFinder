package finder.character.comic.comiccharacterfinder.comicDetail;

import finder.character.comic.comiccharacterfinder.data.DataRepository;
import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public class GetComicByIdInteractorImpl implements GetComicByIdInteractor {

    @Override
    public void getComicById(long comicId, OnFinishedListener listener) {
        ComicModel foundComic;
        for (ComicModel comic : DataRepository.comicsList) {
            if (comic.getId() == comicId) {
                foundComic = comic;
                listener.onFinished(foundComic);
                break;
            }
        }
    }

}
