package there.we.go.openweather.screen.details;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import there.we.go.openweather.WeatherApp;
import there.we.go.openweather.repository.WeatherRepository;

/**
 * @author Vladislav Falzan.
 */
@InjectViewState
public class DetailsPresenter extends MvpPresenter<DetailsView> {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private String mCityId;

    public void setCityId(String cityId) {
        this.mCityId = cityId;
    }

    @Inject
    WeatherRepository mWeatherRepository;

    public DetailsPresenter() {
        WeatherApp.getAppComponent().injectDetailsPresenter(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadDetails(mCityId);
    }

    public void loadDetails(String cityId) {
        Disposable disposable = mWeatherRepository.getExtendedWeather(cityId)
                .doOnSubscribe(subscription -> getViewState().showLoadingIndicator())
                .doOnTerminate(getViewState()::hideLoadingIndicator)
                .subscribe(getViewState()::showDetails,
                        throwable -> getViewState().showError());

        mCompositeDisposable.add(disposable);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
