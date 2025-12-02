package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) {
        File file = new File("src/day1/input.txt");
        ArrayList<String> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                input.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int dialpoint = 50;
        int passwordPart2 = 0;
        for (String row : input) {
            boolean direction = row.charAt(0) == 'R';
            int rotation = Integer.parseInt(row.substring(1));
            for (int i = 0; i < rotation; i++) {
                if (direction) dialpoint++;
                else dialpoint--;
                if (dialpoint == 100) dialpoint = 0;
                if (dialpoint == -1) dialpoint = 99;
                if (dialpoint == 0) passwordPart2++;
            }
        }
        System.out.println("Password Part2: " + passwordPart2);
    }
}
