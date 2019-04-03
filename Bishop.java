import java.util.ArrayList;
import java.util.Set;

public class Bishop extends Piece {

    public Bishop(Color color, Tile tile) {
        super(color, "Bishop", tile);
    }

    /** Bishops can only move diagonally, towards the enemy's side of the field
     *  or towards its original location.
     *  Can move: Northwest, Northeast, Southwest, Southeast.
     * @param t 2D array of Tiles
     * @return All the legal moves for this piece
     */
    @Override
    public ArrayList<Tile> getLegalMoves(Tile[][] t) {
        int currentRow = getTile().getRow();
        int currentColumn = getTile().getColumn();

        ArrayList<Tile> arr = getDiagonals(t, currentRow, currentColumn);

        return arr;
    }
}
