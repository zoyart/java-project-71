package hexlet.code.formatters;

import java.util.Map;

public class PlaneFormat {
    public static String generate(Map<String, Map<String, Object>> diffData) {
        StringBuilder builder = new StringBuilder();
        diffData.forEach((key, data) -> {
            String status = data.get("status").toString();

            switch (status) {
                case "added":
                    Object value = (boolean) data.get("valueIsComplex") ? "[complex value]" : data.get("value");
                    builder.append("Property '")
                            .append(key)
                            .append("' was added with value: '")
                            .append(value)
                            .append("'\n");
                    break;
                case "removed":
                    builder.append("Property '")
                            .append(key)
                            .append("' was removed\n");
                    break;
                case "updated":
                    Object oldValue = (boolean) data.get("oldValueIsComplex") ? "[complex value]" : data.get("oldValue");
                    Object newValue = (boolean) data.get("newValueIsComplex") ? "[complex value]" : data.get("newValue");
                    builder.append("Property '")
                            .append(key)
                            .append("' was updated. From ")
                            .append(oldValue)
                            .append(" to ")
                            .append(newValue)
                            .append("\n");
                    break;
                default:
            }
        });

        return builder.toString();
    }
}
