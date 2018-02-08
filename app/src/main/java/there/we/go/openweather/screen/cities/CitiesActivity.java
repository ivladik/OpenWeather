package there.we.go.openweather.screen.cities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import there.we.go.openweather.R;

public class CitiesActivity extends AppCompatActivity {
    // TODO: Inject Presenter, apply Moxy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
    }
}
