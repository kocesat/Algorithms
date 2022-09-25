package com.kocesat.crypto;

public class Encryption {
    public static void main(String[] args) {
        System.out.println(encode("if man was meant to stay on the ground god would have given us roots"));
        System.out.println(encode("haveaniceday"));
        System.out.println(encode("feedthedog"));
    }

    public static String encode(String s) {
        String input = removeWhiteSpaces(s);
        int rowNum = getSquaredRoot(input.length(), false);
        int colNum = getSquaredRoot(input.length(), true);
        while(rowNum < colNum && !gridIsEnough(rowNum, colNum, input.length())) {
            rowNum++;
        }
        // create grid
        char[][] grid = new char[rowNum][colNum];
        int cursor = 0;
        char[] chars = input.toCharArray();
        for (int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++) {
                if (cursor < chars.length) {
                    grid[i][j] = chars[cursor++];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<colNum; j++) {
            for(int i=0; i<rowNum; i++) {
                if (grid[i][j] != Character.MIN_VALUE) {
                    sb.append(grid[i][j]);
                }
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String removeWhiteSpaces(String input) {
        return input.replace(" ", "");
    }

    public static int getSquaredRoot(int number, boolean ceiling) {
        double root = Math.sqrt(number);
        return ceiling ? (int)Math.ceil(root) : (int)Math.floor(root);
    }

    public static boolean gridIsEnough(int rowNum, int colNum, int len) {
        return rowNum * colNum  >= len;
    }
}
