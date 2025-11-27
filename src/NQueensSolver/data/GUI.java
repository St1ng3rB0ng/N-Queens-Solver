package NQueensSolver.data;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {
    private final int boardSize;
    private final int[] solution;

    public GUI(int boardSize, int[] solution) {
        this.boardSize = boardSize;
        this.solution = solution;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = Math.min(getWidth(), getHeight()) / boardSize;

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                g.setColor((row + col) % 2 == 0 ? Color.WHITE : Color.BLACK);
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }

        g.setColor(Color.RED);
        Font font = new Font("Arial", Font.BOLD, cellSize / 2);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        for (int row = 0; row < boardSize; row++) {
            int col = solution[row];
            int x = col * cellSize + (cellSize - fm.stringWidth("Q")) / 2;
            int y = row * cellSize + (cellSize + fm.getAscent()) / 2;
            g.drawString("Q", x, y);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public static void displaySolution(int boardSize, int[] solution) {
        JFrame frame = new JFrame("N-Queens First Solution");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new GUI(boardSize, solution));
        frame.setVisible(true);
    }
}