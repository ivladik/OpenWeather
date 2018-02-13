package there.we.go.openweather.screen.cities;

import java.util.List;

import there.we.go.openweather.model.City;
import there.we.go.openweather.screen.general.LoadingView;

/**
 * @author Vladislav Falzan.
 */

public interface CitiesView extends LoadingView {

    void showCities(List<City> cities);

    void showError();

    void openDetailsScreen(City city);
}
