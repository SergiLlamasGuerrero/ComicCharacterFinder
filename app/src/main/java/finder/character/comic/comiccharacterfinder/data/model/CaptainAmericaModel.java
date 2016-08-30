package finder.character.comic.comiccharacterfinder.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sllamas on 29/8/16.
 */
public class CaptainAmericaModel implements Parcelable {

    @SerializedName("data")
    public ComicsListModel comicsList;

    public ComicsListModel getComicsList() {
        return comicsList;
    }

    public void setComicsList(ComicsListModel comicsList) {
        this.comicsList = comicsList;
    }

    public CaptainAmericaModel(ComicsListModel comicsList) {

        this.comicsList = comicsList;
    }

    protected CaptainAmericaModel(Parcel in) {
        comicsList = (ComicsListModel) in.readValue(ComicsListModel.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(comicsList);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CaptainAmericaModel> CREATOR = new Parcelable.Creator<CaptainAmericaModel>() {
        @Override
        public CaptainAmericaModel createFromParcel(Parcel in) {
            return new CaptainAmericaModel(in);
        }

        @Override
        public CaptainAmericaModel[] newArray(int size) {
            return new CaptainAmericaModel[size];
        }
    };
}