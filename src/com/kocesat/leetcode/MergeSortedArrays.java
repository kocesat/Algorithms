package com.kocesat.leetcode;

import java.util.Arrays;

public class MergeSortedArrays {

  public static void main(String[] args) {
    int[] nums1 = {4, 0, 0, 0, 0, 0}; // m-size array
    int[] nums2 = {1,2,3,5,6}; // n-size array
    merge(nums1, 1, nums2, 5);
    System.out.println(Arrays.toString(nums1));
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }
    if (nums1[0] >= nums2[n-1]) {
      for(int j = 0; j < m; j++) {
        nums1[j+m] = nums1[j];
      }
      for (int i = 0; i < n; i++) {
        nums1[i] = nums2[i];
      }
      return;
    }
    if (m == 0 || nums2[0] >= nums1[m-1]) {
      // merge immediately and return;
      for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
      }
      return;
    }
    for (int i = 0; i < n; i++) {
      int currentNum = nums2[i];
      for (int j = m+i-1; j >= 0; j--) {
        if (currentNum >= nums1[j] || j == 0) {
          if (j == 0 && currentNum < nums1[j]) {
            shiftArrayToRight(nums1, 0);
            nums1[0] = currentNum;
          } else {
            shiftArrayToRight(nums1, j+1);
            nums1[j+1] = currentNum;
          }
          break;
        }
      }
    }
  }

  public static void shiftArrayToRight(int[] numbers, int start) {
    for (int i = numbers.length - 1; i > start; i--) {
      numbers[i] = numbers[i-1];
    }
  }
}
