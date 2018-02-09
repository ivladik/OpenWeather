package there.we.go.openweather.api;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import there.we.go.openweather.model.CitiesResponse;
import there.we.go.openweather.model.City;

/**
 * @author Vladislav Falzan.
 */

public interface CitiesService {
    @GET("data/2.5/group?units=metric")
    Flowable<CitiesResponse> getWeather(@Query("id") String citiesIds);
}
