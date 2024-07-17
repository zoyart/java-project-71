package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.Node;

import java.util.TreeMap;

public interface Format {
    String generate(TreeMap<String, Node> node) throws JsonProcessingException;
}
