package hexlet.code.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public static String getFileText(String path) throws IOException {
        Path absolutePath = Paths.get(path).toAbsolutePath().normalize();

        if (!Files.exists(absolutePath)) {
            throw new IOException("File '" + path + "' does not exist");
        }

        if (Files.isDirectory(absolutePath)) {
            throw new IOException("File '" + path + "' is a directory, not a file");
        }

        return Files.readString(absolutePath);
    }

    public static String getFileExtension(String path) throws IOException {
        if (path == null || path.isEmpty()) {
            return "";
        }

        int lastIndexOf = path.lastIndexOf(".");
        if (lastIndexOf == -1 || lastIndexOf == path.length() - 1) {
            return "";
        }

        return path.substring(lastIndexOf + 1).trim();
    }
}
