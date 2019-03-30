public class Knight extends Piece {

    public Knight(Color color) {
        super(color, "Knight");
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

    /**
     * Overrides Piece's toString() in order to differentiate Knight between
     * King's string representation when printed to the terminal.
     * @return the first two letters of Knight
     */
    @Override
    public String toString() {
        String str = this.getClass().getSimpleName();
        return str.substring(0, 2);
    }
}
