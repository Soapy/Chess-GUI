import java.util.Set;

public class Queen extends Piece {

    public Queen(Color color, Tile tile) {
        super(color, "Queen", tile);
    }

    @Override
    public Set<Tile> getLegalMoves() {
        return null;
    }
}
