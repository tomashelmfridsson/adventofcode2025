package day2;

import java.util.Arrays;

public class IdRange {
    long start, stop;

    public IdRange(long start, long stop) {
        this.start = start;
        this.stop = stop;
    }

    public long numberInvalidIdsPart1() {
        long numberInvalidIds = 0;
        for (long number = this.start; number <= stop; number++) {
            String idString = String.valueOf(number);
            String part1 = idString.substring(0, idString.length() / 2);
            String part2 = idString.substring(idString.length() / 2);
            //System.out.println(idString+" "+" "+part1+" "+part2);
            if (part1.equals(part2)) {
                numberInvalidIds += number;
                System.out.println(idString + " " + " " + part1 + " " + part2);
            }
        }
        return numberInvalidIds;
    }

    private String[] splitInParts(int parts, String numberString) {
        String[] array = new String[parts];
        int totalLength = numberString.length();
        int partLength = totalLength / parts;
        // System.out.println(parts+" "+numberString+" "+totalLength+" "+partLength);
        for (int i = 0; i < parts; i++) {
            array[i] = numberString.substring(i * partLength, (i + 1) * partLength);
        }
        return array;
    }

    private Boolean arrayIdenticalPosts(String[] array) {
        String first = array[0];
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(first)) return false;
        }
        return true;
    }

    public long numberInvalidIdsPart2() {
        long numberInvalidIds = 0;
        for (long number = this.start; number <= stop; number++) {
            String idString = String.valueOf(number);
            for (int i = 2; i <= idString.length(); i++) {
                if (idString.length() % i == 0) {
                    String[] array = splitInParts(i, idString);
                    if (arrayIdenticalPosts(array)) {
                        System.out.println(Arrays.toString(array));
                        numberInvalidIds += number;
                        break;
                    }
                }
            }
        }
        return numberInvalidIds;
    }
}
