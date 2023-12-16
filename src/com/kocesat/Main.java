package com.kocesat;

import com.kocesat.string.BracketPatternGenerator;
import com.kocesat.string.RemoveDuplicatesWithLexOrder;

public class Main {

  public static void main(String[] args) {
//    BracketPatternGenerator bracketPatternGenerator = new BracketPatternGenerator(10);
//    for (int i = 0; i < 10; i++) {
//      String bracketPattern = bracketPatternGenerator.randomGenerate();
//      System.out.println(bracketPattern);
//    }

    String input = "abcdcb";
    RemoveDuplicatesWithLexOrder removeDuplicatesWithLexOrder = new RemoveDuplicatesWithLexOrder(input);
    String result = removeDuplicatesWithLexOrder.run();
    System.out.println(result);
  }
}
