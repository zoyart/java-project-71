package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {
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
