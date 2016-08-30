package finder.character.comic.comiccharacterfinder.comicDetail;

import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public class ComicDetailPresenterImpl implements ComicDetailPresenter,
        GetComicByIdInteractor.OnFinishedListener {

    private ComicDetailView comicDetailView;
    private GetComicByIdInteractor getComicByIdInteractor;
    private long comicId;

    public ComicDetailPresenterImpl(ComicDetailView comicDetailView, long comicId) {
        this.comicDetailView = comicDetailView;
        this.getComicByIdInteractor = new GetComicByIdInteractorImpl();
        this.comicId = comicId;
    }

    @Override
    public void onFinished(ComicModel comic) {
        if(comicDetailView != null) {
            comicDetailView.populateView(comic);
            comicDetailView.hideProgress();
        }
    }

    @Override
    public void onResume() {
        if (comicDetailView != null) {
            comicDetailView.showProgress();
        }
        getComicByIdInteractor.getComicById(comicId, this);
    }

    @Override
    public void onDestroy() {
        comicDetailView = null;
    }
}