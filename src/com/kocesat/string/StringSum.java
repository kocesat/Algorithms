package com.kocesat.string;

public class StringSum {
    public static void main(String[] args) {
        String val1 = "4999999999999999999999999999999999999999";
        String val2 = "0000000000008000000000000000000000000099";
        System.out.println(sum(val1, val2));
    }

    public static String sum(String val1, String val2) {
        if (val1.length() < val2.length()) {
            val1 = leftPadWithZero(val1, val2.length() - val1.length());
        } else {
            val2 = leftPadWithZero(val2, val1.length() - val2.length());
        }
        StringBuilder sb = new StringBuilder();
        int leapVal = 0;
        for (int i = val1.length() - 1; i >= 0; i--) {
            int digit1 = Integer.parseInt(String.valueOf(val1.charAt(i)));
            int digit2 = Integer.parseInt(String.valueOf(val2.charAt(i)));
            int digitSum = digit1 + digit2 + leapVal;
            String resultDigit = String.valueOf(digitSum % 10);
            sb.insert(0, resultDigit);
            leapVal = digitSum < 10 ? 0 : 1;
        }
        if (leapVal > 0) {
            sb.insert(0, leapVal);
        }
        return sb.toString();
    }

    private static String leftPadWithZero(String input, int repeat) {
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < repeat; i++) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

}
