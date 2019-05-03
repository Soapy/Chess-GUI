
/**
 * Chess piece Knight. Can only move in an L shape.
 * author: Stefan Heng
 */

import javafx.scene.image.Image;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);

        img = color == Color.WHITE ? new Image("assets/pieces/knight_white.png") :
                new Image("assets/pieces/knight_black.png");
    }

    /**
     * Movement logic of Queen.
     * @param t the tile to be moved to
     * @param b the board containing this piece
     * @return true if this Queen can move to t, false if it cannot move to t
     */
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

            int x = currentLoc.getX();
            int y = currentLoc.getY();
            int tX = tLoc.getX();
            int tY = tLoc.getY();
        }
        return flag;
    }

    /**
     * Obtains all the legal moves of this Knight in a game of Chess.
     * @return an array of legal moves that this Knight can perform.
     */
    @Override
    public Moveset[] getLegalMoves() {
        Moveset[] m = {Moveset.ONE_WEST_TWO_NORTH, Moveset.ONE_EAST_TWO_NORTH, Moveset.ONE_EAST_TWO_SOUTH,
                Moveset.ONE_WEST_TWO_SOUTH, Moveset.TWO_WEST_ONE_SOUTH, Moveset.TWO_EAST_ONE_NORTH,
                Moveset.TWO_EAST_ONE_SOUTH, Moveset.TWO_WEST_ONE_NORTH};
        return m;
    }
}
