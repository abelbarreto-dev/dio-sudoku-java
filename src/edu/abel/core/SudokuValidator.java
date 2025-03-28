package edu.abel.core;

import edu.abel.models.Board;

public class SudokuValidator {
    public static boolean isValidMove(Board board, int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if (board.getCell(row, i).getValue() == num || board.getCell(i, col).getValue() == num) {
                return false;
            }
        }

        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(boxRow + i, boxCol + j).getValue() == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
