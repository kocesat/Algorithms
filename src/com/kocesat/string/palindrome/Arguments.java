package com.kocesat.string.palindrome;

public class Arguments {
  
  private final Object[] args;

  private Arguments(Object[] args) {
    this.args = args;
  }

  public static Arguments of(Object... argsInput) {
   return new Arguments(argsInput);
  }

  public Object get(int index) {
    return args[index];
  }
}
