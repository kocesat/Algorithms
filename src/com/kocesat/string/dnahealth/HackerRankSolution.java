
package com.kocesat.string.dnahealth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HackerRankSolution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    bufferedReader.readLine();

    List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .collect(toList());

    List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    int s = Integer.parseInt(bufferedReader.readLine().trim());

    final AtomicInteger minScore = new AtomicInteger(Integer.MAX_VALUE);
    final AtomicInteger maxScore = new AtomicInteger(0);
    IntStream.range(0, s).forEach(sItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int first = Integer.parseInt(firstMultipleInput[0]);

        int last = Integer.parseInt(firstMultipleInput[1]);

        String d = firstMultipleInput[2];

        int score = 0;
        for (int i = first; i <= last; i++) {
          String gene = genes.get(i);
          int dScore = health.get(i) * numberOfOccurence(gene, d);
          score += dScore;
        }
        if (score < minScore.get()) {
          minScore.set(score);
        }

        if (score > maxScore.get()) {
          maxScore.set(score);
        }
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    System.out.println(minScore + " " + maxScore);
  }

  public static int numberOfOccurence(String input, String s) {
    int counter = 0, cursor = 0;
    while (cursor + input.length() <= s.length()) {
      String subStr = s.substring(cursor, cursor + input.length());
      if (input.equals(subStr)) {
        counter++;
      }
      cursor++;
    }
    return counter;
  }
}
