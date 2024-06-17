package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestParser {
    @Test
    public void parseTest() throws IOException {
        Map<String, Object> expected = new LinkedHashMap<>();
        expected.put("setting1", "Some value");
        expected.put("setting2", 200);
        expected.put("setting3", true);
        expected.put("numbers1", new ArrayList<>(List.of(1, 2, 3, 4)));
        expected.put("default", null);
        expected.put("chars1", new ArrayList<>(List.of("a", "b", "c")));

        Map<String, Object> actualJson = Parser.parse("src/test/resources/fixtures/file1.json");
        assertEquals(expected, actualJson);

        Map<String, Object> actualYml = Parser.parse("src/test/resources/fixtures/file1.yml");
        assertEquals(expected, actualYml);
    }

    @Test
    public void getFileExtensionTest() {
        String expected1 = "json";
        String actual1 = Parser.getFileExtension("src/test/resources/fixtures/file1.json");
        assertEquals(expected1, actual1);

        String expected2 = "yml";
        String actual2 = Parser.getFileExtension("src/test/resources/fixtures/file1.yml");
        assertEquals(expected2, actual2);
    }

    @Test
    public void getFileTextTest() throws IOException {
        String expected1 = """
                {
                  "setting1": "Some value",
                  "setting2": 200,
                  "setting3": true,
                  "numbers1": [1, 2, 3, 4],
                  "default": null,
                  "chars1": ["a", "b", "c"]
                }""";

        // Test relative path
        String relativePath = "src/test/resources/fixtures/file1.json";
        String actual1 = Parser.getFileText(relativePath);
        assertEquals(expected1, actual1);

        // Test absolute path
        String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();
        String actual2 = Parser.getFileText(absolutePath);
        assertEquals(expected1, actual2);

        // We catch the IOException: file not found
        // TODO: тест под сомнением
        assertThrows(IOException.class, () -> Differ.generate(
                "src/test/resources/testData/notFile1.json",
                "src/test/resources/testData/notFile2.json",
                "stylish"
        ));
    }
}
