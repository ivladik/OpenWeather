package there.we.go.openweather.screen.cities;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import there.we.go.openweather.model.City;
import there.we.go.openweather.screen.general.LoadingView;

/**
 * @author Vladislav Falzan.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface CitiesView extends LoadingView {

    void showCities(List<City> cities);

    void showError();

    @StateStrategyType(SkipStrategy.class)
    void openDetailsScreen(City city);
}
