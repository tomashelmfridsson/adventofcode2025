package day3;

import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.List;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
//        String path = "src/day3/demo.txt"; //357    // 3124181577568619
        String path = "src/day3/input.txt"; // 17074  // 169512729575727
//        String path = "src/day3/try.txt";

        List input =  FileInput.readFile(path);
        System.out.println(input);
        int sumPart1 = 0;
        long sumPart2 = 0;
        for (Object row:input){
            String rowString = row.toString();
            // System.out.println(rowString);
            int maxNumberPart1 = CharAndString.getMaxNumberPart1(rowString);
            sumPart1 += maxNumberPart1;
            //System.out.println(maxNumberPart1);
            long maxNumberPart2 = CharAndString.getMaxNumberPart2(rowString);
            sumPart2 += maxNumberPart2;
            // System.out.println(maxNumberPart2);
        }
        System.out.println("part1 :"+sumPart1);
        System.out.println("part2 :"+sumPart2);
    }

}

// Part 2
// 171232000124755 too High
