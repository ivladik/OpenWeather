package there.we.go.openweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Vladislav Falzan.
 */

public class CitiesResponse {

    @SerializedName("list")
    private List<City> mCities;

    public List<City> getCities() {
        return mCities;
    }
}
