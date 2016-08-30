package finder.character.comic.comiccharacterfinder.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sllamas on 30/8/16.
 */
public class ComicsListModel implements Parcelable {

    @SerializedName("offset")
    public int offset;

    @SerializedName("limit")
    public int limit;

    @SerializedName("total")
    public int total;

    @SerializedName("count")
    public int count;

    @SerializedName("results")
    public List<ComicModel> comicsList = new ArrayList<>();

    public ComicsListModel(int offset, int limit, int total, int count, List<ComicModel> comicsList) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.comicsList = comicsList;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ComicModel> getComicsList() {
        return comicsList;
    }

    public void setComicsList(List<ComicModel> comicsList) {
        this.comicsList = comicsList;
    }

    protected ComicsListModel(Parcel in) {
        offset = in.readInt();
        limit = in.readInt();
        total = in.readInt();
        count = in.readInt();
        if (in.readByte() == 0x01) {
            comicsList = new ArrayList<ComicModel>();
            in.readList(comicsList, ComicModel.class.getClassLoader());
        } else {
            comicsList = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(offset);
        dest.writeInt(limit);
        dest.writeInt(total);
        dest.writeInt(count);
        if (comicsList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(comicsList);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ComicsListModel> CREATOR = new Parcelable.Creator<ComicsListModel>() {
        @Override
        public ComicsListModel createFromParcel(Parcel in) {
            return new ComicsListModel(in);
        }

        @Override
        public ComicsListModel[] newArray(int size) {
            return new ComicsListModel[size];
        }
    };
}