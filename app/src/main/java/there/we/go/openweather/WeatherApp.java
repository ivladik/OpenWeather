package there.we.go.openweather;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;
import there.we.go.openweather.di.AppComponent;
import there.we.go.openweather.di.DaggerAppComponent;
import there.we.go.openweather.di.AppModule;

/**
 * @author Vladislav Falzan.
 */

public class WeatherApp extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .rxFactory(new RealmObservableFactory())
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);

        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    @VisibleForTesting
    public static void setAppComponent(AppComponent appComponent) {
        sAppComponent = appComponent;
    }
}
