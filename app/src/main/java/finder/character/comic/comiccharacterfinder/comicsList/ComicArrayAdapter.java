package finder.character.comic.comiccharacterfinder.comicsList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import finder.character.comic.comiccharacterfinder.R;
import finder.character.comic.comiccharacterfinder.data.model.ComicModel;

/**
 * Created by sllamas on 30/8/16.
 */
public class ComicArrayAdapter extends ArrayAdapter<ComicModel> {

    private Context context;
    private int resource;
    private List<ComicModel> comicsList;

    public ComicArrayAdapter(Context context, int resource, List<ComicModel> comicsList) {
        super(context, resource, comicsList);
        this.context = context;
        this.resource = resource;
        this.comicsList = comicsList;
    }

    @Override
    public int getCount() {
        return comicsList == null ? 0 : comicsList.size();
    }

    @Override
    public ComicModel getItem(int position) {
        return comicsList == null ? null : super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        if (comicsList == null || comicsList.get(position) == null)
            return -1;
        return comicsList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null && context != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                    .LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
        }
        ComicModel comic = comicsList.get(position);
        viewHolder = new ViewHolder(convertView);

        if (context != null) {
            Picasso.with(context).load(comic.getThumbnail().getCompleteThumbnailPath())
                    .into(viewHolder.imageView);
        }

        viewHolder.textView.setText(comic.getTitle());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.comic_thumbnail)
        CircleImageView imageView;
        @BindView(R.id.comic_name)
        TextView textView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
