package there.we.go.openweather.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by User on 02.02.2018.
 */

public class Main extends RealmObject {

    @SerializedName("temp")
    private double mTemp;

    @SerializedName("pressure")
    private double mPressure;

    @SerializedName("humidity")
    private double mHumidity;

    public double getTemp() {
        return mTemp;
    }

    public double getPressure() {
        return mPressure;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setTemp(double mTemp) {
        this.mTemp = mTemp;
    }

    public void setPressure(double mPressure) {
        this.mPressure = mPressure;
    }

    public void setHumidity(double mHumidity) {
        this.mHumidity = mHumidity;
    }
}
