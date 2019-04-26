import javafx.scene.image.Image;

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
        img = color == Color.WHITE ? new Image("assets/pieces/king_white.png") :
                new Image("assets/pieces/king_black.png");
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

            int x = currentLoc.getX();
            int y = currentLoc.getY();
            int tX = tLoc.getX();
            int tY = tLoc.getY();

            //states that king can only move one tile away from its original location
            if(Math.abs(tX - x) < 2 && Math.abs(tY - y) < 2) {
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

        int x = myLocation.getX();
        int y = myLocation.getY();
        int boardColumns = board[0].length;
        int boardRows = board.length;

        if(y + 1 < boardRows) {
            //moves east
            legalMoves.add(board[x][y + 1]);
            if(x + 1 < boardRows) {
                //moves northeast
                legalMoves.add(board[x + 1][y + 1]);
            }
            if(x - 1 >= 0) {
                //moves southeast
                legalMoves.add(board[x - 1][y + 1]);
            }
        }
        if(y - 1 >= 0) {
            //moves west
            legalMoves.add(board[x][y - 1]);
            if(x - 1 >= 0) {
                //moves southwest
                legalMoves.add(board[x - 1][y - 1]);
            }
            if(x + 1 < boardRows) {
                //moves northwest
                legalMoves.add(board[x + 1][y - 1]);
            }
        }

        if(x - 1 >= 0) {
            //moves south
            legalMoves.add(board[x - 1][y]);
        }

        if(x + 1 < boardColumns) {
            //moves north
            legalMoves.add(board[x + 1][y]);
        }
        return legalMoves;
    }

    public Moveset[] getPieceMoves()
    {
        Moveset[] m =
                {
                        Moveset.UP,
                        Moveset.UP_RIGHT,
                        Moveset.RIGHT,
                        Moveset.DOWN_RIGHT,
                        Moveset.DOWN,
                        Moveset.DOWN_LEFT,
                        Moveset.LEFT,
                        Moveset.UP_LEFT
                };
        return m;
    }
}
