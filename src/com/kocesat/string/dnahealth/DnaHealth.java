package com.kocesat.string.dnahealth;

import java.util.ArrayList;
import java.util.List;

public class DnaHealth {
  private final List<String> geneRepresentations;
  private final List<Integer> geneHealthScore;
  private final List<Strand> strands;
  private final List<Gene> genes = new ArrayList<>();
  private String healthReport;

  public DnaHealth(
    List<String> geneRepresentations,
    List<Integer> geneHealthScore,
    List<Strand> strands
  ) {
    this.geneRepresentations = geneRepresentations;
    this.geneHealthScore = geneHealthScore;
    this.strands = strands;
    this.createGeneList();
    this.calculateHealthReport();
  }

  private void createGeneList() {
    for (int i = 0; i < geneRepresentations.size(); i++) {
      genes.add(new Gene(
        geneRepresentations.get(i), geneHealthScore.get(i)));
    }
  }

  private void calculateHealthReport() {
    int minScore = 0;
    int maxScore = 0;
    for (Strand strand : strands) {
      List<Gene> beneficialGenes = beneficialGenesFor(strand);
      String d = strand.getD();
      int strandScore = 0;
      for (Gene gene : beneficialGenes) {
        int geneScore = numberOfOccurence(gene, d) * gene.getHealthScore();
        strandScore += geneScore;
      }
      if (strandScore > maxScore) {
        maxScore = strandScore;
      }
      if (strandScore < minScore) {
        minScore = strandScore;
      }
    }
    healthReport = String.format("%d %d", minScore, maxScore);
  }

  public static int numberOfOccurence(Gene gene, String s) {
    String input = gene.getRepresentation();
    int counter = 0;
    int cursor = 0;
    while (cursor + input.length() <= s.length()) {
      String subStr = s.substring(cursor, cursor + input.length());
      if (input.equals(subStr)) {
        counter++;
      }
      cursor++;
    }
    return counter;
  }

  public String getHealthReport() {
    return healthReport;
  }

  private List<Gene> beneficialGenesFor(Strand strand) {
    return genes.subList(
      strand.getFirstIndex(),
      strand.getLastIndex() + 1);
  }
}
