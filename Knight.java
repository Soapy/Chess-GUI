public class Knight extends Piece {

    public Knight(Color color) {
        super(color, "Knight");
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
