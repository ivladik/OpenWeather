package there.we.go.openweather.repository;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;
import there.we.go.openweather.BuildConfig;
import there.we.go.openweather.api.WeatherService;
import there.we.go.openweather.model.CitiesResponse;
import there.we.go.openweather.model.City;

/**
 * @author Vladislav Falzan.
 */

public class DefaultCitiesRepository implements CitiesRepository {

    private final WeatherService mWeatherService;

    public DefaultCitiesRepository(WeatherService weatherService) {
        mWeatherService = weatherService;
    }


    @Override
    public Flowable<List<City>> getCities() {
        return mWeatherService.getCitiesWeather(BuildConfig.API_CITIES_IDS)
                .map(CitiesResponse::getCities)
                .flatMap(cities -> {
                    Realm.getDefaultInstance().executeTransaction(realm -> {
                        realm.delete(City.class);
                        realm.insert(cities);
                    });

                    return Flowable.just(cities);
                })
                .onErrorResumeNext(throwable -> {
                    Realm realm = Realm.getDefaultInstance();
                    RealmResults<City> results = realm.where(City.class).findAll();

                    return Flowable.just(realm.copyFromRealm(results));
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}