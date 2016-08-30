package finder.character.comic.comiccharacterfinder.comicDetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import finder.character.comic.comiccharacterfinder.R;
import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public class ComicDetailFragment extends Fragment implements ComicDetailView {

    public final static String GNOME_ID_KEY = "GnomeId Key";
    private final static long GNOME_ID_ERROR_CODE = -1;

    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.comic_framework)
    LinearLayout linearLayout;
    @BindView(R.id.comic_image)
    ImageView comicImageView;
    @BindView(R.id.comic_title)
    TextView comicTitleTextView;

    private ComicDetailPresenter presenter;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_detail, container, false);
        unbinder = ButterKnife.bind(this, view);

        presenter = new ComicDetailPresenterImpl(this, getGonmeId());

        return view;
    }

    private long getGonmeId() {
        Bundle args = this.getArguments();
        if (args == null || args.getLong(GNOME_ID_KEY) < 0)
            return GNOME_ID_ERROR_CODE;
        else
            return args.getLong(GNOME_ID_KEY);
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
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void populateView(ComicModel comic) {
        if (comic == null) {
            Toast.makeText(getActivity(), R.string.comic_not_available, Toast.LENGTH_LONG).show();
            closeCurrentFragment();
            return;
        }
        Picasso.with(getActivity()).load(comic.getThumbnail().getCompleteThumbnailPath())
                .into(comicImageView);
        comicTitleTextView.setText(comic.getTitle());
    }

    private void closeCurrentFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }

}