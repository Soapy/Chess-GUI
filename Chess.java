/**
 * Handles logic of the game of chess.
 * TODO: Add GUI
 */

public class Chess {
    public int currentTurn;
    public Board board;

    public Chess() {
        currentTurn = 0;
        board = new Board(8, 8); //Chess is played on an 8 by 8 board.
        createPieces();
    }

    private void createPieces() {
        createWhitePieces();
        createBlackPieces();
    }

    private void createBlackPieces() { //FIX THIS! VERY UGLY BUT IT WORKS.
        for(int i = 0; i < board.board[1].length; i++) {
            Pawn pawn = new Pawn(Color.BLACK, 1, i);
            board.board[1][i].setPiece(pawn);
        }
        Rook rook = new Rook(Color.BLACK, 0, 0);
        board.board[0][0].setPiece(rook);
        board.board[0][7].setPiece(rook, 0, 7);
        Knight knight = new Knight(Color.BLACK, 0, 1);
        board.board[0][1].setPiece(knight);
        board.board[0][6].setPiece(knight, 0 ,6);
        Bishop bishop = new Bishop(Color.BLACK, 0, 2);
        board.board[0][2].setPiece(bishop);
        board.board[0][5].setPiece(bishop, 0, 5);
        Queen queen = new Queen(Color.BLACK, 0,3);
        board.board[0][3].setPiece(queen);
        King king = new King(Color.BLACK, 0,4);
        board.board[0][4].setPiece(king);
    }

    private void createWhitePieces() { //FIX THIS! VERY UGLY BUT IT WORKS.
        for(int i = 0; i < board.board[6].length; i++) {
            Pawn pawn = new Pawn(Color.WHITE, 6, i);
            board.board[6][i].setPiece(pawn);
        }
        Rook rook = new Rook(Color.WHITE, 7, 0);
        board.board[7][0].setPiece(rook);
        board.board[7][7].setPiece(rook, 7, 7);
        Knight knight = new Knight(Color.WHITE, 7, 1);
        board.board[7][1].setPiece(knight);
        board.board[7][6].setPiece(knight, 7, 6);
        Bishop bishop = new Bishop(Color.WHITE, 7, 2);
        board.board[7][2].setPiece(bishop);
        board.board[7][5].setPiece(bishop, 7, 5);
        Queen queen = new Queen(Color.WHITE, 7, 3);
        board.board[7][3].setPiece(queen);
        King king = new King(Color.WHITE, 7, 4);
        board.board[7][4].setPiece(king);
    }

    public void playGame() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(board.toString());
        sb.append("\nCurrent turn: " + currentTurn + "\n");
        currentTurn++;

        board.move(board.board[6][1]);

        sb.append(board.toString());
        sb.append("\nCurrent turn: " + currentTurn + "\n");
        currentTurn++;

        board.move(board.board[7][2]);
        sb.append(board.toString());
        sb.append("\nCurrent turn: " + currentTurn + "\n");
        currentTurn++;

        return sb.toString();
    }
}
