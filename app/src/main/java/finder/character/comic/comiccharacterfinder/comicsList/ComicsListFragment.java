package finder.character.comic.comiccharacterfinder.comicsList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import finder.character.comic.comiccharacterfinder.R;
import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public class ComicsListFragment extends Fragment implements ComicsListView,
        AdapterView.OnItemClickListener{

    @BindView(R.id.list)
    ListView listView;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    private ComicsListPresenter presenter;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comics_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        listView.setOnItemClickListener(this);
        presenter = new ComicsListPresenterImpl(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setComics(List<ComicModel> comics) {
        listView.setAdapter(new ComicArrayAdapter(getActivity(), R.layout.comic_list_item, comics));
    }

    @Override
    public void showComicDetail(long gnomeId) {
        /*FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ComicDetailFragment comicDetailFragment = new ComicDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(ComicDetailFragment.GNOME_ID_KEY, gnomeId);
        comicDetailFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, comicDetailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }

}
