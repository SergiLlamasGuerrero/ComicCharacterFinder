package finder.character.comic.comiccharacterfinder.comicsList;

/**
 * Created by sllamas on 30/8/16.
 */
public interface ComicsListPresenter {

    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}