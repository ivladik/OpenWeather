package there.we.go.openweather.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import there.we.go.openweather.BuildConfig;
import there.we.go.openweather.api.ApiKeyInterceptor;
import there.we.go.openweather.api.WeatherService;
import there.we.go.openweather.repository.DefaultWeatherRepository;
import there.we.go.openweather.repository.WeatherRepository;

/**
 * @author Vladislav Falzan.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    WeatherRepository provideCitiesRepository(
            WeatherService weatherService) {
        return new DefaultWeatherRepository(weatherService);
    }

    @Provides
    @Singleton
    WeatherService provideCitiesService(Retrofit retrofit) {
        return retrofit.create(WeatherService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .addInterceptor(new ApiKeyInterceptor())
                .build();
    }

    @Provides
    @Singleton
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }
}
