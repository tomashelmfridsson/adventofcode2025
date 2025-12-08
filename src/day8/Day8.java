package day8;

import utils.FileInput;

import java.io.FileNotFoundException;
import java.util.*;

public class Day8 {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/day8/demo.txt"; // 10 junctions //
//       String path = "src/day8/input.txt";  //1000 junctions
//        String path = "src/day8try.txt";
        int max=10;

        ArrayList<String> input = FileInput.readFile(path);
        System.out.println(input);

        // Skapa en ArrayList med alla Junctions
        ArrayList<Junction> junctions = new ArrayList<>();
        int number = 0;
        for (String row : input) {
            String[] rowArr = row.split(",");
            int x = Integer.parseInt(rowArr[0]);
            int y = Integer.parseInt(rowArr[1]);
            int z = Integer.parseInt(rowArr[2]);
            Junction j = new Junction(x, y, z, number);
            junctions.add(j);
        }

        // Antal Junctions
        int numberOfJunctions = junctions.size();

        // skapa en 2D matris med distanser och fyll på denna matris
        HashMap<Double, Junction[]> distanceMap = new HashMap<Double, Junction[]>();
        double[][] distances = new double[numberOfJunctions][numberOfJunctions];
        for (int x = 0; x < numberOfJunctions; x++) {
            for (int y = 0; y < numberOfJunctions; y++) {
                Junction A = junctions.get(x);
                Junction B = junctions.get(y);
                double distance = Logik.calculateClosest(A, B);
                distances[x][y] = distance;
                distanceMap.put(distance, new Junction[]{A, B});
            }
        }

        // ta bort 0.0
        distanceMap.remove(0.0);

        int circuitNumber=1;
        // Sortera i storleksordning
        Map<Double, Junction[]> sortedDistance = new TreeMap<>(distanceMap);
        int i=0;
        for (Map.Entry<Double, Junction[]> e : sortedDistance.entrySet()) {
            if(i<max){
                Double key = e.getKey();
                Junction[] jArr = e.getValue();
                Junction A = jArr[0];
                Junction B = jArr[1];
                if (A.circuit ==0 && B.circuit ==0){
                    A.circuit = circuitNumber;
                    B.circuit = circuitNumber;
                    circuitNumber++;
                }
                if(A.circuit !=0 && B.circuit ==0){
                    B.circuit = A.circuit;
                }
                if (A.circuit ==0 && B.circuit !=0){
                    A.circuit = B.circuit;
                }
            }
            i++;
        }
        // Räkna ut alla skapa en array med Circuit storlek och summera alla
        int[] circuits = new int[circuitNumber-1];
        for (Junction j: junctions){
            int c = j.getCircuit();
            if (c!=0) circuits[c-1] = circuits[c-1] +1;
        }
        System.out.println(Arrays.toString(circuits));

        // Mulitplicera
        int faktor =1;
        for (int c:circuits){
            faktor *= c;
        }
        System.out.println("Faktor Part1 "+faktor);
    }

}
