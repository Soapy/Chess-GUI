import javafx.scene.image.Image;

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

    public boolean getHasMoved() {
        return this.hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved; //if a piece has moved once, it will always be true in this case
    }
    /**
     * Movement logic of piece.
     * @param t the tile to be moved to
     * @param b the board containing this piece
     * @return true if this piece can move to t, false if it cannot move to t
     */
    public abstract boolean move(Tile t, Board b);

    /**
     * Obtains all the legal moves of this piece in a game of Chess.
     * @return an array of legal moves that this piece can perform.
     */
    public abstract Moveset[] getLegalMoves();

    public String toString() {
        String str = this.getClass().getSimpleName();
        if(color == Color.WHITE) {
            str = str.toLowerCase();
        }
        StringBuilder sb = new StringBuilder(str.substring(0, 2));
        return sb.toString();
    }
}
