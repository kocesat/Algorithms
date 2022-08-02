package com.kocesat.median;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        return arr.get((arr.size() - 1) / 2);
    }

    public static void main(String[] args) {
        Integer[] arr = {2,3,10,11,4};
        System.out.println(findMedian(Arrays.asList(arr)));
    }
}
