import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class King extends Piece {

    /**
     * King Constructor
     * @param color assigns a color to the King piece
     */
    public King(Color color) {
        super(color);

        //maybe use String.format() instead of ternary??
        //FIX FILE PATH
        img = color == Color.WHITE ? new Image("file: assets/king_white.png") :
                new Image("file: assets/king_black.png");
        imgView = new ImageView(img);
    }

    /**
     * Contains the movement logic of the King piece
     * @param t the tile of the this King
     * @param b the game board with this King
     * @return flag
     */
    @Override
    public boolean move(Tile t, Board b) {
        //boolean variable that checks if the this King  can move to a Tile
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

            int column = currentLoc.getColumn();
            int row = currentLoc.getRow();
            int tColumn = tLoc.getColumn();
            int tRow = tLoc.getRow();

            //states that king can only move one tile away from its original location
            if(Math.abs(tRow - row) < 2 && Math.abs(tColumn - column) < 2) {
                flag = true;
            }

            else {
                flag = false;
            }
        }
        return flag;
    }

    /**
     *
     * @param b the board with this King
     * @return legalMoves which is an ArrayList with all the legal moves for the this King
     */
    @Override
    public ArrayList<Tile> getLegalMoves(Board b) {
        //ArrayList of legal moves for this King
        ArrayList<Tile> legalMoves = new ArrayList<>();

        Location myLocation = getTile().getLoc();
        Tile[][] board = b.getBoard();

        int column = myLocation.getColumn();
        int row = myLocation.getRow();
        int boardColumns = board[0].length; //8
        int boardRows = board.length; //8

        if(column + 1 >= 0) {
            //moves east
            legalMoves.add(board[row][column + 1]);
            if(row + 1 < boardRows) {
                //moves northeast
                legalMoves.add(board[row + 1][column + 1]);
            }
            if(row - 1 >= 0) {
                //moves southeast
                legalMoves.add(board[row - 1][column + 1]);
            }
        }
        if(column - 1 >= 0) {
            //moves west
            legalMoves.add(board[row][column - 1]);
            if(row - 1 >= 0) {
                //moves southwest
                legalMoves.add(board[row - 1][column - 1]);
            }
            if(row + 1 < boardRows) {
                //moves northwest
                legalMoves.add(board[row + 1][column - 1]);
            }
        }

        if(row - 1 >= 0) {
            //moves south
            legalMoves.add(board[row - 1][column]);
        }

        if(row + 1 < boardColumns) {
            //moves north
            legalMoves.add(board[row + 1][column]);
        }

        return legalMoves;
    }
}
