package finder.character.comic.comiccharacterfinder.comicsList;

/**
 * Created by sllamas on 30/8/16.
 */

import java.util.List;

import finder.character.comic.comiccharacterfinder.data.DataRepository;
import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

public class ComicsListPresenterImpl implements ComicsListPresenter,
        FindComicsInteractor.OnFinishedListener {

    private ComicsListView comicsListView;
    private FindComicsInteractor findComicsInteractor;

    public ComicsListPresenterImpl(ComicsListView comicsListView) {
        this.comicsListView = comicsListView;
        findComicsInteractor = new FindComicsInteractorImpl();
    }

    @Override
    public void onResume() {
        if (comicsListView != null) {
            comicsListView.showProgress();
        }

        findComicsInteractor.findComics(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (comicsListView != null) {
            long comicId = DataRepository.comicsList.get(position).getId();
            //comicsListView.showComicsDetail(gnomeId);
        }
    }

    @Override
    public void onDestroy() {
        comicsListView = null;
    }

    @Override
    public void onFinished(List<ComicModel> gnomes) {
        if (comicsListView != null) {
            comicsListView.setComics(gnomes);
            comicsListView.hideProgress();
        }
    }

}