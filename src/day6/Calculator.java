package day6;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    private ArrayList<String> numbers;

    public Calculator( ArrayList<String> numbers){
        this.numbers = numbers;
    }

    public static long operation(String row) {
        System.out.println(row);
        String[] rowArray = row.trim().split("\\s+");
        System.out.println(Arrays.toString(rowArray));
        System.out.println(rowArray.length);
        long sum=0;
        //add
        if (rowArray[rowArray.length-1].equals("+")){
            sum=0;
            for (int i=0; i < (rowArray.length -1) ;i++){
                sum += Integer.parseInt(rowArray[i]);
            }
        }
        // Multiplikation
        if (rowArray[rowArray.length-1].equals("*")){
            sum=1;
            for (int i=0; i < (rowArray.length -1) ;i++){
                sum *= Integer.parseInt(rowArray[i]);
            }
        }
        System.out.println(row+" "+sum);
        return sum;
    }
}
