public class Pawn extends Piece {

    private boolean hasMoved;

    public Pawn(Color color, int row, int column) {
        super(color, "Pawn", row, column);
        hasMoved = false;
    }

    /**
     * The logic of where a unit is able to move to.
     */
    @Override
    public void move() {
        if(hasMoved) {
            Location loc = getLocation();
            setLocation(loc.getRow() - 1, loc.getColumn());
        }
        else {
            Location loc = getLocation();
            setLocation(loc.getRow() - 2, loc.getColumn());
            hasMoved = true;
        }
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
