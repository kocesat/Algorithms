package com.kocesat.string.dnahealth;

public class Gene {
  private final String representation;
  private final int healthScore;

  public Gene(String representation, int healthScore) {
    this.representation = representation;
    this.healthScore = healthScore;
  }

  public String getRepresentation() {
    return representation;
  }

  public int getHealthScore() {
    return healthScore;
  }
}
