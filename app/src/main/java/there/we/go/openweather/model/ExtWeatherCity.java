package there.we.go.openweather.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * @author Vladislav Falzan.
 */

public class ExtWeatherCity extends RealmObject {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }
}
