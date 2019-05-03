/**
 * Details all the logic of how a piece can move.
 */
public enum Moveset {
    NORTH (0,1),
    NORTHEAST(1, 1),
    EAST(1, 0),
    SOUTHEAST(1, -1),
    SOUTH(0,-1),
    SOUTHWEST(-1, -1),
    WEST(-1, 0),
    NORTHWEST(-1, 1),

    ONE_WEST_TWO_NORTH(-1, 2),
    ONE_EAST_TWO_NORTH(1, 2),
    ONE_EAST_TWO_SOUTH(1, -2),
    ONE_WEST_TWO_SOUTH(-1, -2),
    TWO_WEST_ONE_SOUTH(-2, -1),
    TWO_EAST_ONE_NORTH(2, 1),
    TWO_EAST_ONE_SOUTH(2, -1),
    TWO_WEST_ONE_NORTH(-2, 1),

    TWO_NORTH(0, 2),
    TWO_SOUTH(0, -2);

    private int x, y;

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    Moveset(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
