package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.utils.FileReader;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parseInMap(String filePath) throws IOException {
        String text = FileReader.getFileText(filePath);
        String fileExtension = FileReader.getFileExtension(filePath);
        ObjectMapper mapper;

        mapper = switch (fileExtension) {
            case "json" -> new ObjectMapper();
            case "yml" -> new YAMLMapper();
            default -> throw new IllegalArgumentException("Unsupported file type: " + fileExtension);
        };

        return mapper.readValue(text, Map.class);
    }
}
