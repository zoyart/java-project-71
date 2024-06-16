package hexlet.code.formatters;

import java.util.Map;

public class PlaneFormat {
    public static String generate(Map<String, Map<String, Object>> diffData) {
        StringBuilder builder = new StringBuilder();
        diffData.forEach((key, data) -> {
            String status = data.get("status").toString();
            switch (status) {
                case "added":
                    createTextForAdded(builder, key, data);
                    break;
                case "removed":
                    createTextForRemoved(builder, key, data);
                    break;
                case "updated":
                    createTextForUpdated(builder, key, data);
                    break;
                default:
            }
        });
        return builder.toString();
    }

    public static void createTextForAdded(StringBuilder builder, String key, Map<String, Object> data) {
        Object value = (boolean) data.getOrDefault("valueIsComplex", false)
                ? "[complex value]"
                : data.get("value");
        builder.append("Property '").append(key).append("' was added with value: '").append(value)
                .append("'\n");
    }

    public static void createTextForRemoved(StringBuilder builder, String key, Map<String, Object> data) {
        builder.append("Property '").append(key).append("' was removed\n");
    }

    public static void createTextForUpdated(StringBuilder builder, String key, Map<String, Object> data) {
        Object oldValue = (boolean) data.get("oldValueIsComplex")
                ? "[complex value]"
                : data.get("oldValue");
        Object newValue = (boolean) data.get("newValueIsComplex")
                ? "[complex value]"
                : data.get("newValue");
        builder.append("Property '").append(key).append("' was updated. From ").append(oldValue)
                .append(" to ")
                .append(newValue)
                .append("\n");
    }
}
