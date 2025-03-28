package edu.abel.core;

import edu.abel.models.Board;

public class SudokuSolver {
    public boolean solve(Board board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getCell(row, col).getValue() == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (SudokuValidator.isValidMove(board, row, col, num)) {
                            board.setCellValue(row, col, num);
                            if (solve(board)) {
                                return true;
                            }
                            board.setCellValue(row, col, 0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
