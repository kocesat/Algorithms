package com.kocesat.sudoku.functional;

import java.util.Objects;
import java.util.stream.IntStream;

public class Main {

    public static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {6, 9, 5, 0, 0, 0, 7, 0, 4},
                {0, 3, 0, 6, 0, 0, 0, 9, 8},
                {8, 0, 0, 0, 9, 5, 0, 0, 1},
                {0, 5, 8, 9, 0, 0, 4, 0, 0},
                {0, 0, 0, 5, 3, 6, 8, 0, 2},
                {3, 0, 0, 0, 1, 0, 9, 7, 0},
                {0, 2, 0, 0, 0, 4, 3, 5, 0},
                {0, 0, 4, 0, 5, 0, 0, 8, 6},
                {5, 0, 0, 2, 0, 0, 0, 4, 0}
        };

        printBoard(board, "initial state");
        boolean solved = solve(board);
        printBoard(board, "final state, solved: " + solved);
    }

    public static boolean solve(int[][] grid) {
        Position empty = findEmpty(grid);
        if (Objects.isNull(empty)) {
            return true;
        }
        for (int candidate = 1 ; candidate < 10; candidate++) {
            if (isValid(grid, candidate, empty)) {
                grid[empty.getRow()][empty.getCol()] = candidate;
                if (solve(grid)) {
                    return true;
                }
                grid[empty.getRow()][empty.getCol()] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int num, Position position) {
        return notInRow(board, num, position)
                && notInColumn(board, num, position)
                && notInBox(board, num, position);
    }

    private static boolean notInRow(int[][] board, int num, Position position) {
        for (int j = 0; j < GRID_SIZE; j++) {
            if (board[position.getRow()][j] == num && position.getCol() != j) {
                return false;
            }
        }
        return true;
    }

    private static boolean notInColumn(int[][] grid, int num, Position position) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (grid[i][position.getCol()] == num && position.getRow() != i) {
                return false;
            }
        }
        return true;
    }

    private static boolean notInBox(int[][] grid, int num, Position position) {
        int rowBlock = position.getRow() / 3;
        int colBlock = position.getCol() / 3;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == num && (rowBlock == i / 3) && (colBlock == j / 3)) {
                    return false;
                }
            }
           }
        return true;
    }

    public static void printBoard(int[][] board, String header) {
        System.out.println(header);
        for (int i = 0; i < GRID_SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-------------------");
            }
            for (int j = 0; j < GRID_SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                if (j == 8) {
                    System.out.println(board[i][j]);
                } else {
                    System.out.print(board[i][j]);
                }
            }
        }
    }

    public static Position findEmpty(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == 0) {
                    return Position.getPosition(i, j);
                }
            }
        }
        return null;
    }
}
