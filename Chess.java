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
            Pawn pawn = new Pawn(Color.BLACK);
            board.board[1][i].setPiece(pawn, 1, i);
        }
        Rook rook = new Rook(Color.BLACK);
        board.board[0][0].setPiece(rook, 0, 0);
        board.board[0][7].setPiece(rook, 0, 7);
        Knight knight = new Knight(Color.BLACK);
        board.board[0][1].setPiece(knight, 0, 1);
        board.board[0][6].setPiece(knight, 0 ,6);
        Bishop bishop = new Bishop(Color.BLACK);
        board.board[0][2].setPiece(bishop, 0, 2);
        board.board[0][5].setPiece(bishop, 0, 5);
        Queen queen = new Queen(Color.BLACK);
        board.board[0][3].setPiece(queen, 0, 3);
        King king = new King(Color.BLACK);
        board.board[0][4].setPiece(king, 0, 4);
    }

    private void createWhitePieces() { //FIX THIS! VERY UGLY BUT IT WORKS.
        for(int i = 0; i < board.board[6].length; i++) {
            Pawn pawn = new Pawn(Color.WHITE);
            board.board[1][i].setPiece(pawn, 6, i);
        }
        Rook rook = new Rook(Color.WHITE);
        board.board[7][0].setPiece(rook, 7, 0);
        board.board[7][7].setPiece(rook, 7, 7);
        Knight knight = new Knight(Color.WHITE);
        board.board[7][1].setPiece(knight, 7, 1);
        board.board[7][6].setPiece(knight, 7, 6);
        Bishop bishop = new Bishop(Color.WHITE);
        board.board[7][2].setPiece(bishop, 7, 2);
        board.board[7][5].setPiece(bishop, 7, 5);
        Queen queen = new Queen(Color.WHITE);
        board.board[7][3].setPiece(queen, 7, 3);
        King king = new King(Color.WHITE);
        board.board[7][4].setPiece(king, 7, 4);
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
