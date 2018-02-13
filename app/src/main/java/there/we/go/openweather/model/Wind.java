package there.we.go.openweather.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * @author Vladislav Falzan.
 */

public class Wind extends RealmObject {

    @SerializedName("speed")
    private double mSpeed;

    public double getSpeed() {
        return mSpeed;
    }

    public void setSpeed(double mSpeed) {
        this.mSpeed = mSpeed;
    }
}
