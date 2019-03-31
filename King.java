public class King extends Piece {

    public King(Color color, int row, int column) {
        super(color, "King", row, column);
    }

    /**
     * The logic of where a unit is able to move to.
     *
     * @param
     */
    @Override
    public void move() {

    }

    /**
     * If a unit moves onto a tile that contains an enemy unit, then enemy unit is replaced by the new unit.
     */
    @Override
    public void capture() {

    }
}
