package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileOperations {
    public static void writeToFile(String content, String filePath) {
        // Use try-with-resources to automatically close the resources
        try {
            // Write the string to the file using Files.write and Stream API
            Files.write(Paths.get(filePath), content.lines().collect(Collectors.toList()));

            System.out.println("String has been written to the file.");

        } catch (IOException e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}
