package there.we.go.openweather.repository;

import java.util.List;

import io.reactivex.Flowable;
import there.we.go.openweather.model.City;

/**
 * @author Vladislav Falzan.
 */

public interface CitiesRepository {

    Flowable<List<City>> getCities();
}
