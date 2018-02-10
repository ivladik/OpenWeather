package there.we.go.openweather.di;

import javax.inject.Singleton;

import dagger.Component;
import there.we.go.openweather.screen.cities.CitiesActivity;
import there.we.go.openweather.screen.cities.CitiesPresenter;

/**
 * @author Vladislav Falzan.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface AppComponent {

    void injectCitiesPresenter(CitiesPresenter citiesPresenter);
}
