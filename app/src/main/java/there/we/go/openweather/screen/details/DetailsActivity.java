package there.we.go.openweather.screen.details;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import there.we.go.openweather.R;
import there.we.go.openweather.model.City;
import there.we.go.openweather.model.ExtWeather;
import there.we.go.openweather.screen.general.LoadingDialog;
import there.we.go.openweather.screen.general.LoadingView;

public class DetailsActivity extends MvpAppCompatActivity implements DetailsView {

    private static final String CITY_ID_KEY = "city_id_key";

    private LoadingView mLoadingView;

    @InjectPresenter
    DetailsPresenter mDetailsPresenter;

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
        mDetailsPresenter.setCityId(String.valueOf(cityId)); // TODO: is it correct?

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());
    }

    public static void start(Activity activity, City city) {
        Intent intent = new Intent(activity, DetailsActivity.class);
        intent.putExtra(CITY_ID_KEY, city.getId());
        activity.startActivity(intent);
    }

    @Override
    public void showLoadingIndicator() {
        mLoadingView.showLoadingIndicator();
    }

    @Override
    public void hideLoadingIndicator() {
        mLoadingView.hideLoadingIndicator();
    }

    @Override
    public void showDetails(List<ExtWeather> extWeather) {
        // TODO: RecyclerView
        tvDayOne.setText(new Date(extWeather.get(0).getDateTime()).toString());
        tvDayTwo.setText(new Date(extWeather.get(5).getDateTime()).toString());
        tvDayThree.setText(new Date(extWeather.get(10).getDateTime()).toString());
        tvDayFour.setText(new Date(extWeather.get(15).getDateTime()).toString());
        tvDayFive.setText(new Date(extWeather.get(20).getDateTime()).toString());
    }

    @Override
    public void showError() {
        tvDayOne.setText("");
        tvDayTwo.setText("");
        tvDayThree.setText("");
        tvDayFour.setText("");
        tvDayFive.setText("");
    }
}
