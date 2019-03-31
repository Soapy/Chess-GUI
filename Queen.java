public class Queen extends Piece {


    public Queen(Color color, int row, int column) {
        super(color, "Queen", row, column);
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
