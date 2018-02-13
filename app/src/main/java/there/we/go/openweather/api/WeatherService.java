package there.we.go.openweather.api;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import there.we.go.openweather.model.CitiesResponse;
import there.we.go.openweather.model.ExtWeatherResponse;

/**
 * @author Vladislav Falzan.
 */

public interface WeatherService {
    @GET("data/2.5/group?units=metric")
    Flowable<CitiesResponse> getCitiesWeather(@Query("id") String citiesIds);

    @GET("data/2.5/forecast?units=metric")
    Flowable<ExtWeatherResponse> getExtendedWeather(@Query("id") String cityId);
}
