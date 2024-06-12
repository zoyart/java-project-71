package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestParser {
    @Test
    public void parseTest() throws IOException {
        Map<String, Object> expected;
        expected = Map.of(
                "host", "hexlet.io",
                "timeout", 50,
                "proxy", "123.234.53.22",
                "follow", false
        );

        Map<String, Object> actualJson = Parser.parse("src/test/resources/testData/file1.json");
        assertEquals(expected, actualJson);

        Map<String, Object> actualYml = Parser.parse("src/test/resources/testData/file1.yml");
        assertEquals(expected, actualYml);
    }

    @Test
    public void getFileExtensionTest() {
        String expected1 = "json";
        String actual1 = Parser.getFileExtension("src/test/resources/testData/file1.json");
        assertEquals(expected1, actual1);

        String expected2 = "yml";
        String actual2 = Parser.getFileExtension("src/test/resources/testData/file1.yml");
        assertEquals(expected1, actual1);
    }

    @Test
    public void parseYmlTest() throws IOException {
    }

    @Test
    public void getFileTextTest() throws IOException {
        String expected1 = """
                {
                  "host": "hexlet.io",
                  "timeout": 50,
                  "proxy": "123.234.53.22",
                  "follow": false
                }""";

        // Test relative path
        String relativePath = "src/test/resources/testData/file1.json";
        String actual1 = Parser.getFileText(relativePath);
        assertEquals(expected1, actual1);

        // Test absolute path
        String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();
        String actual2 = Parser.getFileText(absolutePath);
        assertEquals(expected1, actual2);

        // We catch the IOException: file not found
        // TODO: тест под сомнением
        assertThrows(IOException.class, () -> {
            Differ.generate("src/test/resources/testData/notFile1.json", "src/test/resources/testData/notFile2.json");
        });
    }
}
