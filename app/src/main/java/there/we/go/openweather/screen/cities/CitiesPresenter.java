package there.we.go.openweather.screen.cities;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import there.we.go.openweather.WeatherApp;
import there.we.go.openweather.model.City;
import there.we.go.openweather.repository.CitiesRepository;

/**
 * @author Vladislav Falzan.
 */

@InjectViewState
public class CitiesPresenter extends MvpPresenter<CitiesView> {
    // TODO: BasePresenter - move CompositeDisposable there
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    CitiesRepository mCitiesRepository;

    public CitiesPresenter() {
        WeatherApp.getAppComponent().injectCitiesPresenter(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        init();
    }

    public void init() {
        Disposable disposable = mCitiesRepository.getCities()
                        .doOnSubscribe(subscription -> getViewState().showLoadingIndicator())
                        .doOnTerminate(getViewState()::hideLoadingIndicator)
                        .subscribe(getViewState()::showCities,
                                throwable -> getViewState().showError());

        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

    public void onItemClick(City city) {
        getViewState().openDetailsScreen(city);
    }
}