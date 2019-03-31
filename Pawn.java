public class Pawn extends Piece {

    private boolean hasMoved;

    public Pawn(Color color, int row, int column) {
        super(color, "Pawn", row, column);
        hasMoved = false;
    }

    /**
     * The logic of where a unit is able to move to.
     */
    public void move(Tile[][] board) {

    }

    /**
     * If a unit moves onto a tile that contains an enemy unit, then enemy unit is replaced by the new unit.
     */
    @Override
    public void capture() {

    }

    /**
     * If a unit moves onto a tile that contains an enemy unit, then enemy unit is replaced by the new unit.
     */

    public void promote() {

    }
}
