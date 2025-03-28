package edu.abel.core;

import edu.abel.models.Board;

import java.util.Random;

public class SudokuGenerator {
    private static final Random random = new Random();

    public static Board generate() {
        Board board = new Board(new int[9][9]);
        SudokuSolver solver = new SudokuSolver();
        solver.solve(board);
        removeCells(board, 40);
        return board;
    }

    private static void removeCells(Board board, int cellsToRemove) {
        for (int i = 0; i < cellsToRemove; i++) {
            int row, col;
            do {
                row = random.nextInt(9);
                col = random.nextInt(9);
            } while (board.getCell(row, col).getValue() == 0);
            board.setCellValue(row, col, 0);
        }
    }
}
