public class Rook extends Piece {

    public Rook(Color color) {
        super(color, "Rook");
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
