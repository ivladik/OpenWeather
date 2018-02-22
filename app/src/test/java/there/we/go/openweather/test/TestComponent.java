package there.we.go.openweather.test;

import there.we.go.openweather.di.AppComponent;
import there.we.go.openweather.screen.cities.CitiesPresenter;
import there.we.go.openweather.screen.details.DetailsPresenter;

/**
 * @author Vladislav Falzan.
 */

public class TestComponent implements AppComponent {

    @Override
    public void injectCitiesPresenter(CitiesPresenter citiesPresenter) {

    }

    @Override
    public void injectDetailsPresenter(DetailsPresenter detailsPresenter) {

    }
}
