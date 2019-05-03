/**
 * Chess piece King. Can only move to the tiles around this piece.
 * author: Stefan Heng
 */

import javafx.scene.image.Image;

public class King extends Piece {

    /**
     * King Constructor
     * @param color assigns a color to the King piece
     */
    public King(Color color) {
        super(color);

        img = color == Color.WHITE ? new Image("assets/pieces/king_white.png") :
                new Image("assets/pieces/king_black.png");
    }

    /**
     * Movement logic of King.
     * @param t the tile to be moved to
     * @param b the board containing this piece
     * @return true if this King can move to t, false if it cannot move to t
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
     * Obtains all the legal moves of this King in a game of Chess.
     * @return an array of legal moves that this King can perform.
     */
    public Moveset[] getLegalMoves() {
        Moveset[] m = {Moveset.NORTH, Moveset.NORTHEAST, Moveset.NORTHWEST,
                Moveset.SOUTH, Moveset.SOUTHWEST, Moveset.SOUTHEAST,
                Moveset.EAST, Moveset.WEST};
        return m;
    }
}
