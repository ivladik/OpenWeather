package there.we.go.openweather.test;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import there.we.go.openweather.WeatherApp;
import there.we.go.openweather.di.AppComponent;

/**
 * @author Vladislav Falzan.
 */

public class TestComponentRule implements TestRule {

    private AppComponent appComponent;

    public TestComponentRule() {
        appComponent = new TestComponent();
    }

    public TestComponentRule(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                WeatherApp.setAppComponent(appComponent);
                base.evaluate();
            }
        };
    }
}
