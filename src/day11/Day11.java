package day11;

import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day11 {

    static Map<String, String[]> rack;

    public static void main(String[] args) throws FileNotFoundException {
//        String path = "src/day11/demo.txt"; // 5  //590
       String path = "src/day11/input.txt";
//        String path = "src/day11/try.txt";

        ArrayList<String> input = FileInput.readFile(path);
        System.out.println(input);

        // skapa en hashmap med key device name and String[] för outputs
        rack = new HashMap<>();
        for (String row : input) {
            String[] rowArr = row.split(":");
            String device = rowArr[0];
            String[] outputs = rowArr[1].trim().split("\\s+");
            rack.put(device, outputs);
        }
        ArrayList<ArrayList<String>> results = outputs("you", new ArrayList<>());
        for (ArrayList<String> result : results) {
            System.out.println(result);
        }
        System.out.println(results.size());
    }

    // Skriv en rekursiv metod som anropar sig fram tills antingen den
    // hittar något som redan finns i Arraylistan eller tills den får värdet out
    static ArrayList<ArrayList<String>> outputs(String device, ArrayList<String> path) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        String[] outArr = rack.get(device);

        // Ingen cykel
        if (path.contains(device)) return result;

        ArrayList<String> newPath = new ArrayList<>(path);
        newPath.add(device);


        // ifall vi är i mål
        if (device.equals("out")) {
            path.add(device);
            result.add(new ArrayList<>(newPath));
            return result;
        }
        for (String out : outArr) {
            path.add(device);
            result.addAll(outputs(out,newPath));
        }
        return result;
    }
}
