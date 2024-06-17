package hexlet.code.formatters;

import java.util.Map;

public class StylishFormat {
    public static String generate(Map<String, Map<String, Object>> diffData) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        diffData.forEach((key, data) -> {
            String status = data.get("status").toString();
            Object value = (boolean) data.getOrDefault("valueIsComplex", false)
                    ? "[complex value]"
                    : data.get("value");
            switch (status) {
                case "added":
                    builder.append("  + ").append(key).append(": ").append(value).append("\n");
                    break;
                case "removed":
                    builder.append("  - ").append(key).append(": ").append(value).append("\n");
                    break;
                case "immutable":
                    builder.append("    ").append(key).append(": ").append(value).append("\n");
                    break;
                case "updated":
                    Object oldV = (boolean) data.get("oldValueIsComplex") ? "[complex value]" : data.get("oldValue");
                    Object newV = (boolean) data.get("newValueIsComplex") ? "[complex value]" : data.get("newValue");
                    builder.append("  - ").append(key).append(": ").append(oldV).append("\n");
                    builder.append("  + ").append(key).append(": ").append(newV).append("\n");
                    break;
                default:
                    break;
            }
        });
        builder.append("}");

        return builder.toString();
    }
}
