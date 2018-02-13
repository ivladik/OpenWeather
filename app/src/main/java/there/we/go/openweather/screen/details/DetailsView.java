package there.we.go.openweather.screen.details;

import there.we.go.openweather.screen.general.LoadingView;

/**
 * @author Vladislav Falzan.
 */

public interface DetailsView extends LoadingView {

    void showDetails();

    void showError();
}
