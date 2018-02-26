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
import there.we.go.openweather.model.ExtWeather;
import there.we.go.openweather.model.ExtWeatherResponse;

/**
 * @author Vladislav Falzan.
 */

public class DefaultWeatherRepository implements WeatherRepository {
    // TODO: delete Repository, rename Service to Api, create WeatherService and move there.
    private final WeatherService mWeatherService;

    public DefaultWeatherRepository(WeatherService weatherService) {
        mWeatherService = weatherService;
    }


    @Override
    public Flowable<List<City>> getCitiesWeather() {
        return mWeatherService.getCitiesWeather(BuildConfig.API_CITIES_IDS) // TODO: move to input params
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

    @Override
    public Flowable<List<ExtWeather>> getExtendedWeather(String cityId) {
        return mWeatherService.getExtendedWeather(cityId)
                .map(ExtWeatherResponse::getWeatherList)
                .flatMap(weatherList -> {
                    Realm.getDefaultInstance().executeTransaction(realm -> {
                        realm.delete(ExtWeather.class);
                        realm.insert(weatherList);
                    });

                    return Flowable.just(weatherList);
                })
                .onErrorResumeNext(throwable -> {
                    Realm realm = Realm.getDefaultInstance();
                    RealmResults<ExtWeather> results = realm.where(ExtWeather.class).findAll();

                    return Flowable.just(realm.copyFromRealm(results));
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}