package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {
    @Test
    public void generateTest() throws IOException {
        String path1 = "src/test/resources/fixtures/file1.json";
        String path2 = "src/test/resources/fixtures/file2.json";

        String expected1 = """
                {
                    chars1: [complex value]
                  - default: null
                  + default: true
                  + id: null
                    numbers1: [complex value]
                  + obj1: [complex value]
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                }""";
        String actual1 = Differ.generate(path1, path2, "stylish");
        assertEquals(expected1, actual1);

        String expected2 = """
                Property 'default' was updated. From null to true
                Property 'id' was added with value: 'null'
                Property 'obj1' was added with value: '[complex value]'
                Property 'setting1' was updated. From Some value to Another value
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was removed
                """;
        String actual2 = Differ.generate(path1, path2, "plane");
        assertEquals(expected2, actual2);
    }
}
