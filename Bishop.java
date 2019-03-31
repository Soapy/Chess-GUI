public class Bishop extends Piece {

    public Bishop(Color color, int row, int column) {
        super(color, "Bishop", row, column);
    }

    /**
     * The logic of where a unit is able to move to.
     *
     * @param
     */
    @Override
    public void move() {
        Location loc = getLocation();
        setLocation(loc.getRow() - 2, loc.getColumn() - 2);
    }

    /**
     * If a unit moves onto a tile that contains an enemy unit, then enemy unit is replaced by the new unit.
     */
    @Override
    public void capture() {

    }
}
