package edu.abel.view;

import edu.abel.core.SudokuGenerator;
import edu.abel.core.SudokuValidator;
import edu.abel.models.Board;

import java.util.Scanner;

public class SudokuGame {
    private final Board board;
    private final Scanner scanner;

    public SudokuGame() {
        this.board = SudokuGenerator.generate();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Bem-vindo ao Sudoku!");
        while (!isGameComplete()) {
            printBoard();
            playerMove();
        }
        printBoard();
        System.out.println("Parabéns! Você resolveu o Sudoku!");
    }

    private void printBoard() {
        System.out.println("  0 1 2   3 4 5   6 7 8");
        System.out.println("  ---------------------");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("  ---------------------");
            }
            System.out.print(i + "| ");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                int value = board.getCell(i, j).getValue();
                System.out.print((value == 0 ? "." : value) + " ");
            }
            System.out.println("|");
        }
        System.out.println("  ---------------------");
    }

    private void playerMove() {
        System.out.println("Digite sua jogada no formato: linha coluna valor (ex: 0 1 5)");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int value = scanner.nextInt();

        if (row < 0 || row > 8 || col < 0 || col > 8 || value < 1 || value > 9) {
            System.out.println("Entrada inválida! Tente novamente.");
            return;
        }

        if (board.getCell(row, col).isFixed()) {
            System.out.println("Essa posição não pode ser alterada.");
            return;
        }

        if (!SudokuValidator.isValidMove(board, row, col, value)) {
            System.out.println("Movimento inválido! O número não pode estar na linha, coluna ou bloco.");
            return;
        }

        board.setCellValue(row, col, value);
    }

    private boolean isGameComplete() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getCell(i, j).getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new SudokuGame().start();
    }
}
