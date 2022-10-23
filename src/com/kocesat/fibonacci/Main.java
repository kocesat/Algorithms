package com.kocesat.fibonacci;

public class Main {
    public static void main(String[] args) {
        long times = 1_000;
        for (long i=0; i<=times; i++) {
            runFastFibonacci(i);
        }
//        runSlowFibonacci(times);
    }

    public static void runFastFibonacci(long n) {
        long start = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci(1000);
        long result = fibonacci.getFast(n);
        long stop = System.currentTimeMillis();
        System.out.println("Caching " + n + "->" + result + ". Time elapsed: " + (stop-start) + " ms.");
    }

    public static void runSlowFibonacci(long n) {
        long start = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci(1_000);
        long result = fibonacci.get(n);
        long stop = System.currentTimeMillis();
        System.out.println("No-caching result: " + result + ". Time elapsed: " + (stop-start) + " ms.");
    }
}
