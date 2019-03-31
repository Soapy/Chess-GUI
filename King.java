public class King extends Piece {

    public King(Color color) {
        super(color, "King");
    }

    /**
     * The logic of where a unit is able to move to.
     *
     * @param board
     */
    @Override
    public void move(Tile[][] board) {

    }

    /**
     * If a unit moves onto a tile that contains an enemy unit, then enemy unit is replaced by the new unit.
     */
    @Override
    public void capture() {

    }
}
