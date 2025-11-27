package NQueensSolver.main;

import NQueensSolver.data.GUI;
import NQueensSolver.data.Solver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int boardSize = 8;
        Solver solver = new Solver();
        solver.solveNQueens(boardSize);

        if (solver.hasSolution()) {
            System.out.println("First solution for " + boardSize + "x" + boardSize + " board: "
                    + Arrays.toString(solver.getFirstSolution()));
            GUI.displaySolution(boardSize, solver.getFirstSolution());
            System.out.println("All possible solutions:" +solver.getSolutionCount());
        } else {
            System.out.println("No solution found for " + boardSize + "x" + boardSize + " board!");
        }
    }
}

