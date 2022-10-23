package com.kocesat.number;

public class AsalFinder {
    public static void main(String[] args) {
        printAsals(100, 200);
    }

    public static void printAsals(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isAsal(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isAsal(int num) {
        for (int d = 2; d < num; d++) {
            if (num%d == 0) {
                return false;
            }
        }
        return true;
    }
}
