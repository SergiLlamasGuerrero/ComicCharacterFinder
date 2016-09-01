package finder.character.comic.comiccharacterfinder.comicDetail;

import finder.character.comic.comiccharacterfinder.data.DataRepository;
import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public class GetComicByIdInteractorImpl implements GetComicByIdInteractor {

    @Override
    public void getComicById(long gnomeId, OnFinishedListener listener) {
        ComicModel foundGnome;
        for (ComicModel gnome : DataRepository.comicsList) {
            if (gnome.getId() == gnomeId) {
                foundGnome = gnome;
                listener.onFinished(foundGnome);
                break;
            }
        }
    }

}
