package com.esat.algo.string;

public class Pangram {
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static String PANGRAM = "pangram";
    private static String NOT_PANGRAM = "not pangram";


    public static void main(String[] args) {
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize").equals(PANGRAM));
        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize").equals(NOT_PANGRAM));
    }

    public static String pangrams(String s) {
        if (isPangram(s)) {
            return PANGRAM;
        }
        return NOT_PANGRAM;
    }

    public static boolean isPangram(String s) {
        char[] charArr = s.toCharArray();
        if (charArr.length <= 0 || charArr.length > Math.pow(10, 3)) {
            throw new IllegalStateException();
        }
        for (char letter : ALPHABET) {
            if (!isInArray(letter, charArr)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInArray(char c, char[] charArr) {
        for (char charInArray : charArr) {
            if (Character.toLowerCase(c) == Character.toLowerCase(charInArray)) {
                return true;
            }
        }
        return false;
    }
}
