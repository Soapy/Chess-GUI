import java.util.ArrayList;
import java.util.Set;

public class King extends Piece {

    public King(Color color, Tile tile) {
        super(color, "King", tile);
    }

    @Override
    public ArrayList<Tile> getLegalMoves(Tile[][] t) {
        return null;
    }
}
