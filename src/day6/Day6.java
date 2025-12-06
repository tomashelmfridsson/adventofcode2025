package day6;

import day5.Range;
import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Day6 {

    public static void main(String[] args) throws FileNotFoundException {
//        String path = "src/day6/demo.txt"; // 4277556 // 4771265398012
        String path = "src/day6/input.txt";

        ArrayList<String> input = FileInput.readFile(path);
        System.out.println(input);
        ArrayList<String> lista = Utils.transponera(input);
        System.out.println(lista);
        long sum=0;
        for (String row : lista) {
            System.out.println(row);
            sum += Calculator.operation(row);
        }
        System.out.println("SumPart1 "+sum);
    }
}
