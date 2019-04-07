/**
 * Handles GUI
 * TODO: Add GUI
 */
import java.util.ArrayList;

public class Chess {

    private int turnCount;
    private boolean whitePlayerTurn;
    private Board board;
    private ArrayList<Piece> capturedWhitePieces;
    private ArrayList<Piece> capturedBlackPieces;

    public Chess() {
        turnCount = 1;
        board = new Board(8, 8); //Chess is played on an 8 by 8 board.
        createWhitePieces();
        createBlackPieces();

        capturedWhitePieces = new ArrayList<>();
        capturedBlackPieces = new ArrayList<>();
    }

    private void createWhitePieces() {
        for(int i = 0; i < board.getRow(); i++) {
            Pawn pawn = new Pawn(Color.WHITE);
            board.getTile(6, i).setPiece(pawn);
        }

        //initialize Rooks
        board.getTile(7,0).setPiece(new Rook(Color.WHITE));
        board.getTile(7,7).setPiece(new Rook(Color.WHITE));
        //initialize knights
        board.getTile(7,1).setPiece(new Knight(Color.WHITE));
        board.getTile(7,6).setPiece(new Knight(Color.WHITE));
        //initialize bishops
        board.getTile(7,2).setPiece(new Bishop(Color.WHITE));
        board.getTile(7,5).setPiece(new Bishop(Color.WHITE));
        //initialize queen
        board.getTile(7,3).setPiece(new Queen(Color.WHITE));
        //initialize king
        board.getTile(7,4).setPiece(new King(Color.WHITE));
    }

    private void createBlackPieces() {
        for(int i = 0; i < board.getRow(); i++) {
            Pawn pawn = new Pawn(Color.BLACK);
            board.getTile(1, i).setPiece(pawn);
        }

        //initialize Rooks
        board.getTile(0,0).setPiece(new Rook(Color.BLACK));
        board.getTile(0,7).setPiece(new Rook(Color.BLACK));
        //initialize knights
        board.getTile(0,1).setPiece(new Knight(Color.BLACK));
        board.getTile(0,6).setPiece(new Knight(Color.BLACK));
        //initialize bishops
        board.getTile(0,2).setPiece(new Bishop(Color.BLACK));
        board.getTile(0,5).setPiece(new Bishop(Color.BLACK));
        //initialize queen
        board.getTile(0,3).setPiece(new Queen(Color.BLACK));
        //initialize king
        board.getTile(0,4).setPiece(new King(Color.BLACK));
    }

    public void testMove() {
        board.getTile(1, 1).getPiece().move(board.getTile(2, 1), board);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(board.toString());
        sb.append("\nCurrent turn: " + turnCount + "\n");
        sb.append(board.toString());

        return sb.toString();
    }
}
