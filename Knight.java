import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);

        //maybe use String.format() instead of ternary??
        //FIX FILE PATH
        img = color == Color.WHITE ? new Image("file: assets/knight_white.png") :
                new Image("file: assets/knight_black.png");
        imgView = new ImageView(img);
    }

    @Override
    public boolean move(Tile t, Board b) {
        boolean flag = true;

        //sets flag to false if t and current tile are the same tile
        if(getTile() == t) {
            flag = false;
        }

        //checks if t is the same color as the already existing piece
        if(t.hasPiece() && t.getPiece().getColor() == getColor()) {
            flag = false;
        }

        if(flag) {
            Location currentLoc = getTile().getLoc();
            Location tLoc = t.getLoc();

            Tile[][] currentBoard = b.getBoard();

            int column = currentLoc.getColumn();
            int row = currentLoc.getRow();
            int tColumn = tLoc.getColumn();
            int tRow = tLoc.getRow();

            if(getColor() == Color.WHITE) {

            }
            else {

            }
        }
        return flag;
    }

    @Override
    public ArrayList<Tile> getLegalMoves(Board b) {
        ArrayList<Tile> legalMoves = new ArrayList<>();

        Location myLocation = getTile().getLoc();
        Tile[][] board = b.getBoard();

        int column = myLocation.getColumn();
        int row = myLocation.getRow();
        int boardColumns = board[0].length;
        int boardRows = board.length;

        //knight can move forward
        if(row + 1 < boardRows && column - 2 >= 0) {
            legalMoves.add(board[row + 1][column - 2]);
        }

        if(row + 2 < boardRows && column - 1 >= 0) {
            legalMoves.add(board[row + 2][column - 1]);
        }

        if(row + 2 < boardRows && column + 1 < boardColumns) {
            legalMoves.add(board[row + 2][column + 1]);
        }

        if(row + 1 < boardRows && column + 2 < boardColumns) {
            legalMoves.add(board[row + 1][column + 2]);
        }

        //knight can move backward
        if(row + -1 >= 0 && column - 2 >= 0) {
            legalMoves.add(board[row + 1][column - 2]);
        }

        if(row - 2 >= 0 && column - 1 >= 0) {
            legalMoves.add(board[row + 2][column - 1]);
        }

        if(row - 2 >= 0 && column + 1 < boardColumns) {
            legalMoves.add(board[row + 2][column + 1]);
        }

        if(row - 1 >= 0 && column + 2 < boardColumns) {
            legalMoves.add(board[row + 1][column + 2]);
        }

        return legalMoves;
    }
}
