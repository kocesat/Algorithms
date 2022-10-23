package com.kocesat.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private final Map<Long, Long> cache;

    public Fibonacci(int cacheSize) {
        this.cache = new HashMap<>(cacheSize);
    }

    public long getFast(long n) {
        if (cache.containsKey(n)) {
            return n;
        }
        // compute the value
        if (n < 2) {
            return n;
        }
        long result = getFast(n - 1) + getFast(n - 2);
        cache.put(n, result);
        return result;
    }

    public long get(long n) {
        if (n < 2) {
            return n;
        }
        return get(n-1) + get(n-2);
    }

}
