package com.esat.algo.string;

public class SuperReducedString {
    private static final String TEST_STR = "abccdd";

    public static void main(String[] args) {
        System.out.println(superReduce(TEST_STR).equals("ab") ? "test passed" : "test failed!");
        System.out.println(superReduce("cc").equals("") ? "test passed" : "test failed!");
        System.out.println(superReduce("").equals("") ? "test passed" : "test failed!");
        System.out.println(superReduce("caac").equals("") ? "test passed" : "test failed!");
        System.out.println(superReduce("caacaabbddedessaagg").equals("ede") ? "test passed" : "test failed!");
        System.out.println(superReduce("aa").equals("") ? "test passed" : "test failed!");
    }

    private static String superReduce(String str) {
        int indexOfAdj = -1;
        String result = str;
        while (true) {
            indexOfAdj = indexOfAdjacent(result);
            if (indexOfAdj == -1) {
                break;
            }
            result = result.replaceFirst(result.substring(indexOfAdj-1, indexOfAdj+1), "");
        }
        return result;
    }

    private static int indexOfAdjacent(String str) {
        String[] strArr = str.split("");
        for(int i=1; i<strArr.length; i++) {
            if (strArr[i].equals(strArr[i-1])) {
                return i;
            }
        }
        return -1;
    }
}
