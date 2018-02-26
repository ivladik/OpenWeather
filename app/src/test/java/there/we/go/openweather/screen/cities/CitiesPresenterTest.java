package there.we.go.openweather.screen.cities;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import there.we.go.openweather.di.AppComponent;
import there.we.go.openweather.model.City;
import there.we.go.openweather.repository.WeatherRepository;
import there.we.go.openweather.test.TestComponent;
import there.we.go.openweather.test.TestComponentRule;
import there.we.go.openweather.test.WeatherSampleTestRunner;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Vladislav Falzan.
 */
@RunWith(WeatherSampleTestRunner.class)
public class CitiesPresenterTest {

    @Mock
    WeatherRepository weatherRepository;

    @Rule
    public TestComponentRule testComponentRule = new TestComponentRule(testAppComponent());

    @Mock
    CitiesView$$State viewState;

    private CitiesPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new CitiesPresenter();
        presenter.setViewState(viewState);

        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxAndroidPlugins.reset();
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Test
    public void cities_shouldOnAttachLoadAndShowCities() {
        List<City> cities = cities();
        when(weatherRepository.getCitiesWeather()).thenReturn(Flowable.just(cities));

        presenter.onFirstViewAttach();
        verify(viewState).showLoadingIndicator();
        verify(viewState).hideLoadingIndicator();
        verify(viewState).showCities(cities);
        verify(viewState, never()).showError();
    }

    @Test
    public void cities_shouldShowErrorIfSomeExceptionHappened() {
        RuntimeException exception = new RuntimeException();
        when(weatherRepository.getCitiesWeather()).thenReturn(Flowable.error(exception));

        presenter.onFirstViewAttach();
        verify(viewState).showLoadingIndicator();
        verify(viewState).hideLoadingIndicator();
        verify(viewState).showError();
        verify(viewState, never()).showCities(anyList());
    }

    private List<City> cities() {
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cities.add(new City());
        }

        return cities;
    }

    private AppComponent testAppComponent() {
        return new TestComponent() {
            @Override
            public void injectCitiesPresenter(CitiesPresenter citiesPresenter) {
                citiesPresenter.mWeatherRepository = weatherRepository;
            }
        };
    }
}
