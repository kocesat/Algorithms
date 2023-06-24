package com.kocesat;

import com.kocesat.string.BracketPatternGenerator;

public class Main {

  public static void main(String[] args) {
    BracketPatternGenerator bracketPatternGenerator = new BracketPatternGenerator(10);
    for (int i = 0; i < 10; i++) {
      String bracketPattern = bracketPatternGenerator.randomGenerate();
      System.out.println(bracketPattern);
    }
  }
}
