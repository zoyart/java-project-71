package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

class Differ {
    public static String generate(String path1, String path2) throws IOException, SecurityException {
        String textPath1 = getFileText(path1);
        String textPath2 = getFileText(path2);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> values1 = mapper.readValue(textPath1, Map.class);
        Map<String, Object> values2 = mapper.readValue(textPath2, Map.class);

        Map<String, Object> valuesDiff = new LinkedHashMap<>();

        // Сбор уникальных ключей из двух коллекций их сортировка и перебор
        List<String> uniqueValues = new LinkedList<>(CollectionUtils.union(values1.keySet(), values2.keySet()));
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

        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        valuesDiff.forEach((key, value) -> builder.append("  ").append(key).append(": ").append(value).append("\n"));
        builder.append("}");

        return builder.toString();
    }

    public static String getFileText(String path) throws IOException, SecurityException {
        return Files.readString(Paths.get(path.trim()));
    }
}
