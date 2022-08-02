package com.kocesat.matrix.flipping;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] grid = {
                {7, 3, 4, 3},
                {4, 5, 2, 8},
                {8, 10, 1, 7},
                {10, 12, 3, 1}
        };
        List<List<Integer>> matrix = gridToList(grid);
        System.out.println(flipTheMatrix(matrix));
    }

    public static int flipTheMatrix(List<List<Integer>> matrix) {
        int sum = 0;
        int halfSize = matrix.size() / 2;
        int size = matrix.size();
        for (int i = 0; i < halfSize; i++) {
            for (int j = 0; j < halfSize; j++) {
                int element = matrix.get(i).get(j);
                int rowMirror = matrix.get(i).get(size - 1 - j);
                int colMirror = matrix.get(size - 1 - i).get(j);
                int diagMirror = matrix.get(size - 1 - i).get(size - 1 - j);
                if (element < Math.max(rowMirror, Math.max(colMirror, diagMirror))) {
                    sum += Math.max(rowMirror, Math.max(colMirror, diagMirror));
                } else {
                    sum += element;
                }
            }
        }
        return sum;
    }

    public static int bestRowToReverse(List<List<Integer>> matrix) {
        int tailSum = 0;
        int rowCandidate = 0;
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            if (row.get(row.size() - 1) + row.get(row.size() - 2) > tailSum) {
                tailSum = row.get(row.size() - 1) + row.get(row.size() - 2);
                rowCandidate = i;
            }
        }
        return rowCandidate;
    }

    public static int bestColToReverse(List<List<Integer>> matrix) {
        int tailSum = 0;
        int colCandidate = 0;
        for (int j = 0; j < matrix.size(); j++) {
            var tempSum = matrix.get(matrix.size() - 1).get(j) + matrix.get(matrix.size() - 2).get(j);
            if (tempSum > tailSum) {
                tailSum = tempSum;
                colCandidate = j;
            }
        }
        return colCandidate;
    }

    public static void reverseColumn(List<List<Integer>> matrix, int index) {
        Stack<Integer> stack = new Stack<>();
        for (List<Integer> row : matrix) {
            stack.push(row.get(index));
        }
        for (List<Integer> row : matrix) {
            row.set(index, stack.pop());
        }
    }

    public static void reverseRow(List<List<Integer>> matrix, int index) {
        Collections.reverse(matrix.get(index));
    }

    public static int getUpperLeftSum(List<List<Integer>> matrix) {
        int halfSize = matrix.size() / 2;
        int sum = 0;
        for (int row = 0; row < halfSize; row++) {
            for (int col = 0; col < halfSize; col++) {
                sum += matrix.get(row).get(col);
            }
        }
        return sum;
    }

    public static List<List<Integer>> gridToList(int[][] grid) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                tempList.add(grid[i][j]);
            }
            result.add(tempList);
        }
        return result;
    }
}
