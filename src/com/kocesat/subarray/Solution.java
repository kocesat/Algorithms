package com.kocesat.subarray;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array of length N, find the length of the longest subArray
 * such that subArray contains no more than 2 distinct elements and
 * difference of any two elements of the subArray is no more than 1
 * Example: int[] = [1, 1, 2, 3, 4, 4]
 * longest subArray satisfying conditions are the followings:
 * [1, 1, 2] and [3, 4, 4] so, length = 3
 * [1, 1, 2, 3] does not satifsy the constraint since difference of (3 and 1) = 2 which is greater than 1
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(1 == getLongestSubArrayLength(List.of(89,10)) ? "Passed" : "Failed");
        System.out.println(2 == getLongestSubArrayLength(List.of(10,10)) ? "Passed" : "Failed");
        System.out.println(2 == getLongestSubArrayLength(List.of(11,10)) ? "Passed" : "Failed");
        System.out.println(3 == getLongestSubArrayLength(List.of(11,11,10)) ? "Passed" : "Failed");
        System.out.println(4 == getLongestSubArrayLength(List.of(11,11,10,10)) ? "Passed" : "Failed");
        System.out.println(11 == getLongestSubArrayLength(List.of(2,1,1,2,2,5,5,5,5,5,5,5,5,5,5,5,3,3,4,4,5,5,6,7,89,10))
                ? "Passed" : "Failed");
    }

    public static int getLongestSubArrayLength(List<Integer> arr) {
        int maxSize = 0;
        Set<Integer> distinctElements = new HashSet<>();
        for (int start = 0; start < arr.size(); start++) {
            for (int end = start; end < arr.size(); end++) {
                distinctElements.add(arr.get(end));
                if (distinctElements.size() > 2 || diffMoreThanOne(distinctElements, arr.get(end))) {
                    // No need to search more
                    List<Integer> subArr = arr.subList(start, end);
                    if (subArr.size() > maxSize) {
                        maxSize = subArr.size();
                    }
                    distinctElements.clear();
                    break;
                } else if (end == arr.size() - 1) {
                    List<Integer> subArr = arr.subList(start, end + 1);
                    if (subArr.size() > maxSize) {
                        maxSize = subArr.size();
                    }
                    distinctElements.clear();
                }
            }
        }
        return maxSize;
    }

    public static boolean diffMoreThanOne(Set<Integer> distinctElements, int num) {
        for (int element : distinctElements) {
            if (Math.abs(num - element) > 1) {
                return true;
            }
        }
        return false;
    }

}
