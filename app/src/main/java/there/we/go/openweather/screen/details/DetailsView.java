package there.we.go.openweather.screen.details;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import there.we.go.openweather.model.ExtWeather;
import there.we.go.openweather.screen.general.LoadingView;

/**
 * @author Vladislav Falzan.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface DetailsView extends LoadingView {

    void showDetails(List<ExtWeather> extWeather);

    void showError();
}
