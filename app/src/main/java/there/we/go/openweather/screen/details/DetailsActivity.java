package there.we.go.openweather.screen.details;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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
import there.we.go.openweather.screen.details.adapters.DetailsHorizontalAdapter;
import there.we.go.openweather.screen.details.adapters.DetailsVerticalAdapter;
import there.we.go.openweather.screen.general.LoadingDialog;
import there.we.go.openweather.screen.general.LoadingView;

public class DetailsActivity extends MvpAppCompatActivity implements DetailsView {

    private static final String CITY_ID_KEY = "city_id_key";

    private LoadingView mLoadingView;

    @InjectPresenter
    DetailsPresenter mDetailsPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.horizontalRV)
    RecyclerView mHorizontalRecyclerView;

    @BindView(R.id.verticalRV)
    RecyclerView mVerticalRecyclerView;

    DetailsHorizontalAdapter mHorizontalAdapter;
    DetailsVerticalAdapter mVerticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mDetailsPresenter.setCityId(getIntent().getStringExtra(CITY_ID_KEY)); // TODO: is it correct?

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        RecyclerView.LayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mHorizontalRecyclerView.setLayoutManager(horizontalLayoutManager);
        mHorizontalAdapter = new DetailsHorizontalAdapter();
        mHorizontalRecyclerView.setAdapter(mHorizontalAdapter);

        RecyclerView.LayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mVerticalRecyclerView.setLayoutManager(verticalLayoutManager);
        mVerticalAdapter = new DetailsVerticalAdapter();
        mVerticalRecyclerView.setAdapter(mVerticalAdapter);
    }

    public static void start(Activity activity, City city) {
        Intent intent = new Intent(activity, DetailsActivity.class);
        intent.putExtra(CITY_ID_KEY, String.valueOf(city.getId()));
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
        mHorizontalAdapter.changeDataSet(extWeather);
        mVerticalAdapter.changeDataSet(extWeather);
    }

    @Override
    public void showError() {
        mHorizontalAdapter.clear();
        mVerticalAdapter.clear();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
