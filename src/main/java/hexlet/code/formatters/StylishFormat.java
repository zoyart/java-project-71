package hexlet.code.formatters;

import java.util.Map;

public class StylishFormat {
    public static String generate(Map<String, Map<String, Object>> diffData) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        diffData.forEach((key, data) -> {
            String status = data.get("status").toString();
            switch (status) {
                case "added":
                    createTextForAdded(builder, key, data);
                    break;
                case "removed":
                    createTextForRemoved(builder, key, data);
                    break;
                case "immutable":
                    createTextForImmutable(builder, key, data);
                    break;
                case "updated":
                    createTextForUpdated(builder, key, data);
                    break;
                default:
                    break;
            }
        });
        builder.append("}");

        return builder.toString();
    }

    public static void createTextForAdded(StringBuilder builder, String key, Map<String, Object> data) {
        Object value = (boolean) data.getOrDefault("valueIsComplex", false)
                ? "[complex value]"
                : data.get("value");
        builder.append("  + ").append(key).append(": ").append(value).append("\n");
    }

    public static void createTextForRemoved(StringBuilder builder, String key, Map<String, Object> data) {
        Object value = (boolean) data.getOrDefault("valueIsComplex", false)
                ? "[complex value]"
                : data.get("value");
        builder.append("  - ").append(key).append(": ").append(value).append("\n");
    }

    public static void createTextForUpdated(StringBuilder builder, String key, Map<String, Object> data) {
        Object oldV = (boolean) data.get("oldValueIsComplex") ? "[complex value]" : data.get("oldValue");
        Object newV = (boolean) data.get("newValueIsComplex") ? "[complex value]" : data.get("newValue");
        builder.append("  - ").append(key).append(": ").append(oldV).append("\n");
        builder.append("  + ").append(key).append(": ").append(newV).append("\n");
    }

    public static void createTextForImmutable(StringBuilder builder, String key, Map<String, Object> data) {
        Object value = (boolean) data.getOrDefault("valueIsComplex", false)
                ? "[complex value]"
                : data.get("value");
        builder.append("    ").append(key).append(": ").append(value).append("\n");
    }
}
