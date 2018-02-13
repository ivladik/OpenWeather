package there.we.go.openweather.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * @author Vladislav Falzan.
 */

public class ExtWeather extends RealmObject {

    @SerializedName("dt")
    private long mDateTime;

    @SerializedName("main")
    private Main mMain;

    @SerializedName("weather")
    private RealmList<Weather> mWeather;

    @SerializedName("wind")
    private Wind mWind;

    public long getDateTime() {
        return mDateTime;
    }

    public void setDateTime(long mDateTime) {
        this.mDateTime = mDateTime;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main mMain) {
        this.mMain = mMain;
    }

    public RealmList<Weather> getWeather() {
        return mWeather;
    }

    public void setWeather(RealmList<Weather> mWeather) {
        this.mWeather = mWeather;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind mWind) {
        this.mWind = mWind;
    }
}
