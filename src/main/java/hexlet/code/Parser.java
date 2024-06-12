package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws IOException {
        String text = getFileText(filePath);
        String fileExtension = getFileExtension(filePath);
        ObjectMapper mapper;

        if (fileExtension.equals("json")) {
            mapper = new ObjectMapper();
        } else {
            mapper = new YAMLMapper();
        }

        return mapper.readValue(text, Map.class);
    }

    public static String getFileText(String path) throws IOException {
        Path absolutePath = Paths.get(path).toAbsolutePath().normalize();

        if (!Files.exists(absolutePath)) {
            throw new IOException("File '" + path + "' does not exist");
        }

        return Files.readString(absolutePath);
    }

    public static String getFileExtension(String path) {
        String[] items = path.split("\\.");
        return items[items.length - 1].trim();
    }
}