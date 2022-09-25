package com.kocesat.subarray;

import java.util.List;

/**
 * Given an array of integers,
 * find the longest subarray where the absolute difference between any two elements
 * is less than or equal to 1.
 */
public class NumberPicker {
    public static void main(String[] args) {
        System.out.println(pickingNumbers(List.of(1,1,2,2,4,4,5,5,5)));
        System.out.println(pickingNumbers(List.of(98,3,99,1,97,2)));
    }

    public static int pickingNumbers(List<Integer> a) {
        int result = 0;
        for (int i=0; i<a.size(); i++) {
            int counter=1;
            int min = a.get(i);
            int max = a.get(i);
            for (int j=0; j<a.size() && i!=j; j++) {
                int num = a.get(j);
                if (isEligible(min, max, num)) {
                    counter++;
                    setNewMin(num, min);
                    setNewMax(num, max);
                }
            }
            if (counter > result) {
                result = counter;
            }
        }
        return result;
    }

    private static boolean isEligible(int min, int max, int num) {
        return Math.abs(min - num) <= 1 && Math.abs(max - num) <= 1;
    }

    private static int setNewMin(int num, int min) {
        if (num < min) {
            min = num;
        }
        return min;
    }

    private static int setNewMax(int num, int max) {
        if (num > max) {
            max = num;
        }
        return max;
    }

}
