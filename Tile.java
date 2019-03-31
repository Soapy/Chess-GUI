public class Tile {
    private String name;
    private Piece piece;

    public Tile(String name) {
        this(name, null);
    }

    public Tile(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    /**
     * @return True if a piece exists on the tile. False if no piece exists on the tile.
     */
    public Boolean hasPiece() {
        return piece != null;
    }

    /**
     * @param piece
     */
    public void setPiece(Piece piece, int row, int column) {
        this.piece = piece;
        this.piece.setLocation(row, column);
    }

    public void setPiece(Piece piece) {
        setPiece(piece, piece.getLocation().getRow(), piece.getLocation().getColumn());
    }

    /**
     * Removes a piece from the Tile.
     */
    public void removePiece() {
        piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
