package finder.character.comic.comiccharacterfinder.comicDetail;

import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public interface ComicDetailView {

    void showProgress();

    void hideProgress();

    void populateView(ComicModel comic);

}
