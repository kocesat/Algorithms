package com.kocesat.string.palindrome;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class HighestValuePalindrome {

  public static final String NINE = "9";

  public static void main(String[] args) {
    Stream<Arguments> argumentStream = Stream.of(
      Arguments.of("3993", 4, 2, "9999"),
      Arguments.of("39593", 5, 2, "99599"),
      Arguments.of("092282", 6, 3, "992299"),
      Arguments.of("0011", 4, 1, "-1"));

    AtomicInteger counter = new AtomicInteger(0);
    argumentStream.forEach(arguments -> {
      String actual = highestValuePalindrome(
        (String) arguments.get(0),
        (int) arguments.get(1),
        (int) arguments.get(2));
      String expected = (String) arguments.get(3);
      if (!expected.equals(actual)) {
        System.out.println("Test Case " + counter.incrementAndGet() + ": Failed");
      } else {
        System.out.println("Test Case " + counter.incrementAndGet() + ": Success");
      }
    });
  }

  private static String highestValuePalindrome(String s, int n, int k) {
    boolean alreadyPalindrome = isPalindrome(s);
    int remainingChange = k;
    String result = null;
    if (alreadyPalindrome) {
      int firstIndex = 0;
      int lastIndex = n - 1;

      while(remainingChange > 0 && firstIndex <= lastIndex) {
        if (remainingChange % 2 == 0) {
          if (NINE.equals(s.charAt(firstIndex))) {
            firstIndex++;
            lastIndex--;
            continue;
          }
          StringBuilder sb = new StringBuilder();
          if (firstIndex == 0) {
            sb.append(NINE);
            sb.append(s.substring(1, lastIndex));
            sb.append(NINE);
            result = sb.toString();
          } else {
            // 993399
            sb.append(s.substring(0, firstIndex));
            sb.append(NINE);
            sb.append(s.substring(firstIndex + 1, lastIndex));
            sb.append(NINE);
            sb.append(s.substring(lastIndex + 1, n));
            result = sb.toString();
          }
          remainingChange -= 2;
          firstIndex++;
          lastIndex--;
        }
      }
    } else {

    }
    return result;
  }



  private static boolean isPalindrome(String str) {
    if (str.length() < 3) {
      return true;
    }
    int firstIndex = 0;
    int lastIndex = str.length() - 1;
    while (firstIndex <= lastIndex) {
      char firstChar = str.charAt(firstIndex);
      char lastChar = str.charAt(lastIndex);
      if (firstChar != lastChar) {
        return false;
      }
      firstIndex++;
      lastIndex--;
    }
    return true;
  }
}
