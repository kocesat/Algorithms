package com.kocesat.median;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MidNumberParser {
    public static final Map<Integer, String> digitMap = new HashMap<>(6, 1);

    public static void main(String[] args) {
        fillDigitMap();
        int[] numbers = getNumbersFromUser();
        Arrays.sort(numbers);
        String mid = String.valueOf(numbers[1]);
        System.out.println("Median number: " + mid);
        char[] chars = mid.toCharArray();
        for (int i=0; i<chars.length; i++) {
            System.out.printf("%s=%s\n", digitMap.get(i), chars[i]);
        }
    }

    private static void fillDigitMap() {
        digitMap.put(5, "Birler");
        digitMap.put(4, "Onlar");
        digitMap.put(3, "Yüzler");
        digitMap.put(2, "Binler");
        digitMap.put(1, "Onbinler");
        digitMap.put(0, "Yüzbinler");
    }

    public static int[] getNumbersFromUser() {
        final int maxNum = 1_000_000;
        Scanner sc = new Scanner(System.in);
        System.out.println("First Number 6 digit long: \n");
        int first = sc.nextInt();
        System.out.println("Second Number 6 digit long: \n");
        int second = sc.nextInt();
        System.out.println("Third Number 6 digit long: \n");
        int third = sc.nextInt();
        if (first >= maxNum || second >= maxNum || third >= maxNum) {
            throw new IllegalArgumentException("Invalid input");
        }
        return new int[] {first, second, third};
    }
}
