package string_aufgaben;

import java.util.Arrays;

public class Strings {
    private static final char[] NAME = {'A', 'W', ' ', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};
    public static void main(String[] args) {
        System.out.println(Aufgabe1());
        Arrays.stream(Aufgabe5("1, 2, 4, 9, 8, 7, 6, 4, 1")).forEach(System.out::println);
        System.out.println(Aufgabe4("hallo"));
        asciiTable(70);
    }


    public static char[] Aufgabe1() {
        char[] result = new char[NAME.length];
        int j=0;
        for (int i = NAME.length - 1; i >= 0; i--) {
            result[j] = NAME[i];
            j++;
        }
        return result;
    }

    public static String Aufgabe2() {
        StringBuilder str = new StringBuilder("");

        for(int i=0; i<NAME.length; i+=2){
            str.append(NAME[i]);
        }

        return str.toString();
    }
    public static String Aufgabe3(char[] charArray){
        return new String(charArray);
    }
    public static int[] Aufgabe5(String numberSequence){
        // The number sequence is of the following format "1, 2, 3, 4, 5, 6, 7, 8, 9"

        String[] stringArray = numberSequence.split(",");
       return Arrays.stream(stringArray)
                .map(s ->   {s = s.trim();
                    return s;})
                .mapToInt(Integer::parseInt)
                .toArray();

    }
    public static char[] Aufgabe4(String word){
        char[] charArray = new char[word.length()];
        for(int i=0; i< charArray.length; i++){
            charArray[i] = word.charAt(i);
        }

        return charArray;
    }


    public static void asciiTable(int number){
        StringBuilder str = new StringBuilder("\tint \t \t hex \t \t ascii\n");
        for(int i = 33; i< number; i++){
            str.append("\t "+i + "\t\t\t")
                    .append(" 0x" + Integer.toHexString(i) +"\t\t\t")
                    .append(String.valueOf((char) i) + "\n");

        }

        System.out.println(str);
    }

}
