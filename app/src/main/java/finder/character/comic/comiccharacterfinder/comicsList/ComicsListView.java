package finder.character.comic.comiccharacterfinder.comicsList;

import java.util.List;

import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public interface ComicsListView {

    void showProgress();

    void hideProgress();

    void setComics(List<ComicModel> gnomes);

    void showComicDetail(long gnomeId);

}
