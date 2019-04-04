import java.util.ArrayList;
import java.util.Set;

public abstract class Piece{
    private final Color color;
    private Tile tile;

    public Piece(Color color) {
        this.color = color;
    }


    public Color getColor() {
        return color;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean canMove(Board board) {
        boolean flag = false;
        ArrayList<Tile> possibleMoves = getLegalMoves(board);

        for(int i = 0; i < possibleMoves.size(); i++) {
            if(move(possibleMoves.get(i), board)) {
                flag = true;
            }
        }

        return flag;
    }

    public abstract boolean move(Tile t, Board b);

    public abstract ArrayList<Tile> getLegalMoves(Board b);

    public String toString() {
        String str = this.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder(str.substring(0, 2));
        sb.append(color.name().charAt(0));

        return sb.toString();
    }
}
