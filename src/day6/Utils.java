package day6;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static ArrayList<String> transponera(ArrayList<String> lista) {

        int numCols = lista.size();
        ArrayList<String[]> cols = new ArrayList<>();

        int numRows = -1;

        // Steg 1: splitta varje kolumn-sträng till en array
        for (String s : lista) {
            String[] parts = s.trim().split("\\s+"); // splitta på whitespace
            if (numRows == -1) {
                numRows = parts.length;
            } else if (parts.length != numRows) {
                throw new IllegalArgumentException("Alla kolumner måste ha samma antal värden");
            }
            cols.add(parts);
        }

        // Steg 2: bygg upp rader genom att plocka r:te värdet ur varje kolumn
        ArrayList<String> resultat = new ArrayList<>();

        for (int r = 0; r < numRows; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < numCols; c++) {
                if (c > 0) {
                    sb.append(' ');
                }
                sb.append(cols.get(c)[r]);
            }
            resultat.add(sb.toString());
        }

        return resultat;
    }
}
