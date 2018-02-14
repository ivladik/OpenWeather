package there.we.go.openweather.repository;

import java.util.List;

import io.reactivex.Flowable;
import there.we.go.openweather.model.City;
import there.we.go.openweather.model.ExtWeather;

/**
 * @author Vladislav Falzan.
 */

public interface WeatherRepository {

    Flowable<List<City>> getCitiesWeather();

    Flowable<List<ExtWeather>> getExtendedWeather(String cityId);
}
