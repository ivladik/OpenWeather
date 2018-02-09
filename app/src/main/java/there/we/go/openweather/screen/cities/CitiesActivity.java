package there.we.go.openweather.screen.cities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import there.we.go.openweather.R;
import there.we.go.openweather.WeatherApp;
import there.we.go.openweather.model.City;
import there.we.go.openweather.repository.CitiesRepository;
import there.we.go.openweather.screen.general.LoadingDialog;
import there.we.go.openweather.screen.general.LoadingView;

public class CitiesActivity extends AppCompatActivity implements CitiesView, CitiesAdapter.OnItemClickListener {
    // TODO: Inject Presenter, apply Moxy
    private LoadingView mLoadingView;

    @Inject
    CitiesRepository mCitiesRepository;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    CitiesAdapter mCitiesAdapter;

    private CitiesPresenter mCitiesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mCitiesAdapter = new CitiesAdapter(this);
        mRecyclerView.setAdapter(mCitiesAdapter);

        WeatherApp.getAppComponent().injectCitiesActivity(this);

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        mCitiesPresenter = new CitiesPresenter(this, mCitiesRepository);
        mCitiesPresenter.init();
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
    public void showCities(List<City> cities) {
        mCitiesAdapter.changeDataSet(cities);
    }

    @Override
    public void showError() {
        // A stub
    }

    @Override
    public void onItemClick(View view, City city) {
        // A stub
    }
}
