package hexlet.code;

import lombok.Getter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
@Getter
public final class App implements Callable<Integer> {
    @Parameters(paramLabel = "filePath1", description = "path to first file")
    private String filePath1;

    @Parameters(paramLabel = "filePath2", description = "path to second file")
    private String filePath2;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        try {
            String difference = Differ.generate(filePath1, filePath2, format);
            System.out.println(difference);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error: " + e);
        }

        return 0;
    }
}
