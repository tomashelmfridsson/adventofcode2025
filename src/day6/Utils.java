package day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Utils {

    public static ArrayList<String> transponera(ArrayList<String> lista) {

        int numCols = lista.size();
        ArrayList<String[]> cols = new ArrayList<>();

        int numRows = -1;

        for (String s : lista) {
            String[] parts = s.trim().split("\\s+");
            if (numRows == -1) {
                numRows = parts.length;
            }
            cols.add(parts);
        }

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

    public static ArrayList<String> cephalopod(ArrayList<String> lista) {
        int postSize = 3;
        int Cols = 0;
        String rad = lista.get(lista.size() - 1);
//        for (int i = 1; i < rad.length(); i++) {
//            if (rad.charAt(i) != ' ') {
//                postSize = i - 1;
//                break;
//            }
//        }
        System.out.println("postSize "+postSize);
        String[] operations = lista.get(lista.size() - 1).split("\\s+");
        for (int op=0; op < operations.length;op++){
            operations[op] = operations[op]+ op;
        }
        System.out.println(Arrays.toString(operations));



        String[] rowArray;

        for (String row : lista) {
            rowArray = row.split("\\s+");
            Cols = rowArray.length;
            System.out.println(Arrays.toString(rowArray));
        }
        System.out.println("Cols "+Cols);

        HashMap<String, String> result = new HashMap<>();
        ArrayList<String> resultat = new ArrayList<>();
        HashMap<String, String> extraMap = new HashMap<>();

        for (int c = Cols - 1; c >= 0; c--) {
            String operation = operations[c];
            System.out.println(operation);
            for (int r = 0; r < lista.size() - 1; r++) {
                String sRow =lista.get(r);
                String[] sArr = sRow.split("(?<=\\G.{"+(postSize+1)+"})");
                // städa bort mellanslag på sista posten
                for (int j=0;j< sArr.length-1;j++){
                    sArr[j]= sArr[j].substring(0,postSize);
                }
                // För sista posten fyll på till postsize om det saknas
                StringBuilder sb = new StringBuilder();
                for (int i =sArr[sArr.length-1].length()-1; i < postSize-1; i++) {
                    sb.append(' ');
                }
                String spaces = sb.toString();
                sArr[sArr.length-1]= sArr[sArr.length-1].concat(spaces);
                System.out.println(Arrays.toString(sArr));
                for (int p=postSize-1;p>=0;p--){
                    char chr = sArr[c].charAt(p);
                    String s = String.valueOf(chr);
                    System.out.println(s);
                    String inS = result.get("c" + c + "p" + p);
                    System.out.println(inS);
                    if (inS==null) inS="";
                    result.put("c" + c + "p" + p,inS+s);
                }

                //

            }
            // Städa bort mellanslag
            for (int p=postSize-1;p>=0;p--){
                String inS = result.get("c" + c + "p" + p);
                inS = inS.replace(" ","");
                result.put("c" + c + "p" + p,inS);
            }

            // Lägg på operation
            for (int p=postSize-1;p>=0;p--){
                String inS = result.get("c" + c + "p" + p);

                if (inS==null) inS="";
                result.put("c" + c + "p" + p,inS+operation);
            }

        }

        // skapa en hashmap med ordning och operation
        System.out.println("Hsshmappen");
            for (String key : result.keySet()) {
                String in = result.get(key);
                System.out.println(key + " " + in);
                String[] parts = in.split("(?=[+*])");
                System.out.print(Arrays.toString(parts)); System.out.println(parts.length);
                if (parts.length >1) {
                    String part2 = extraMap.get(parts[1]);
                    if (part2 == null) part2 = "";
                    extraMap.put(parts[1], part2.trim() + " " + parts[0].trim());
                }
            }

        // skapa listan nu
        System.out.println("Extramap");
        for (String key:extraMap.keySet()){
            System.out.print(key+" ");
            System.out.println(extraMap.get(key));
            resultat.add(extraMap.get(key)+" "+key.charAt(0));
        }

        System.out.println("return Lista");
        System.out.println(resultat);

        return resultat;
    }

    public static ArrayList<String> fixColumns(ArrayList<String> input) {
        // 1) Gör raderna muterbara och lika långa (padda med spaces i slutet)
        int maxLen = 0;
        for (String line : input) {
            if (line.length() > maxLen) {
                maxLen = line.length();
            }
        }

        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (String line : input) {
            StringBuilder sb = new StringBuilder(line);
            while (sb.length() < maxLen) {
                sb.append(' ');
            }
            rows.add(sb);
        }

        // 2) Gå kolumn för kolumn och bygg upp mönstret:
        //    3 "cell-kolumner" + 1 "mellanrums-kolumn"
        int col = 0;
        int charsInCell = 0;

        while (col < rows.get(0).length()) {
            if (charsInCell == 3) {
                // Den här kolumnen ska vara en ren mellanslags-kolumn
                boolean allSpaces = true;
                for (StringBuilder sb : rows) {
                    if (sb.charAt(col) != ' ') {
                        allSpaces = false;
                        break;
                    }
                }

                if (!allSpaces) {
                    // Infoga en mellanslags-kolumn här i ALLA rader
                    for (StringBuilder sb : rows) {
                        sb.insert(col, ' ');
                    }
                    // längden ökade med 1, men col pekar fortfarande
                    // på samma (nu nyskapade) space-kolumn
                }

                charsInCell = 0;
                col++; // vidare till nästa kolumn
            } else {
                // Vanlig "cell-kolumn"
                charsInCell++;
                col++;
            }
        }

        // 3) Tillbaka till ArrayList<String>
        ArrayList<String> result = new ArrayList<>();
        for (StringBuilder sb : rows) {
            result.add(sb.toString());
        }
        return result;
    }

}
