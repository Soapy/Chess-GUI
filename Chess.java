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
        for(Tile tile : board.board[1]) {
            tile.setPiece(new Pawn(Color.BLACK));
        }
        Rook rook = new Rook(Color.BLACK);
        board.board[0][0].setPiece(rook);
        board.board[0][7].setPiece(rook);
        Knight knight = new Knight(Color.BLACK);
        board.board[0][1].setPiece(knight);
        board.board[0][6].setPiece(knight);
        Bishop bishop = new Bishop(Color.BLACK);
        board.board[0][2].setPiece(bishop);
        board.board[0][5].setPiece(bishop);
        Queen queen = new Queen(Color.BLACK);
        board.board[0][3].setPiece(queen);
        King king = new King(Color.BLACK);
        board.board[0][4].setPiece(king);
    }

    private void createWhitePieces() { //FIX THIS! VERY UGLY BUT IT WORKS.
        for(Tile tile : board.board[6]) {
            tile.setPiece(new Pawn(Color.WHITE));
        }
        Rook rook = new Rook(Color.WHITE);
        board.board[7][0].setPiece(rook);
        board.board[7][7].setPiece(rook);
        Knight knight = new Knight(Color.WHITE);
        board.board[7][1].setPiece(knight);
        board.board[7][6].setPiece(knight);
        Bishop bishop = new Bishop(Color.WHITE);
        board.board[7][2].setPiece(bishop);
        board.board[7][5].setPiece(bishop);
        Queen queen = new Queen(Color.WHITE);
        board.board[7][3].setPiece(queen);
        King king = new King(Color.WHITE);
        board.board[7][4].setPiece(king);
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
