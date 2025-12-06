package day6;

import day5.Range;
import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Day6 {

    public static void main(String[] args) throws FileNotFoundException {
//        String path = "src/day6/demo.txt"; // 4277556 // 3263827
        String path = "src/day6/input.txt";
//        String path = "src/day6/try.txt";

        ArrayList<String> input = FileInput.readFile(path);
        System.out.println(input);

        // Part 1
        ArrayList<String> lista = Utils.transponera(input);
        // [123 45 6 *, 328 64 98 +, 51 387 215 *, 64 23 314 +]
//        System.out.println(lista);
//        long sumPart1=0;
//        for (String row : lista) {
//            System.out.println(row);
//            sumPart1 += Calculator.operation(row);
//        }
//        System.out.println("SumPart1 "+sumPart1);

        // Part 2
        // justera såå att det är 3 mellan varje operation
        input = Utils.fixColumns(input);
        System.out.println(input);
        ArrayList<String> result= Utils.cephalopod(input);
        //System.out.println(result);
        long sum=0;
        for (String row : result) {
            //System.out.println(row);
            long delsumma = Calculator.operation(row);
            System.out.println(row+ " "+ delsumma);
            sum +=delsumma;
        }
        System.out.println("SumPart2 "+sum);
    }
}


// 8357953216 too low
// 11811965403887 too high