package id.dayhard.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ocittwo on 8/5/16.
 */
public class Data implements Parcelable{
    public String name;
    public String email;

    protected Data(Parcel in) {
        name = in.readString();
        email = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
    }
}
