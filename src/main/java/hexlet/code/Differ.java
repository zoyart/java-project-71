package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;
import java.util.Objects;

class Differ {
    public static String generate(String path1, String path2, String format) throws IOException,
                                                                                    IllegalArgumentException {
        Map<String, Object> values1 = Parser.parse(path1);
        Map<String, Object> values2 = Parser.parse(path2);

        List<String> uniqueValues = new LinkedList<>(CollectionUtils.union(values1.keySet(), values2.keySet()));
        uniqueValues.sort(Comparator.naturalOrder());

        Map<String, Map<String, Object>> differData = new LinkedHashMap<>();

        uniqueValues.forEach(key -> {
            differData.put(key, generateKeyData(key, values1, values2));
        });

        return Formatter.format(differData, format);
    }

    public static boolean isComplexValue(Object value) {
        return value instanceof LinkedHashMap<?,?> ||
                value instanceof LinkedList<?> ||
                value instanceof ArrayList<?>;
    }

    public static Map<String, Object> generateKeyData(String key,
                                                      Map<String, Object> values1,
                                                      Map<String, Object> values2) {
        Object value1 = values1.get(key);
        Object value2 = values2.get(key);
        Map<String, Object> keyData = new LinkedHashMap<>();

        if (values1.containsKey(key) && values2.containsKey(key)) {
            if (Objects.equals(value1, value2)) {
                keyData.put("status", "immutable");
                keyData.put("value", value1);
                keyData.put("valueIsComplex", isComplexValue(value1));
            } else {
                keyData.put("status", "updated");
                keyData.put("oldValue", value1);
                keyData.put("oldValueIsComplex", isComplexValue(value1));
                keyData.put("newValue", value2);
                keyData.put("newValueIsComplex", isComplexValue(value2));
            }
        } else if (values1.containsKey(key)) {
            keyData.put("status", "removed");
            keyData.put("value", value1);
            keyData.put("valueIsComplex", isComplexValue(value1));
        } else {
            keyData.put("status", "added");
            keyData.put("value", value2);
            keyData.put("valueIsComplex", isComplexValue(value2));
        }

        return keyData;
    }
}
