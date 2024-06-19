package hexlet.code.formatters;

import hexlet.code.Node;
import hexlet.code.OperationType;
import hexlet.code.utils.CustomUtils;

import java.util.TreeMap;

public class PlaneFormat {
    private static final String COMPLEX_VALUE = "[complex value]";
    private static final String PROPERTY_PREFIX = "Property '";

    public static String generate(TreeMap<String, Node> diffData) throws IllegalStateException {
        StringBuilder builder = new StringBuilder();
        diffData.forEach((key, node) -> {
            OperationType type = node.getType();
            Object oldValue = CustomUtils.isComplexValue(node.getOldValue())
                    ? COMPLEX_VALUE
                    : "'" + node.getOldValue() + "'";
            Object newValue = CustomUtils.isComplexValue(node.getNewValue())
                    ? COMPLEX_VALUE
                    : "'" + node.getNewValue() + "'";

            switch (type) {
                case OperationType.ADDED:
                    appendAdded(builder, key, newValue);
                    break;
                case OperationType.DELETED:
                    appendDeleted(builder, key);
                    break;
                case OperationType.UPDATED:
                    appendUpdated(builder, key, newValue, oldValue);
                    break;
                default:
                    // Default is empty because operationType has UNCHANGED, and default will respond to it
            }
        });
        return builder.toString();
    }

    private static void appendAdded(StringBuilder builder, String key, Object newValue) {
        builder.append(PROPERTY_PREFIX)
                .append(key)
                .append("' was added with value: ")
                .append(newValue)
                .append("\n");
    }

    private static void appendDeleted(StringBuilder builder, String key) {
        builder.append(PROPERTY_PREFIX)
                .append(key)
                .append("' was removed\n");
    }

    private static void appendUpdated(StringBuilder builder, String key, Object newValue, Object oldValue) {
        builder.append(PROPERTY_PREFIX)
                .append(key)
                .append("' was updated. From ")
                .append(oldValue)
                .append(" to ")
                .append(newValue)
                .append("\n");
    }
}
