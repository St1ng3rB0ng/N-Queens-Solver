package NQueensSolver.data;

public class Solver {
    private int[] firstSolution;
    private boolean found;
    private int solutionCount;

    public void solveNQueens(int n) {
        found = false;
        firstSolution = new int[n];
        solutionCount = 0;
        int[] board = new int[n];
        placeQueens(board, 0, n);
    }

    private void placeQueens(int[] board, int row, int n) {
        if (row == n) {
            if (!found) {
                System.arraycopy(board, 0, firstSolution, 0, n);
                found = true;
            }
            solutionCount++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                placeQueens(board, row + 1, n);
            }
        }
    }

    private boolean isSafe(int[] board, int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = board[prevRow];
            if (prevCol == col || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasSolution() {
        return found;
    }

    public int[] getFirstSolution() {
        return firstSolution;
    }

    public int getSolutionCount() {
        return solutionCount;
    }
}