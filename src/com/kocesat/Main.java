package com.kocesat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Number: ");
            number = scanner.nextInt();
            String result = "";
            if (number % 5 == 0) {
                result = "Fuzz";
            }
            if (number % 3 == 0) {
                result += "Buzz";
            }
            if (number % 5 != 0 && number % 3 != 0) {
                result = number + "";
            }
            System.out.println(result);
        }
    }
}
