import java.util.ArrayList;
import java.util.Set;

public class Knight extends Piece {

    public Knight(Color color) {
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
