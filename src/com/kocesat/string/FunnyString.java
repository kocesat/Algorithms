package com.esat.algo.string;

import java.util.Stack;

public class FunnyString {
    public static void main(String[] args) {
        System.out.println(funnyString("acxz"));
        System.out.println(funnyString("bcxz"));
    }

    public static String funnyString(String s) {
        int[] asciiValues = getAsciiValues(s);
        int[] ordinals = getOrdinalValues(asciiValues);
        int[] reverseOrdinals = reverseOrdinals(ordinals);
        for (int i=0; i< ordinals.length; i++) {
            if (ordinals[i] != reverseOrdinals[i]) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static int[] reverseOrdinals(int[] ordinals) {
        int[] result = new int[ordinals.length];
        Stack<Integer> stack = new Stack();
        for (int i=0; i< ordinals.length; i++) {
            stack.push(ordinals[i]);
        }
        for (int i=0; i< ordinals.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static int[] getOrdinalValues(int[] asciiValues) {
        int[] result = new int[asciiValues.length - 1];
        for(int i=0; i<asciiValues.length-1; i++) {
            result[i] = Math.abs(asciiValues[i] - asciiValues[i+1]);
        }
        return result;
    }

    public static int[] getAsciiValues(String s) {
        int[] result = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i=0; i< result.length; i++) {
            result[i] = chars[i];
        }
        return result;
    }
}
