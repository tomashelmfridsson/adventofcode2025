package day3;

public class CharAndString {

    private String text;

    public CharAndString(String text) {
        this.text = text;
    }

    public static int getMaxNumberPart1(String text) {
        int maxNumber = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                String[] stringArray = text.split("");
                String numberString = stringArray[i] + stringArray[j];
                int number = Integer.parseInt(numberString);
                if (number > maxNumber)
                    maxNumber = number;
            }
        }
        return maxNumber;
    }

    public static long getMaxNumberPart2(String text) {
        String maxNumberString = "";
        int antalSiffrorKvar = 12;
        while (antalSiffrorKvar != 0) {
            long maxNumber = 0;
            long max = getMaxNNumbersInRow(text, antalSiffrorKvar);
            if (max > maxNumber) {
                String firstNumberString = String.valueOf(String.valueOf(max).charAt(0));
                int begin = text.indexOf(firstNumberString);
                maxNumberString = maxNumberString.concat(String.valueOf(text.charAt(begin)));
                antalSiffrorKvar--;
                text = text.substring(begin+1);
            }
        }
        return Long.parseLong((maxNumberString + text).substring(0, 12));
    }

    private static long getMaxNNumbersInRow(String text, int n) {
        long maxNumber = 0;
        for (int i = 0; i <= text.length() - n; i++) {
            String numberString = text.substring(i, i + n);
            long number = Long.parseLong(numberString);
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        return maxNumber;
    }

    public static String removeCharAt(String s, int index) {
        if (index < 0 || index >= s.length()) {
            throw new IndexOutOfBoundsException("index = " + index);
        }
        return s.substring(0, index) + s.substring(index + 1);
    }
}
