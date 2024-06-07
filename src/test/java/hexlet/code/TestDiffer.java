package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TestDiffer {
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
        String actual1 = Differ.getFileText(relativePath);
        assertEquals(expected1, actual1);

        // Test absolute path
        String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();
        String actual2 = Differ.getFileText(absolutePath);
        assertEquals(expected1, actual2);

        // We catch the IOException: file not found
        assertThrows(IOException.class, () -> Differ.generate("src/test/resources/testData/notFile1.json", "src/test/resources/testData/notFile2.json"));
    }

    @Test
    public void generateTest() throws IOException {
        String path1 = "src/test/resources/testData/file1.json";
        String path2 = "src/test/resources/testData/file2.json";
        String expected1 = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        String actual1 = Differ.generate(path1, path2);
        assertEquals(expected1, actual1);
    }
}
