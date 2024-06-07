package hexlet.code;

import org.apache.commons.lang3.builder.Diff;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystemException;

import static org.junit.jupiter.api.Assertions.*;

public class TestDiffer {
    @Test
    public void getFileTextTest() throws IOException {
        // TODO: как сделать проверку абсолютного пути?
        String absolutePath = "";
        String relativePath = "src/test/resources/testData/file1.json";

        // Test relative path
        String expected1 = "{\n" +
                "  \"host\": \"hexlet.io\",\n" +
                "  \"timeout\": 50,\n" +
                "  \"proxy\": \"123.234.53.22\",\n" +
                "  \"follow\": false\n" +
                "}";
        String actual1 = Differ.getFileText(relativePath);

        assertEquals(expected1, actual1);
    }

    @Test
    public void generateTest() throws IOException {
        String path1 = "src/test/resources/testData/file1.json";
        String path2 = "src/test/resources/testData/file2.json";
        String expected1 = "{\n" +
                "  - follow: false\n" +
                "    host: hexlet.io\n" +
                "  - proxy: 123.234.53.22\n" +
                "  - timeout: 50\n" +
                "  + timeout: 20\n" +
                "  + verbose: true\n" +
                "}";
        String actual1 = Differ.generate(path1, path2);

        assertEquals(expected1, actual1);
    }
}
