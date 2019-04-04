import java.util.ArrayList;
import java.util.Set;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean move(Tile t, Board b) {
        return false;
    }

    @Override
    public ArrayList<Tile> getLegalMoves(Board b) {
        return null;
    }
}
