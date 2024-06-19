package hexlet.code;

import hexlet.code.differ.Differ;
import hexlet.code.utils.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {
    @Test
    public void generateTest() throws IOException {
        String path1 = "src/test/resources/fixtures/file1.json";
        String path2 = "src/test/resources/fixtures/file2.json";

        String expected1 = FileReader.getFileText("src/test/resources/fixtures/expected/stylish.txt");
        String actual1 = Differ.generate(path1, path2, "stylish");
        assertEquals(expected1, actual1);

        String expected2 = FileReader.getFileText("src/test/resources/fixtures/expected/plane.txt");
        String actual2 = Differ.generate(path1, path2, "plane");
        assertEquals(expected2, actual2);

        String expected3 = FileReader.getFileText("src/test/resources/fixtures/expected/json.json");
        String actual3 = Differ.generate(path1, path2, "json");
        assertEquals(expected3, actual3);
    }
}
