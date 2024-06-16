package hexlet.code.formatters;

import java.util.Map;

public class StylishFormat {
    public static String generate(Map<String, Map<String, Object>> diffData) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        diffData.forEach((key, data) -> {
            String status = data.get("status").toString();
            Object value;
            switch (status) {
                case "added":
                    value = (boolean) data.get("valueIsComplex") ? "[complex value]" : data.get("value");
                    builder.append("  + ").append(key).append(": ").append(value).append("\n");
                    break;
                case "removed":
                    value = (boolean) data.get("valueIsComplex") ? "[complex value]" : data.get("value");
                    builder.append("  - ").append(key).append(": ").append(value).append("\n");
                    break;
                case "immutable":
                    value = (boolean) data.get("valueIsComplex") ? "[complex value]" : data.get("value");
                    builder.append("    ").append(key).append(": ").append(value).append("\n");
                    break;
                case "updated":
                    Object oldValue = (boolean) data.get("oldValueIsComplex")
                            ? "[complex value]"
                            : data.get("oldValue");
                    Object newValue = (boolean) data.get("newValueIsComplex")
                            ? "[complex value]"
                            : data.get("newValue");
                    builder.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                    builder.append("  + ").append(key).append(": ").append(newValue).append("\n");
                    break;
                default:
                    break;
            }
        });
        builder.append("}");

        return builder.toString();
    }
}
