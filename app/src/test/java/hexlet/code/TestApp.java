package hexlet.code;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApp {
    @Test
    public void testCommandLineArguments() {
        String[] args = {
            "src/test/resources/fixtures/file1.json ",
            "src/test/resources/fixtures/file2.json ",
            "-f",
            "stylish"
        };
        App app = new App();
        new CommandLine(app).parseArgs(args);

        assertEquals("src/test/resources/fixtures/file1.json ", app.getFilePath1());
        assertEquals("src/test/resources/fixtures/file2.json ", app.getFilePath2());
        assertEquals("stylish", app.getFormat());
    }
}
