package there.we.go.openweather.screen.details;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import there.we.go.openweather.di.AppComponent;
import there.we.go.openweather.model.ExtWeather;
import there.we.go.openweather.repository.WeatherRepository;
import there.we.go.openweather.test.TestComponent;
import there.we.go.openweather.test.TestComponentRule;
import there.we.go.openweather.test.WeatherSampleTestRunner;

import static org.mockito.Mockito.when;

/**
 * @author Vladislav Falzan.
 */
@RunWith(WeatherSampleTestRunner.class)
public class DetailsPresenterTest {

    @Mock
    WeatherRepository weatherRepository;

    @Rule
    public TestComponentRule testComponentRule = new TestComponentRule(testAppComponent());

    @Mock
    DetailsView$$State viewState;

    private DetailsPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new DetailsPresenter();
        presenter.setViewState(viewState);

        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxAndroidPlugins.reset();
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Test
    public void details_shouldOnAttachLoadAndShowDetails() {
        String cityId = getCityId();
        List<ExtWeather> extWeather = extWeather();
        when(weatherRepository.getExtendedWeather(cityId)).thenReturn(Flowable.just(extWeather));


    }

    private List<ExtWeather> extWeather() {
        List<ExtWeather> extWeather = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            extWeather.add(new ExtWeather());
        }

        return extWeather;
    }

    private String getCityId() {
        return "000000";
    }

    private AppComponent testAppComponent() {
        return new TestComponent() {
            @Override
            public void injectDetailsPresenter(DetailsPresenter detailsPresenter) {
                detailsPresenter.mWeatherRepository = weatherRepository;
            }
        };
    }
}
