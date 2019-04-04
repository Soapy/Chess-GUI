import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Color color) {
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
