/**
 * Chess piece Pawn. Can only move up or down one or two tiles depending on previous movement.
 * Can only move diagonally if it can capture an opposing player's piece.
 * author: Stefan Heng
 */

import javafx.scene.image.Image;
import java.util.ArrayList;

public class Pawn extends Piece {

    //boolean variable to check if the this Pawn has moved
    /**
     * Pawn Constructor
     * @param color assigns a color to the Pawn piece
     */
    public Pawn(Color color) {
        super(color);

        img = color == Color.WHITE ? new Image("assets/pieces/pawn_white.png") :
                new Image("assets/pieces/pawn_black.png");
    }

    /**
     * Sets the Pawn piece to Moved
     */
    public void setHasMoved() {
        hasMoved = true;
    }

    /**
     * Gets the hasMoved boolean variable
     * @return hasMoved
     */
    public boolean getHasMoved() {
        return hasMoved;
    }

    /**
     * Movement logic of Pawn.
     * @param t the tile to be moved to
     * @param b the board containing this piece
     * @return true if this Pawn can move to t, false if it cannot move to t
     */
    @Override
    public boolean move(Tile t, Board b) {
        //boolean variable that checks if the this Pawn can move to a Tile
        boolean flag = true;

        //sets flag to false if t and current tile are the same tile
        if(getTile() == t) {
            flag = false;
        }

        //checks if t is the same color as the already existing piece
        if(t.hasPiece() && t.getPiece().getColor() == getColor()) {
            flag = false;
        }

        Location currentLoc = getTile().getLoc();
        Location tLoc = t.getLoc();

        Tile[][] currentBoard = b.getBoard();

        int x = currentLoc.getX();
        int y = currentLoc.getY();
        int tX = tLoc.getX();
        int tY = tLoc.getY();

        if(flag) {
            // check moves if pawn is white
            if(getColor() == Color.WHITE) {
                //if first pace forward is empty
                if(tX == x && tY == (y + 1) && !t.hasPiece()) {
                    flag = true;
                }

                //if first and second space if empty
                else if(tX == x && tY == (y + 2) && !t.hasPiece()) {
                    //if this pawn has not moved
                    if(!currentBoard[x][y + 1].hasPiece() && !hasMoved) {
                        flag = true;
                    }
                }

                //captures
                else if((tX == (x + 1) || tX == (x - 1)) && tY == (y + 1)) {
                    if(t.hasPiece() && t.getPiece().getColor() == Color.BLACK) {
                        flag = true;
                    }
                }
            }

            // check moves if pawn is black
            else {
                //if first space forward is empty
                if(tX == x && tY == (y - 1) && !t.hasPiece()) {
                    flag = true;
                }

                //if first and second space if empty
                else if(tX == x && tY == (y - 2) && !t.hasPiece()) {
                    if(!currentBoard[x][y - 1].hasPiece() && !hasMoved) {
                        flag = true;
                    }
                }

                //capture
                else if((tX == (x + 1) || tX == (x - 1)) && tY == (y - 1)) {
                    if(!t.hasPiece() && t.getPiece().getColor() == Color.WHITE) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * Obtains all the legal moves of this Pawn in a game of Chess.
     * @return an array of legal moves that this Pawn can perform.
     */
    public Moveset[] getLegalMoves() {
        Moveset[] m = {};
        boolean isWhite = this.getColor() == Color.WHITE;

        if(isWhite) {
            ArrayList<Moveset> whiteMoves = new ArrayList<>();

            whiteMoves.add(Moveset.NORTH);

            //capture diagonally
            whiteMoves.add(Moveset.NORTHEAST);
            whiteMoves.add(Moveset.NORTHWEST);

            if(!hasMoved) {
                whiteMoves.add(Moveset.TWO_NORTH);
                hasMoved = true;
            }

            m = whiteMoves.toArray(m);
        }
        else {
            ArrayList<Moveset> blackMoves = new ArrayList<>();

            blackMoves.add(Moveset.SOUTH);

            //capture diagonally
            blackMoves.add(Moveset.SOUTHEAST);
            blackMoves.add(Moveset.SOUTHWEST);

            if(!hasMoved) {
                blackMoves.add(Moveset.TWO_SOUTH);
                hasMoved = true;
            }

            m = blackMoves.toArray(m);
        }
        return m;
    }
}
