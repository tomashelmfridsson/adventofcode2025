package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Part1 {
    public static void main(String[] args) {
        File file = new File("src/day1/input.txt");
        ArrayList<String> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Rad: " + line);
                input.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(input);
        int dialpoint = 50;
        int passwordPart1 =0;
        for (String row:input){
            boolean direction = row.charAt(0) == 'R';
            int rotation = Integer.parseInt(row.substring(1));
            if (direction) dialpoint += rotation;
            else dialpoint -= rotation;
            while (dialpoint >= 100) dialpoint -=100;
            while (dialpoint <= 0) {
                if (dialpoint != 0) {
                    dialpoint = 100 + dialpoint;
                }
                else {
                    passwordPart1++;
                    break;
                }
            }
        }
        System.out.println("Password Part1: "+passwordPart1);
    }
}
