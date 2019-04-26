import javafx.scene.image.Image;
import java.util.ArrayList;

public abstract class Piece{
    private Color color;
    private Tile tile;
    protected Image img;
    protected boolean hasMoved;

    public Piece(Color color) {
        this.color = color;
        hasMoved = false;
    }

    public Image getImage() {
        return img;
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

    public boolean getHasMoved()
    {
        return this.hasMoved;
    }

    public void setHasMoved(boolean hasMoved)
    {
        this.hasMoved = hasMoved; //if a piece has moved once, it will always be true in this case
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
    public abstract Moveset[] getPieceMoves();

    public String toString() {
        String str = this.getClass().getSimpleName();
        if(color == Color.WHITE) {
            str = str.toLowerCase();
        }
        StringBuilder sb = new StringBuilder(str.substring(0, 2));
        return sb.toString();
    }
}
