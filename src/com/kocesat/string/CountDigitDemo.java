package com.kocesat.string;

public class CountDigitDemo {
    public static void main(String[] args) {
        CountDigit counter = new CountDigit(2);
        System.out.println(counter.count(2_000_000));
    }
}
