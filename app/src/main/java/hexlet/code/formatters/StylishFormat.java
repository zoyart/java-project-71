package hexlet.code.formatters;

import hexlet.code.Node;
import hexlet.code.OperationType;

import java.util.TreeMap;

public class StylishFormat implements Format {
    private static final String PLUS_PREFIX = "  + ";
    private static final String MINUS_PREFIX = "  - ";
    private static final String UNCHANGED_PREFIX = "    ";
    public static final String STYLISH_NAME = "stylish";

    /**
     * Метод генерирует текст в формате stylish.
     *
     * @param diffData данные для генерации
     * @return текст в формате stylish
     */
    public String generate(TreeMap<String, Node> diffData) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        diffData.forEach((key, node) -> {
            OperationType type = node.getType();
            Object oldValue = node.getOldValue();
            Object newValue = node.getNewValue();

            switch (type) {
                case OperationType.ADDED:
                    appendChange(builder, PLUS_PREFIX, key, newValue);
                    break;
                case OperationType.DELETED:
                    appendChange(builder, MINUS_PREFIX, key, oldValue);
                    break;
                case OperationType.UNCHANGED:
                    appendChange(builder, UNCHANGED_PREFIX, key, newValue);
                    break;
                case OperationType.UPDATED:
                    appendChange(builder, MINUS_PREFIX, key, oldValue);
                    appendChange(builder, PLUS_PREFIX, key, newValue);
                    break;
                default:
            }
        });
        builder.append("}");

        return builder.toString();
    }

    private static void appendChange(StringBuilder builder, String prefix, String key, Object value) {
        builder.append(prefix).append(key).append(": ").append(value).append("\n");
    }
}
