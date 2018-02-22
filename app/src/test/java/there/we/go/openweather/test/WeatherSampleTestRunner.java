package there.we.go.openweather.test;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Method;

import there.we.go.openweather.BuildConfig;

/**
 * @author Vladislav Falzan.
 */

public class WeatherSampleTestRunner extends RobolectricTestRunner {

    private static final int SDK_EMULATE_LEVEL = 23;

    public WeatherSampleTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    public Config getConfig(Method method) {
        final Config defaultConfig = super.getConfig(method);

        return new Config.Implementation(
                new int[]{SDK_EMULATE_LEVEL},
                defaultConfig.manifest(),
                defaultConfig.qualifiers(),
                defaultConfig.packageName(),
                defaultConfig.resourceDir(),
                defaultConfig.assetDir(),
                defaultConfig.shadows(),
                defaultConfig.application(),
                defaultConfig.libraries(),
                defaultConfig.constants() == Void.class ? BuildConfig.class : defaultConfig.constants());
    }
}
