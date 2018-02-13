package there.we.go.openweather.screen.details;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import there.we.go.openweather.R;
import there.we.go.openweather.model.City;

public class DetailsActivity extends AppCompatActivity {

    private static final String CITY_ID_KEY = "city_id_key";

    @BindView(R.id.tvDayOne)
    TextView tvDayOne;

    @BindView(R.id.tvDayTwo)
    TextView tvDayTwo;

    @BindView(R.id.tvDayThree)
    TextView tvDayThree;

    @BindView(R.id.tvDayFour)
    TextView tvDayFour;

    @BindView(R.id.tvDayFive)
    TextView tvDayFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        int cityId = getIntent().getIntExtra(CITY_ID_KEY, -1);
    }

    public static void start(Activity activity, City city) {
        Intent intent = new Intent(activity, DetailsActivity.class);
        intent.putExtra(CITY_ID_KEY, city.getId());
        activity.startActivity(intent);
    }
}
