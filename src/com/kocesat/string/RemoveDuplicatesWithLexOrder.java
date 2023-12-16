package com.kocesat.string;

import java.util.Stack;

public class RemoveDuplicatesWithLexOrder {

  private final String str;
  private final int[] frequencies = new int[26];
  private final boolean[] visited = new boolean[26];
  private final Stack<Character> stack = new Stack<>();

  public RemoveDuplicatesWithLexOrder(String str) {
    this.str = str;
    for (char ch: str.toCharArray()) {
      int currentFrequency = frequencies[getIndex(ch)];
      frequencies[getIndex(ch)] = currentFrequency + 1;
    }
  }

  public String run() {
    for (char ch : str.toCharArray()) {
      int chPosition = getIndex(ch);
      if (visited[chPosition]) {
        continue;
      }
      if (stack.isEmpty()) {
        pushToStack(ch);
        continue;
      }
      if (chPosition <= getIndex(stack.peek())) {
        pushToStack(ch);
      } else {
        while (!stack.isEmpty() && frequencies[getIndex(stack.peek())] > 0) {
          Character removedChar = stack.pop();
          visited[getIndex(removedChar)] = false;
          if (!stack.isEmpty() && chPosition <= getIndex(stack.peek())) {
            break;
          }
        }
        pushToStack(ch);
      }
    }
    return getString();
  }

  private String getString() {
    StringBuilder sb = new StringBuilder();
    for (Character chr : stack) {
      sb.append(chr);
    }
    return sb.toString();
  }

  private void pushToStack(char ch) {
    int chPosition = getIndex(ch);
    visited[chPosition] = true;
    frequencies[chPosition] = frequencies[chPosition] - 1;
    stack.push(ch);
  }

  public static int getIndex(char ch) {
    return ch - 'a';
  }
}
