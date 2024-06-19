package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParser {
    public void parseTest() throws IOException {
        Map<String, Object> expected = new LinkedHashMap<>();
        expected.put("setting1", "Some value");
        expected.put("setting2", 200);
        expected.put("setting3", true);
        expected.put("numbers1", new ArrayList<>(List.of(1, 2, 3, 4)));
        expected.put("default", null);
        expected.put("chars1", new ArrayList<>(List.of("a", "b", "c")));

        Map<String, Object> actualJson = Parser.parseInMap("src/test/resources/fixtures/file1.json");
        assertEquals(expected, actualJson);

        Map<String, Object> actualYml = Parser.parseInMap("src/test/resources/fixtures/file1.yml");
        assertEquals(expected, actualYml);
    }
}
