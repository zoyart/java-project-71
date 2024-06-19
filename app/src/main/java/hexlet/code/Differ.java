package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.io.IOException;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Differ {
    public static String generate(String path1, String path2, String format) throws IOException {
        Map<String, Object> data1 = Parser.parseInMap(path1);
        Map<String, Object> data2 = Parser.parseInMap(path2);

        TreeMap<String, Node> differences = new TreeMap<>();

        data1.forEach((key, value) -> {
            // Если в data1 и data2 есть ключ
            if (data2.containsKey(key)) {
                // Если они не равны, значит ключ обновлён
                if (!Objects.equals(value, data2.get(key))) {
                    differences.put(key, new Node(OperationType.UPDATED, value, data2.get(key)));
                } else { // Если они равны, значит ключ не был изменён
                    differences.put(key, new Node(OperationType.UNCHANGED, value, value));
                }
            } else { // Если в data2 нет текущего ключа, значит он был удалён
                differences.put(key, new Node(OperationType.DELETED, value, null));
            }
        });

        data2.forEach((key, value) -> {
            // Если в data1 нет текущего ключа, значит он был добавлен
            if (!data1.containsKey(key)) {
                differences.put(key, new Node(OperationType.ADDED, null, value));
            }
        });

        return Formatter.format(differences, format);
    }

    public static String generate(String path1, String path2) throws IOException {
        return generate(path1, path2, "stylish");
    }
}
