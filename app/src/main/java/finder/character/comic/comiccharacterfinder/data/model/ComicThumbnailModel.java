package finder.character.comic.comiccharacterfinder.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sllamas on 30/8/16.
 */
public class ComicThumbnailModel implements Parcelable {

    @SerializedName("path")
    String path;

    @SerializedName("extension")
    String extension;

    public ComicThumbnailModel(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public String getCompleteThumbnailPath() {
        String completeThumbnail = "";
        if (this.path != null && this.extension != null) {
            //StringBuilder stringBuilder = new StringBuilder(completeThumbnail);
            //stringBuilder.append
            completeThumbnail = this.path + "." + this.extension;
        }
        return completeThumbnail;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    protected ComicThumbnailModel(Parcel in) {
        path = in.readString();
        extension = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(path);
        dest.writeString(extension);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ComicThumbnailModel> CREATOR = new Parcelable.Creator<ComicThumbnailModel>() {
        @Override
        public ComicThumbnailModel createFromParcel(Parcel in) {
            return new ComicThumbnailModel(in);
        }

        @Override
        public ComicThumbnailModel[] newArray(int size) {
            return new ComicThumbnailModel[size];
        }
    };
}