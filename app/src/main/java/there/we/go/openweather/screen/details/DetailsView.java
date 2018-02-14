package there.we.go.openweather.screen.details;

import java.util.List;

import there.we.go.openweather.model.ExtWeather;
import there.we.go.openweather.screen.general.LoadingView;

/**
 * @author Vladislav Falzan.
 */

public interface DetailsView extends LoadingView {

    void showDetails(List<ExtWeather> extWeather);

    void showError();
}
