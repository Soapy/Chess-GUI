public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color, "Pawn");
    }

    /**
     * The logic of where a unit is able to move to.
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

    public void promote() {

    }
}
