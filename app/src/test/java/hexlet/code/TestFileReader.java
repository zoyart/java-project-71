package hexlet.code;

import hexlet.code.utils.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFileReader {
    @Test
    public void getFileExtensionTest() throws IOException {
        String expected1 = "json";
        String actual1 = FileReader.getFileExtension("src/test/resources/fixtures/file1.json");
        assertEquals(expected1, actual1);

        String expected2 = "yml";
        String actual2 = FileReader.getFileExtension("src/test/resources/fixtures/file1.yml");
        assertEquals(expected2, actual2);
    }

    @Test
    public void getFileTextTest() throws IOException {
        String expected1 = FileReader.getFileText("src/test/resources/fixtures/expected/readFile1Json.txt");

        // Test relative path
        String relativePath = "src/test/resources/fixtures/file1.json";
        String actual1 = FileReader.getFileText(relativePath);
        assertEquals(expected1, actual1);

        // Test absolute path
        String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();
        String actual2 = FileReader.getFileText(absolutePath);
        assertEquals(expected1, actual2);
    }
}
