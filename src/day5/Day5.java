package day5;

import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {
//        String path = "src/day5/demo.txt"; // 3 // 513
        String path = "src/day5/input.txt"; // 14 //
//        String path = "src/day5/try.txt";

        ArrayList<String> input = FileInput.readFile(path);
        //System.out.println(input);

        // read all ids from the end to an ArrayList<Long>
        HashMap<Long, Boolean> ids = new HashMap<>();
        ArrayList<Range> ranges = new ArrayList<>();
        for (String row : input) {
            if (!row.contains("-") && !row.isEmpty()) {
                ids.put(Long.parseLong(row), false);
            }
            if (row.contains("-")) {
                // skapa en Array med Range objekt
                String[] valuesString = row.split("-");
                ranges.add(new Range(Long.parseLong(valuesString[0]), Long.parseLong(valuesString[1])));
            }

        }
        //System.out.println(ids);

        // för varje id i ids kolla om den ligger i något spann av ranges
        for (Long key : ids.keySet()) {
            for (Range range : ranges) {
                if (key >= range.getStart() && key <= range.getStop()) ids.put(key, true);
            }
        }
        //System.out.println(ids);
        // Räkna alla true
        int sumPart1 = 0;
        for (Long key : ids.keySet()) {
            if (ids.get(key)) sumPart1++;
        }
        System.out.println("sumPart1: " + sumPart1);


        //Part2
        long sumPart2 = 0;
        long sumPart2Old = -1;
        while (sumPart2 != sumPart2Old) {
            sumPart2Old = sumPart2;
            Range result = new Range(ranges.getFirst().getStart(), ranges.getFirst().getStop());
            ArrayList<Range> results = new ArrayList<>();
            results.add(result);
            System.out.println("Start Range " + result.getStart() + "-" + result.getStop());

            for (Range range : ranges) {
                System.out.println("RangeIn " + range.getStart() + "-" + range.getStop());
                results = LogikPart2.multiRanges(results, range);
            }
            System.out.println("Ranges");
            for (Range range : ranges) {
                System.out.println(range.getStart() + "-" + range.getStop());
            }
            sumPart2 = LogikPart2.sum(results);
            System.out.println("sumPart2 :" + sumPart2);
            ranges=results;
        }
    }

}
