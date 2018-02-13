package there.we.go.openweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Vladislav Falzan.
 */

public class ExtWeatherResponse {

    @SerializedName("list")
    private List<ExtWeather> mWeatherList;

    @SerializedName("city")
    private ExtWeatherCity mCity;

    public List<ExtWeather> getWeatherList() {
        return mWeatherList;
    }

    public ExtWeatherCity getCity() {
        return mCity;
    }
}
