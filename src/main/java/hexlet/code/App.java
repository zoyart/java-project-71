package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {
    @Parameters(paramLabel = "filePath1", description = "path to first file")
    String filePath1;

    @Parameters(paramLabel = "filePath2", description = "path to second file")
    String filePath2;

    @Option(names = { "-f", "--format" }, paramLabel = "format", description = "output format [default: stylish]")
    String format;

    public static void main(String[] args) {
        int exitCode = CommandLine.call(new App(), args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        try {
            String difference = Differ.generate(filePath1, filePath2);
            System.out.println(difference);
        } catch (IOException e) { System.out.println("Error: " + e); }

        return 0;
    }
}
