package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<String> readDataFromFile(String fileName) {
        List<String> fileDataList = new ArrayList<>();
        try {
            fileDataList = Files.readAllLines(Path.of("src/resources/" + fileName));
        } catch (IOException e) {
            System.out.println("Input File not found");
        }
        return fileDataList;
    }
}
