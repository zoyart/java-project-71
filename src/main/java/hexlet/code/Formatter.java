package hexlet.code;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Map<String, Object>> diffData, String format) throws
            IllegalArgumentException {
        return switch (format) {
            case "stylish" -> stylish(diffData);
            case "plane" -> plane(diffData);
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }

    public static String plane(Map<String, Map<String, Object>> diffData) {
        StringBuilder builder = new StringBuilder();
        diffData.forEach((key, data) -> {
            String status = data.get("status").toString();
            switch (status) {
                case "added":
                    builder.append("Property '")
                            .append(key)
                            .append("' was added with value: '")
                            .append(data.get("value"))
                            .append("'\n");
                    break;
                case "removed":
                    builder.append("Property '")
                            .append(key)
                            .append("' was removed\n");
                    break;
                case "updated":
                    builder.append("Property '")
                            .append(key)
                            .append("' was updated. From ")
                            .append(data.get("oldValue"))
                            .append(" to ")
                            .append(data.get("newValue"))
                            .append("\n");
                    break;
                default:
            }
        });

        return builder.toString();
    }

    public static String stylish(Map<String, Map<String, Object>> diffData) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        diffData.forEach((key, data) -> {
            String status = data.get("status").toString();
            switch (status) {
                case "added":
                    builder.append("  + ").append(key).append(": ").append(data.get("value")).append("\n");
                    break;
                case "removed":
                    builder.append("  - ").append(key).append(": ").append(data.get("value")).append("\n");
                    break;
                case "immutable":
                    builder.append("    ").append(key).append(": ").append(data.get("value")).append("\n");
                    break;
                case "updated":
                    builder.append("  - ").append(key).append(": ").append(data.get("oldValue")).append("\n");
                    builder.append("  + ").append(key).append(": ").append(data.get("newValue")).append("\n");
                    break;
                default:
                    break;
            }
        });
        builder.append("}");

        return builder.toString();
    }
}
