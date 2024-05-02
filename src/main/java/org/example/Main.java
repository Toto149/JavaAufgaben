package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(' ' + 0);
        System.out.println(decodeCaesar(encodeCaesar("ABC", 1),1));
        System.out.println(decodeVigenère(encodeVigenère("ATTACKING TONIGHT", "OCULORHINOLARINGOLOGY"),"OCULORHINOLARINGOLOGY"));
    }

    public static char caesarChiffre(char letter, int offset){
        return (char) ((letter - 65 + offset)%26 + 65);
    }

    public static char negativeCaesarChiffre(char letter, int offset){
        return (char) ((letter - 65 - offset)%26 + 65);
    }

    public static String encodeCaesar(String word, int offset){
        List<Character> chars = new ArrayList<>();
        for (char ch : word.toCharArray()){

            chars.add(caesarChiffre(ch,offset));
        }
        String result = "";
        for (char ch: chars ){
            result += ch;
        }
        return result;
    }

    public static String decodeCaesar(String word, int offset){
        List<Character> chars = new ArrayList<>();
        for (char ch : word.toCharArray()){

            chars.add(negativeCaesarChiffre(ch,offset));
        }
        String result = "";
        for (char ch: chars ){
            result += ch;
        }
        return result;
    }

    public static List<Integer> stringToOffsetArrayForVigenere(String key){
        char[] chars = key.toCharArray();
        List<Integer> offsets = new ArrayList<>();
        for(char ch : chars){
            offsets.add(ch-65);
        }
        return offsets;
    }

    public static String encodeVigenère(String word, String key){
        List<Character> chars = new ArrayList<>();
        List<Integer> offsets = stringToOffsetArrayForVigenere(key);
        int i = 0;
        for (char ch : word.toCharArray()){
            if(ch + 0 != 32) {
                chars.add(caesarChiffre(ch, offsets.get(i)));
                i++;
            }
            else {
                chars.add(ch);
            }
        }
        String result = "";
        for (char ch: chars ){
            result += ch;
        }
        return result;
    }

    public static String decodeVigenère(String word, String key){
        List<Character> chars = new ArrayList<>();
        List<Integer> offsets = stringToOffsetArrayForVigenere(key);
        int i = 0;
        System.out.println(offsets);
        for (char ch : word.toCharArray()){
            if(ch + 0 !=32) {

                System.out.println(ch-65);
                System.out.println(negativeCaesarChiffre(ch,offsets.get(i))-65);
                chars.add(negativeCaesarChiffre(ch, offsets.get(i)));
                i++;
            } else {
                chars.add(ch);
            }
        }
        String result = "";
        for (char ch: chars ){
            result += ch;
        }
        return result;
    }
    public static int charToOffset(char ch){
        return Character.toUpperCase(ch) - 65;
    }
}