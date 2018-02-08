package there.we.go.openweather.utils;

/**
 * @author Vladislav Falzan.
 */

public final class TextUtils {

    private TextUtils() {
    }

    public static boolean isEmpty(CharSequence text) {
        return text == null || text.length() == 0;
    }
}
