package edu.abel.models;

public class Board {
    private final Cell[][] grid = new Cell[9][9];

    public Board(int[][] initialValues) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boolean isFixed = (initialValues[i][j] != 0);
                grid[i][j] = new Cell(initialValues[i][j], isFixed);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public void setCellValue(int row, int col, int value) {
        grid[row][col].setValue(value);
    }
}
