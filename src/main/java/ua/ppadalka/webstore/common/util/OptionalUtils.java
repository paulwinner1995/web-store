package ua.ppadalka.webstore.common.util;

import java.util.Optional;

public class OptionalUtils {

    public static <V> V orElseDefault(V value, V defaultValue) {
        return Optional.ofNullable(value).orElse(defaultValue);
    }
}
