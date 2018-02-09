package there.we.go.openweather.screen.cities;

import there.we.go.openweather.repository.CitiesRepository;

/**
 * @author Vladislav Falzan.
 */

public class CitiesPresenter {

    private final CitiesView mCitiesView;

    private final CitiesRepository mCitiesRepository;

    public CitiesPresenter(CitiesView citiesView, CitiesRepository citiesRepository) {
        mCitiesView = citiesView;
        mCitiesRepository = citiesRepository;
    }

    public void init() {
        mCitiesRepository.getCities()
                .doOnSubscribe(subscription -> mCitiesView.showLoadingIndicator())
                // TODO: subscription managing?
                .doOnTerminate(mCitiesView::hideLoadingIndicator)
                .subscribe(mCitiesView::showCities,
                        throwable -> mCitiesView.showError());
    }
}