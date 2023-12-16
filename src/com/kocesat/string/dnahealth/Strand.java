package com.kocesat.string.dnahealth;

public class Strand {
  private final int firstIndex;
  private final int lastIndex;
  private final String d;

  public Strand(int firstIndex, int lastIndex, String d) {
    this.firstIndex = firstIndex;
    this.lastIndex = lastIndex;
    this.d = d;
  }

  public int getFirstIndex() {
    return firstIndex;
  }

  public int getLastIndex() {
    return lastIndex;
  }

  public String getD() {
    return d;
  }
}
