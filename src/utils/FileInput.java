package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {
    public static List readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        ArrayList<String> input = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            input.add(line);
        }

        return input;
    }
}
