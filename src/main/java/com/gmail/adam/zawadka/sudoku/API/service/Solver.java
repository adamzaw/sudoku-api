package com.gmail.adam.zawadka.sudoku.API.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Solver {

    int[][] sudoku = new int[9][9];
    int[][] result = new int[9][9];

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
        result = Arrays.copyOf(sudoku, 9);

    }

    private boolean fullCheck(int row, int column, int value) {

        for (int i = 0; i < 9; i++) {

            if (sudoku[row][i] == value || sudoku[i][column] == value ||
                    sudoku[row / 3 * 3 + i % 3][column / 3 * 3 + i / 3] == value) {
                return false;
            }
        }
        return true;
    }

    boolean next(int row, int col) {
        if (row == 8 && col == 8) return true;
        else if (row == 8) return solve(0, col + 1);
        else return solve(row + 1, col);
    }

    private boolean solve(int row, int col) {

        if (sudoku[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                if (fullCheck(row, col, i)) {
                    result[row][col] = i;
                    if (next(row, col)) {
                        return true;
                    }
                }
            }
            result[row][col] = 0;
            return false;
        }
        return next(row, col);
    }

//    public static void main(String[] args) {
//
//        int[][] test = {
//                {0, 1, 0, 0, 5, 6, 2, 7, 0},
//                {0, 0, 0, 0, 8, 0, 0, 0, 9},
//                {0, 7, 8, 0, 0, 3, 6, 0, 5},
//                {0, 0, 0, 0, 0, 4, 5, 0, 1},
//                {8, 5, 2, 0, 0, 0, 7, 3, 4},
//                {6, 0, 1, 7, 0, 0, 0, 0, 0},
//                {1, 0, 6, 4, 0, 0, 9, 5, 0},
//                {3, 0, 0, 0, 6, 0, 0, 0, 0},
//                {0, 2, 7, 3, 9, 0, 0, 8, 0}
//        };
//
//        Solver solver = new Solver();
//        solver.setSudoku(test);
//
//        if (solver.solve(0, 0)) {
//            for (int i = 0; i < 9; i++) {
//
//                System.out.println(Arrays.toString(solver.getResult()[i]));
//            }
//        }
//    }

    private int[][] getResult() {
        return result;
    }
}

