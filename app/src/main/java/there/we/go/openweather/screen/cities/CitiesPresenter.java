package there.we.go.openweather.screen.cities;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import there.we.go.openweather.WeatherApp;
import there.we.go.openweather.repository.CitiesRepository;

/**
 * @author Vladislav Falzan.
 */

@InjectViewState
public class CitiesPresenter extends MvpPresenter<CitiesView> {

    @Inject
    CitiesRepository mCitiesRepository;

    public CitiesPresenter() {
        WeatherApp.getAppComponent().injectCitiesPresenter(this);
    }

    public void init() {
        mCitiesRepository.getCities()
                .doOnSubscribe(subscription -> getViewState().showLoadingIndicator())
                // TODO: subscription managing?
                .doOnTerminate(getViewState()::hideLoadingIndicator)
                .subscribe(getViewState()::showCities,
                        throwable -> getViewState().showError());
    }
}