package com.kocesat.string;

import java.util.Random;

public class BracketPatternGenerator {
  private static final String[] brackets = {"(", ")"};
  private static final Random random = new Random();
  private final int length;
  int missingNumOfClosedBrackets;
  private StringBuilder builder;

  public BracketPatternGenerator(int length) {
    if (isLengthOdd(length)) {
      throw new IllegalArgumentException("length should be even number");
    }
    this.length = length;
  }

  public String randomGenerate() {
    resetVariables();
    while (hasSpace()) {
      if (noToleranceToUnbalancedState()) {
        tryBalance();
        continue;
      }
      putNextBracketRandomly();
    }
      return builder.toString();
  }

  private void tryBalance() {
    appendClosedBracket();
    decreaseMissingNumOfClosedBrackets();
  }

  private void putNextBracketRandomly() {
    int chosen = random.nextInt(2);
    if (chosen == 0 && !lastSpace()) {
      appendOpenBracket();
      increaseMissingNumOfClosedBrackets();
    } else if (hasAtLeastOneMissingClosedBracket()) {
      appendClosedBracket();
      decreaseMissingNumOfClosedBrackets();
    }
  }

  private boolean lastSpace() {
    return remaining() == 1;
  }

  private boolean hasSpace() {
    return remaining() > 0;
  }

  private boolean hasAtLeastOneMissingClosedBracket() {
    return missingNumOfClosedBrackets > 0;
  }

  private boolean noToleranceToUnbalancedState() {
    return missingNumOfClosedBrackets == remaining();
  }

  private void increaseMissingNumOfClosedBrackets() {
    missingNumOfClosedBrackets++;
  }

  private void decreaseMissingNumOfClosedBrackets() {
    missingNumOfClosedBrackets--;
  }

  private void appendClosedBracket() {
    builder.append(brackets[1]);
  }

  private void appendOpenBracket() {
    builder.append(brackets[0]);
  }

  private void resetVariables() {
    missingNumOfClosedBrackets = 0;
    builder = new StringBuilder();
  }

  private static boolean isLengthOdd(int length) {
    return length % 2 == 1;
  }

  private int remaining() {
    return length - builder.length();
  }
}
