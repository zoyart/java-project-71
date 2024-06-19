package hexlet.code.formatters;

import hexlet.code.Node;

import java.io.IOException;
import java.util.TreeMap;

public class Formatter {
    public static String format(TreeMap<String, Node> diffData, String format) throws IOException {
        return switch (format) {
            case "stylish" -> StylishFormat.generate(diffData);
            case "plain" -> PlaneFormat.generate(diffData);
            case "json" -> JsonFormat.generate(diffData);
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}
