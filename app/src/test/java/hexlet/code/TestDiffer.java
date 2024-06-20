package hexlet.code;

import hexlet.code.utils.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {
    @Test
    public void generateTest() throws IOException {
        // Проверка json
        String path1 = "src/test/resources/fixtures/file1.json";
        String path2 = "src/test/resources/fixtures/file2.json";

        String expected1 = FileReader.getFileText("src/test/resources/fixtures/expected/stylish.txt");
        String actual1 = Differ.generate(path1, path2, "stylish");
        assertEquals(expected1, actual1);

        String expected2 = FileReader.getFileText("src/test/resources/fixtures/expected/plain.txt");
        String actual2 = Differ.generate(path1, path2, "plain");
        assertEquals(expected2, actual2);

        String expected3 = FileReader.getFileText("src/test/resources/fixtures/expected/json.json");
        String actual3 = Differ.generate(path1, path2, "json");
        assertEquals(expected3, actual3);

        String expected4 = FileReader.getFileText("src/test/resources/fixtures/expected/stylish.txt");
        String actual4 = Differ.generate(path1, path2);
        assertEquals(expected4, actual4);

        // Проверка yml
        String path3 = "src/test/resources/fixtures/file1.yml";
        String path4 = "src/test/resources/fixtures/file2.yml";

        String expected5 = FileReader.getFileText("src/test/resources/fixtures/expected/stylish.txt");
        String actual5 = Differ.generate(path3, path4, "stylish");
        assertEquals(expected5, actual5);

        String expected6 = FileReader.getFileText("src/test/resources/fixtures/expected/plain.txt");
        String actual6 = Differ.generate(path3, path4, "plain");
        assertEquals(expected6, actual6);

        String expected7 = FileReader.getFileText("src/test/resources/fixtures/expected/json.json");
        String actual7 = Differ.generate(path3, path4, "json");
        assertEquals(expected7, actual7);
    }
}
