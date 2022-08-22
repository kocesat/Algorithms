package com.esat.algo.crypto;

public class CeaserCipher {
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        System.out.println("okffng-Qwvb".equals(encode("middle-Outz", 2)));
        System.out.println("Wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb".equals(encode("There's-a-starman-waiting-in-the-sky", 3)));
    }

    public static String encode(String plainText, int rotationFactor) {
        StringBuilder sb = new StringBuilder();
        char[] plainTextArr = plainText.toCharArray();
        for (char ch: plainTextArr) {
            int index = getIndex(ALPHABET, ch);
            if (index >= 0) {
                int rotatedIndex = (index + rotationFactor) % ALPHABET.length;
                sb.append(getFromAlphabet(rotatedIndex, Character.isUpperCase(ch)));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static char getFromAlphabet(int index, boolean isUpper) {
        return isUpper ? Character.toUpperCase(ALPHABET[index]) : ALPHABET[index];
    }

    public static int getIndex(char[] searchSpace, char s) {
        for (int i=0; i< searchSpace.length; i++) {
            char c = searchSpace[i];
            if (Character.toLowerCase(c) == s || Character.toUpperCase(c) == s ) {
                return i;
            }
        }
        return -1;
    }
}
