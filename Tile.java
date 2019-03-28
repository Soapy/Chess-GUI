public class Tile {
    Piece piece;

    public Tile() {

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
}
