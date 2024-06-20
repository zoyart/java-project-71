package hexlet.code.formatters;

import hexlet.code.Node;

import java.io.IOException;
import java.util.TreeMap;

public class Formatter {
    /***
     * Метод преобразует данные в выбранный/поддерживаемый формат.
     *
     * @param diffData данные для преобразования
     * @param format формат выходных данных
     * @return строка в выбранном формате
     * @throws IOException если формат не поддерживается
     */
    public static String format(TreeMap<String, Node> diffData, String format) throws IOException {
        return switch (format) {
            case "stylish" -> StylishFormat.generate(diffData);
            case "plain" -> PlainFormat.generate(diffData);
            case "json" -> JsonFormat.generate(diffData);
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}
