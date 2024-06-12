package hexlet.code;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

class Differ {
    public static String generate(String path1, String path2) throws IOException {
        Map<String, Object> values1 = Parser.parse(path1);
        Map<String, Object> values2 = Parser.parse(path2);

        List<String> uniqueValues = new LinkedList<>(CollectionUtils.union(values1.keySet(), values2.keySet()));
        Map<String, Object> valuesDiff = new LinkedHashMap<>();

        uniqueValues.sort(Comparator.naturalOrder());
        uniqueValues.forEach(item -> {
            Object value1 = values1.get(item);
            Object value2 = values2.get(item);

            if (values1.containsKey(item) && values2.containsKey(item)) {
                if (value1.equals(value2)) {
                    valuesDiff.put("  " + item, value1);
                } else {
                    valuesDiff.put("- " + item, value1);
                    valuesDiff.put("+ " + item, value2);
                }
            } else if (values1.containsKey(item)) {
                valuesDiff.put("- " + item, value1);
            } else {
                valuesDiff.put("+ " + item, value2);
            }
        });

        // Формирование stylish
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        valuesDiff.forEach((key, value) -> builder.append("  ").append(key).append(": ").append(value).append("\n"));
        builder.append("}");

        return builder.toString();
    }
}
