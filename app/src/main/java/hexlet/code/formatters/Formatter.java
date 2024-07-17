package hexlet.code.formatters;

import hexlet.code.Node;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import static hexlet.code.formatters.StylishFormat.STYLISH_NAME;
import static hexlet.code.formatters.PlainFormat.PLAIN_NAME;
import static hexlet.code.formatters.JsonFormat.JSON_NAME;

public class Formatter {
    public static Map<String, Format> formats = Map.of(
            STYLISH_NAME, new StylishFormat(),
            PLAIN_NAME, new PlainFormat(),
            JSON_NAME, new JsonFormat()
    );

    /***
     * Метод преобразует данные в выбранный/поддерживаемый формат.
     *
     * @param diffData данные для преобразования
     * @param format формат выходных данных
     * @return строка в выбранном формате
     * @throws IOException если формат не поддерживается
     */
    public static String format(TreeMap<String, Node> diffData, String format) throws IOException {
        return formats.get(format).generate(diffData);
    }
}
