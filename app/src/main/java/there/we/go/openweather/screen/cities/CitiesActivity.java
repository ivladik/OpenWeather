package there.we.go.openweather.screen.cities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import there.we.go.openweather.R;
import there.we.go.openweather.model.City;
import there.we.go.openweather.screen.general.LoadingDialog;
import there.we.go.openweather.screen.general.LoadingView;

public class CitiesActivity extends MvpAppCompatActivity implements CitiesView, CitiesAdapter.OnItemClickListener {
    // TODO: RefreshLayout
    private LoadingView mLoadingView;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    CitiesAdapter mCitiesAdapter;

    @InjectPresenter
    CitiesPresenter mCitiesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mCitiesAdapter = new CitiesAdapter(this);
        mRecyclerView.setAdapter(mCitiesAdapter);

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());
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
        mCitiesAdapter.clear();
    }

    @Override
    public void onItemClick(View view, City city) {
        // A temporary stub
    }
}
