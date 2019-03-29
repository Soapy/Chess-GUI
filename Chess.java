/**
 * Handles logic of the game of chess.
 * TODO: Add GUI
 */

public class Chess {
    public int currentTurn;
    Board board;

    public Chess() {
        currentTurn = 0;
        Board board = new Board(8, 8); //Chess is played on an 8 by 8 board.
    }

    public void playGame() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(board.toString());
        sb.append("\nCurrent turn: " + currentTurn);
        return sb.toString();
    }
}
