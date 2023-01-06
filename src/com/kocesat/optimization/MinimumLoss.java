package com.kocesat.optimization;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumLoss {

    public static void main(String[] args) {
        int minLoss = getMinLoss(List.of(20L, 15L, 8L, 2L, 12L));
        System.out.println(String.format("Minimum loss is %s USD", minLoss));
    }

    /**
     * Lauren has a chart of distinct projected prices for a house over the next several years. She must buy the house in one year and sell it in another, and she must do so at a loss. She wants to minimize her financial loss.
     *
     * Example
     *
     * Her minimum loss is incurred by purchasing in year  at  and reselling in year  at . Return .
     *
     * Function Description
     *
     * Complete the minimumLoss function in the editor below.
     *
     * minimumLoss has the following parameter(s):
     * @param: prices at each year
     * @return price the minimum loss possible
     */
    public static int getMinLoss(List<Long> price) {
        Map<Long, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < price.size(); i++) {
            indexMap.put(price.get(i), i);
        }
        // Ascending order
        // 20, 15, 8, 2, 12
        // 2, 8, 12, 15, 20
        List<Long> sortedPrices = price.stream().sorted().collect(Collectors.toList());
        List<Long> losses = new ArrayList<>();
        for (int i = 0; i < sortedPrices.size() - 1; i++) {
            long sellPrice = sortedPrices.get(i);
            long buyPrice = sortedPrices.get(i+1);
            if (indexMap.get(buyPrice) < indexMap.get(sellPrice)) {
                losses.add(buyPrice - sellPrice);
            }
        }
        return Collections.min(losses).intValue();
    }
}














