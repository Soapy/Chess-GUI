/**
 *
 */

public interface Movable {
    /**
     *  The logic of where a unit is able to move to.
     */
    public void move(Tile[][] board);

    /**
     * If a unit moves onto a tile that contains an enemy unit, then enemy unit is replaced by the new unit.
     */
    public void capture();
}
