package finder.character.comic.comiccharacterfinder.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sllamas on 30/8/16.
 */
public class ComicModel implements Parcelable {

    @SerializedName("id")
    public long id;

    @SerializedName("title")
    public String title;

    @SerializedName("thumbnail")
    public ComicThumbnailModel thumbnail;

    @SerializedName("description")
    public String description;

    public ComicModel(long id, String title, ComicThumbnailModel thumbnail, String description) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ComicThumbnailModel getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ComicThumbnailModel thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    protected ComicModel(Parcel in) {
        id = in.readLong();
        title = in.readString();
        thumbnail = (ComicThumbnailModel) in.readValue(ComicThumbnailModel.class.getClassLoader());
        description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeValue(thumbnail);
        dest.writeString(description);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ComicModel> CREATOR = new Parcelable.Creator<ComicModel>() {
        @Override
        public ComicModel createFromParcel(Parcel in) {
            return new ComicModel(in);
        }

        @Override
        public ComicModel[] newArray(int size) {
            return new ComicModel[size];
        }
    };
}
