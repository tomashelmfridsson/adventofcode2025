package day9;

import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day9 {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/day9/demo.txt"; // 50
//        String path = "src/day9/input.txt";  //

        ArrayList<String> input = FileInput.readFile(path);
        System.out.println(input);

        // Skapa en array med alla Tiles
        ArrayList<Tile> tiles = new ArrayList<>();
        int number = 0;        for (String row : input) {
            String[] rowArr = row.split(",");
            int x = Integer.parseInt(rowArr[0]);
            int y = Integer.parseInt(rowArr[1]);
            tiles.add(new Tile(x, y));
        }
        System.out.println(tiles);

        // Part 1 Leta efter max
        long max = Logik.maxArea(tiles);
        System.out.println("Max area " + max);

        // Part 2

    }
}
// part 1
// 2147480352 too low -  max have to be long
