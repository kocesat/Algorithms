package com.kocesat.median;

import java.util.Arrays;
import java.util.Scanner;

public class MidNumberParser {
    public static void main(String[] args) {
        int[] numbers = getNumbersFromUser();
        Arrays.sort(numbers);
        String mid = String.valueOf(numbers[1]);
        char[] chars = mid.toCharArray();
        for (int i=0; i<chars.length; i++) {
            System.out.printf("%s: %s%n", getWord(i), chars[i]);
        }
    }

    public static String getWord(int i) {
        switch (i) {
            case 5:
                return "Birler Basamağı";
            case 4:
                return "Onlar Basamağı";
            case 3:
                return "Yüzler Basamağı";
            case 2:
                return "Binler Basamağı";
            case 1:
                return "Onbinler Basamağı";
            case 0:
                return "Yüzbinler Basamağı";
            default:
                return null;
        }
    }

    public static int[] getNumbersFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("First Number: ");
        int first = sc.nextInt();
        System.out.println("Second Number: ");
        int second = sc.nextInt();
        System.out.println("Third Number: ");
        int third = sc.nextInt();
        sc.close();
        return new int[] {first, second, third};
    }
}
