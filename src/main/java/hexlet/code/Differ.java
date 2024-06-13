package hexlet.code;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;

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
        Map<String, Map<String, Object>> diffData = new LinkedHashMap<>();

        uniqueValues.sort(Comparator.naturalOrder());

        uniqueValues.forEach(key -> {
            Object value1 = values1.get(key);
            Object value2 = values2.get(key);
            Map<String, Object> data = new LinkedHashMap<>();
            if (values1.containsKey(key) && values2.containsKey(key)) {
                if (Objects.equals(value1, value2)) {
                    data.put("status", "immutable");
                    data.put("value", value1);
                    diffData.put(key, data);
                } else {
                    data.put("status", "updated");
                    data.put("oldValue", value1);
                    data.put("newValue", value2);
                    diffData.put(key, data);
                }
            } else if (values1.containsKey(key)) {
                data.put("status", "removed");
                data.put("value", value1);
                diffData.put(key, data);
            } else {
                data.put("status", "added");
                data.put("value", value2);
                diffData.put(key, data);
            }
        });

        return Formatter.format(diffData, format);
    }
}
