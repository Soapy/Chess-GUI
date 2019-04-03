import java.util.Set;

public class Rook extends Piece {

    public Rook(Color color, Tile tile) {
        super(color, "Rook", tile);
    }

    @Override
    public Set<Tile> getLegalMoves() {
        return null;
    }
}
