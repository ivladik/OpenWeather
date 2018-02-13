package there.we.go.openweather.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author Vladislav Falzan.
 */

public class City extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("dt")
    private long mDateTime;

    @SerializedName("weather")
    private RealmList<Weather> mWeather;

    @SerializedName("main")
    private Main mMain;

    @SerializedName("wind")
    private Wind mWind;

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public RealmList<Weather> getWeather() {
        return mWeather;
    }

    public Main getMain() {
        return mMain;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setWeather(RealmList<Weather> mWeather) {
        this.mWeather = mWeather;
    }

    public void setMain(Main mMain) {
        this.mMain = mMain;
    }

    public void setWind(Wind mWind) {
        this.mWind = mWind;
    }

    public long getDateTime() {
        return mDateTime;
    }

    public void setDateTime(long mDateTime) {
        this.mDateTime = mDateTime;
    }
}
