package dayX;

import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DayX {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/day7/demo.txt"; // 21  //40
//       String path = "src/day7/input.txt";  //1703
//        String path = "src/day7try.txt";

        ArrayList<String> input = FileInput.readFile(path);
        //System.out.println(input);
    }
}
