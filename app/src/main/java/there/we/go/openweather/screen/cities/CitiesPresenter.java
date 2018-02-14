package there.we.go.openweather.screen.cities;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import there.we.go.openweather.WeatherApp;
import there.we.go.openweather.model.City;
import there.we.go.openweather.repository.WeatherRepository;

/**
 * @author Vladislav Falzan.
 */

@InjectViewState
public class CitiesPresenter extends MvpPresenter<CitiesView> {
    // TODO: BasePresenter - move CompositeDisposable there
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Inject
    WeatherRepository mWeatherRepository;

    public CitiesPresenter() {
        WeatherApp.getAppComponent().injectCitiesPresenter(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        init();
    }

    private void init() {
        Disposable disposable = mWeatherRepository.getCitiesWeather()
                        .doOnSubscribe(subscription -> getViewState().showLoadingIndicator())
                        .doOnTerminate(getViewState()::hideLoadingIndicator)
                        .subscribe(getViewState()::showCities,
                                throwable -> getViewState().showError());

        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }

    public void onItemClick(City city) {
        getViewState().openDetailsScreen(city);
    }
}