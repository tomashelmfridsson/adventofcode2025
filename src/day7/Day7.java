package day7;

import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

public class Day7 {
    static int rows;
    static int cols;
    static int sumPart1=0;
    static long sumPart2=0;

    public static void main(String[] args) throws FileNotFoundException {
//        String path = "src/day7/demo.txt"; // 21  //40
        String path = "src/day7/input.txt";  //1703
//        String path = "src/day7try.txt";

        ArrayList<String> input = FileInput.readFile(path);
        //System.out.println(input);

        // Design
        // Skapa en 2D-array med input
        // Hitta startpunkten S
        // skapa en rekursiv metod som anropar sig själv och ramlar ner till nästa delare
        // För varje delare man stöter på anropa sig själv igen samt addera ett på sum

        // skapa en 2D-array
        rows = input.size();
        cols = input.get(0).split("").length;
        String[][] array = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            String[] cArr = input.get(r).split("");
            array[r] = cArr;
        }
        //System.out.println(Arrays.deepToString(array));

        // Hitta Startpunkten
        Position startpunkt;
        for (int i = 0; i < cols; i++) {
            //System.out.println(array[0][i]);
            if (array[0][i].equals("S")) {
                startpunkt = new Position(0, i);
                out.println(startpunkt.pos());
                //findSplitterPart1(startpunkt,array);
                findSplitterPart2(startpunkt,array);
                break;
            }
        }
        out.println("sumPart1: "+ sumPart1);
        out.println("sumPart2: "+ sumPart2);
    }

    //Part 1
    // Rekursiv formel som letar efter en fördelare ^ byter dem till stop -
    public static Position findSplitterPart1(Position p, String[][] arr) {
        //System.out.println("Rekursiv startpunkt "+p.pos());
        int row = p.getRow();
        int col = p.getCol();
        Position splitterP;
        for (int r = row; r < rows; r++) {
            if (arr[r][col].equals("^")){
                splitterP = new Position(r,col);
                splitterP.setEnd(false);
                sumPart1++;
                //System.out.println("Splitter "+ sumPart1 + " "+splitterP.pos());
                // lås denna splitter
                arr[r][col] = "-";
                Position leftP =new Position(r, col-1);
                findSplitterPart1(leftP,arr);
                Position rightP =new Position(r, col+1);
                findSplitterPart1(rightP,arr);
                return splitterP;
            }
            // om man kommer till ett stopp där man splittrat innan sluta
            if (arr[r][col].equals("-")){
                //System.out.println("Här har vi varit förut"+ r+","+col);
                break;
            }
        }
        Position endP = new Position(rows, col);
        endP.setEnd(true);
        return endP;
    }


    //Part 2
    // Rekursiv formel som letar efter en fördelare ^ byter dem till stop -
    public static Position findSplitterPart2(Position p, String[][] arr) {
        //System.out.println("Rekursiv startpunkt "+p.pos());
        int row = p.getRow();
        int col = p.getCol();
        Position splitterP;
        for (int r = row; r < rows; r++) {
            if (arr[r][col].equals("^")){
                splitterP = new Position(r,col);
                splitterP.setEnd(false);
                //System.out.println("Splitter " + " "+splitterP.pos());
                Position leftP =new Position(r, col-1);
                findSplitterPart2(leftP,arr);
                Position rightP =new Position(r, col+1);
                findSplitterPart2(rightP,arr);
                return splitterP;
            }
        }
        Position endP = new Position(rows, col);
        endP.setEnd(true);
        sumPart2++;
        if (sumPart2%1000000000==0) System.out.println(sumPart2);
        return endP;
    }
}





