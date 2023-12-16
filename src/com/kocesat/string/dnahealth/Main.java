package com.kocesat.string.dnahealth;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<String> genes = List.of("a", "b", "c", "aa", "d", "b");
    List<Integer> healths = List.of(1, 2, 3, 4, 5, 6);
    List<Strand> strands = List.of(
      new Strand(1, 5, "caaab"),
      new Strand(0, 4, "xyz"),
      new Strand(2, 4, "bcdybc"));
    DnaHealth dnaHealth = new DnaHealth(genes, healths, strands);
    System.out.println(dnaHealth.getHealthReport());
  }
}
