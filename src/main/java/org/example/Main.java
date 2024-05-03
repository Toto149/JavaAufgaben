package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String KEY = "OCULORHINOLARINGOLOGY";
        System.out.println("Encode Caesar: " + encodeCaesar("ABC", 1));
        System.out.println(decodeCaesar(encodeCaesar("ABC", 1),1));
        System.out.println("Encode Vigenère: " + encodeVigenere("ATTACKING TONIGHT", KEY));
        System.out.println(decodeVigenere(encodeVigenere("ATTACKING TONIGHT", KEY),KEY));
    }

    public static char caesarChiffre(char letter, int offset){
        return (char) ((letter - 65 + offset)%26 + 65);
    }

    public static char negativeCaesarChiffre(char letter, int offset){
        if((letter - 65 - offset) % 26 < 0){
            return (char)(26 + (letter - 65 - offset)%26 +65);
        }
        return (char) ((letter - 65 - offset)%26 + 65);
    }

    public static String encodeCaesar(String word, int offset){
        List<Character> chars = new ArrayList<>();
        for (char ch : word.toCharArray()){

            chars.add(caesarChiffre(ch,offset));
        }

        return buildStringFromCharArrayList(chars);
    }

    public static String decodeCaesar(String word, int offset){
        List<Character> chars = new ArrayList<>();
        for (char ch : word.toCharArray()){

            chars.add(negativeCaesarChiffre(ch,offset));
        }
        return buildStringFromCharArrayList(chars);
    }





    public static String encodeVigenere(String word, String key){
        List<Character> chars = new ArrayList<>();
        List<Integer> offsets = stringToOffsetArrayForVigenere(key);
        int i = 0;
        for (char ch : word.toCharArray()){
            if(ch != 32) {
                chars.add(caesarChiffre(ch, offsets.get(i)));
                i++;
            }
            else {
                chars.add(ch);
            }
        }
        return buildStringFromCharArrayList(chars);
    }

    public static String decodeVigenere(String word, String key){
        List<Character> chars = new ArrayList<>();
        List<Integer> offsets = stringToOffsetArrayForVigenere(key);
        int i = 0;
        for (char ch : word.toCharArray()){
            if(ch !=32) {
                chars.add(negativeCaesarChiffre(ch, offsets.get(i)));
                i++;
            } else {
                chars.add(ch);
            }
        }
        return buildStringFromCharArrayList(chars);
    }



    public static List<Integer> stringToOffsetArrayForVigenere(String key){
        char[] chars = key.toUpperCase().toCharArray();
        List<Integer> offsets = new ArrayList<>();
        for(char ch : chars){
            offsets.add(ch-65);
        }
        return offsets;
    }


    private static String buildStringFromCharArrayList(List<Character> chars) {
        StringBuilder result = new StringBuilder();
        for (char ch: chars){
            result.append(ch);
        }
        return result.toString();
    }
}