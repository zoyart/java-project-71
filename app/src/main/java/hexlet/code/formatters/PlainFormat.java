package hexlet.code.formatters;

import hexlet.code.Node;
import hexlet.code.OperationType;
import hexlet.code.utils.CustomUtils;

import java.util.TreeMap;

public class PlainFormat implements Format {
    private static final String COMPLEX_VALUE = "[complex value]";
    private static final String PROPERTY_PREFIX = "Property '";
    public static final String PLAIN_NAME = "plain";

    /**
     * Метод генерирует текст в формате plain.
     *
     * @param diffData данные для генерации
     * @return текст в формате plain
     * @throws IllegalStateException если не найдено элемента в OperationType
     */
    public String generate(TreeMap<String, Node> diffData) throws IllegalStateException {
        StringBuilder builder = new StringBuilder();
        diffData.forEach((key, node) -> {
            OperationType type = node.getType();
            Object oldValue = CustomUtils.isComplexValue(node.getOldValue()) ? COMPLEX_VALUE : node.getOldValue();
            Object newValue = CustomUtils.isComplexValue(node.getNewValue()) ? COMPLEX_VALUE : node.getNewValue();

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
                case OperationType.UNCHANGED:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + type);
            }

            if (diffData.headMap(key).size() + 1 != diffData.size() && type != OperationType.UNCHANGED) {
                builder.append("\n");
            }
        });

        return builder.toString();
    }

    private static void appendAdded(StringBuilder builder, String key, Object newValue) {
        builder.append(PROPERTY_PREFIX).append(key).append("' was added with value: ");
        appendValueWithQuotesIfNeeded(builder, newValue);
    }

    private static void appendDeleted(StringBuilder builder, String key) {
        builder.append(PROPERTY_PREFIX).append(key).append("' was removed");
    }

    private static void appendUpdated(StringBuilder builder, String key, Object newValue, Object oldValue) {
        builder.append(PROPERTY_PREFIX).append(key).append("' was updated. From ");
        appendValueWithQuotesIfNeeded(builder, oldValue);
        builder.append(" to ");
        appendValueWithQuotesIfNeeded(builder, newValue);
    }

    /**
     * Метод добавляет одинарные кавычки к передаваемому value, если значение является строкой.
     * Исключения: строка "[complex value]".
     *
     * @param builder StringBuilder с которым необходимо произвести операцию
     * @param value значение над которым необходимо произвести операцию
     */
    public static void appendValueWithQuotesIfNeeded(StringBuilder builder, Object value) {
        if (value instanceof String && !value.equals("[complex value]")) {
            builder.append("'").append(value).append("'");
        } else {
            builder.append(value);
        }
    }
}
