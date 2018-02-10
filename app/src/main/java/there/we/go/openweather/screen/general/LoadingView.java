package there.we.go.openweather.screen.general;

import com.arellomobile.mvp.MvpView;

/**
 * @author Vladislav Falzan.
 */

public interface LoadingView extends MvpView {

    void showLoadingIndicator();

    void hideLoadingIndicator();
}
