package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.PlaneFormat;
import hexlet.code.formatters.StylishFormat;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Map<String, Object>> diffData, String format) throws
            IllegalArgumentException, JsonProcessingException {
        return switch (format) {
            case "stylish" -> StylishFormat.generate(diffData);
            case "plane" -> PlaneFormat.generate(diffData);
            case "json" -> JsonFormat.generate(diffData);
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}
