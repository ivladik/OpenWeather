package there.we.go.openweather.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * @author Vladislav Falzan.
 */

public class Weather extends RealmObject {

    @SerializedName("main")
    private String mMain;

    @SerializedName("icon")
    private String mIcon;

    public String getMain() {
        return mMain;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setMain(String mMain) {
        this.mMain = mMain;
    }

    public void setIcon(String mIcon) {
        this.mIcon = mIcon;
    }
}
