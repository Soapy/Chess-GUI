import java.util.Set;

public class Knight extends Piece {

    public Knight(Color color, Tile tile) {
        super(color, "Knight", tile);
    }

    @Override
    public Set<Tile> getLegalMoves() {
        return null;
    }
}
