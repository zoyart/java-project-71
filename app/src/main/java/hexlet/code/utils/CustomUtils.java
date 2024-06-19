package hexlet.code.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class CustomUtils {
    public static boolean isComplexValue(Object value) {
        return value instanceof LinkedHashMap<?, ?>
                || value instanceof LinkedList<?>
                || value instanceof ArrayList<?>;
    }
}
