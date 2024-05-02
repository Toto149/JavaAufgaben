package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(decodeCaesar(encodeCaesar("ABC", 1),1));
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
}