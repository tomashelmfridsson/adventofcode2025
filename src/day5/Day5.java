package day5;

import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {
//        String path = "src/day5/demo.txt"; // 3 // 513
        String path = "src/day5/input.txt"; // 14 //

        ArrayList<String> input = FileInput.readFile(path);
        System.out.println(input);

        // read all ids from the end to an ArrayList<Long>
        HashMap<Long, Boolean> ids = new HashMap<>();
        ArrayList<Range> ranges = new ArrayList<>();
        for (String row : input) {
            if (!row.contains("-") && !row.isEmpty()) {
                ids.put(Long.parseLong(row), false);
            }
            if (row.contains("-")){
                // skapa en Array med Range objekt
                String[] valuesString = row.split("-");
                ranges.add(new Range(Long.parseLong(valuesString[0]), Long.parseLong(valuesString[1])));
            }

        }
        System.out.println(ids);

        // för varje id i ids kolla om den ligger i något spann av ranges
        for ( Long key: ids.keySet()){
            for (Range range: ranges){
                if (key >= range.getStart() && key <= range.getStop()) ids.put(key,true);
            }
        }
        System.out.println(ids);
        // Räkna alla true
        int sumPart1 =0;
        for ( Long key: ids.keySet()) {
            if (ids.get(key)) sumPart1++;
        }
        System.out.println("sumPart1: "+sumPart1);

    }

}
