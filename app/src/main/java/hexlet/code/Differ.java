package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.io.IOException;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Differ {
    /**
     * Метод сравнивает два файла и генерирует на их основе строку в выбранном/поддерживаемом формате.
     *
     * @param path1 путь до первого файла
     * @param path2 путь до второго файла
     * @param format формат текста, который должен быть на выходе метода
     * @return сгенерированная строка
     * @throws IOException при проблеме с чтением файла
     */
    public static String generate(String path1, String path2, String format) throws IOException {
        Map<String, Object> data1 = Parser.parseInMap(path1);
        Map<String, Object> data2 = Parser.parseInMap(path2);

        TreeMap<String, Node> differences = new TreeMap<>();

        data1.forEach((key, value) -> {
            if (data2.containsKey(key)) {
                if (!Objects.equals(value, data2.get(key))) {
                    differences.put(key, new Node(OperationType.UPDATED, value, data2.get(key)));
                } else {
                    differences.put(key, new Node(OperationType.UNCHANGED, value, value));
                }
            } else {
                differences.put(key, new Node(OperationType.DELETED, value, null));
            }
        });

        data2.forEach((key, value) -> {
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
