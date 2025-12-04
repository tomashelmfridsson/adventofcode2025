package day4;

import utils.FileInput;

import javax.swing.text.StyleContext;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {
    public static void main(String[] args) throws FileNotFoundException {
//        String path = "src/day4/demo.txt"; // 13 // 43
        String path = "src/day4/input.txt"; // 1445

        ArrayList<String> input = FileInput.readFile(path);
        // System.out.println(input);
        // create a matrix
        int rows = input.size();
        int cols = input.get(0).length();
        int[][] matrix = rollCounter(input);

        // Part1
        int sumPart1 = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] < 4 && input.get(row).charAt(col) == '@') {
                    sumPart1++;
                }
            }
        }
        System.out.println("sum part1: " + sumPart1);

        // Part2
        int sumPart2 = 0;
        int oldSumPart2 = -1;
        while( oldSumPart2 != sumPart2) {
            oldSumPart2 = sumPart2;
            matrix = rollCounter(input);
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] < 4 && input.get(row).charAt(col) == '@') {
                        // Ta bort @
                        String rowString = input.get(row);
                        String newString = rowString.substring(0, col) + "D" + rowString.substring(col + 1);
                        input.set(row,newString);
                        sumPart2++;
                    }
                }
            }
            System.out.println("sum part2: " + sumPart2);
        }
    }

    private static int[][] rollCounter(ArrayList<String> input) {
        int rows = input.size();
        int cols = input.get(0).length();
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (input.get(row).charAt(col) == '@') {
                    // Sätt snett vänster på raden ovanför
                    if (row > 0 && col > 0) matrix[row - 1][col - 1]++;
                    // Sätt rakt upp på raden ovanför
                    if (row > 0) matrix[row - 1][col]++;
                    // Sätt snett höger på raden ovanför
                    if (row > 0 && col < cols - 1) matrix[row - 1][col + 1]++;

                    // Sätt till vänster på samma rad
                    if (col > 0) matrix[row][col - 1]++;
                    // Sätt till höger på samma rad
                    if (col < cols - 1) matrix[row][col + 1]++;

                    // Sätt snett vänster på raden nedanför
                    if (row < rows - 1 && col > 0) matrix[row + 1][col - 1]++;
                    // Sätt rakt nedanför på raden nedanför
                    if (row < rows - 1) matrix[row + 1][col]++;
                    // Sätt snett höger på raden nedanför
                    if (row < rows - 1 && col < cols - 1) matrix[row + 1][col + 1]++;
                }
            }
        }
        return matrix;
    }

}