package com.kocesat.string;

public class CountDigit {
    private final char digit;

    public CountDigit(int digit) {
        this.digit = Character.forDigit(digit, 10);
    }

    public int count(int maxNumber) {
        int counter = 0;
        for (int i = 0; i <= maxNumber; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            for (char c : chars) {
                if (c == digit) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
