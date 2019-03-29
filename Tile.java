public class Tile {
    private String name;
    private Piece piece;

    public Tile(String name) {
        piece = null;
        this.name = name;
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
    public void addPiece(Piece piece) {
        this.piece = piece;
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
