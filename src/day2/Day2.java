package day2;

import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        //String path = "src/day2/demo.txt";
        String path = "src/day2/input.txt";

        List input = FileInput.readFile(path);
        System.out.println(input);
        String[] ranges = input.getFirst().toString().split(",");
        ArrayList<IdRange> idRangeArray = new ArrayList<>();
        for (String range:ranges){
            String[] ids = range.split("-");
            idRangeArray.add(new IdRange(Long.parseLong(ids[0]),Long.parseLong(ids[1])));
        }

        // Part1
        long sumInvalidIdsPart1=0;
        for (IdRange idRange : idRangeArray) {
            sumInvalidIdsPart1 += idRange.numberInvalidIdsPart1();
        }
        System.out.println("sumInvalidIdsPart1 Part1 "+sumInvalidIdsPart1);

        // Part2
        long sumInvalidIdsPart2=0;
        for (IdRange idRange : idRangeArray) {
            sumInvalidIdsPart2 += idRange.numberInvalidIdsPart2();
        }
        System.out.println("sumInvalidIdsPart2 Part2 "+sumInvalidIdsPart2);

    }
}
