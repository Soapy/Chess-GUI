public class Tile {
    private int row;
    private int column;

    private Piece piece;

    public Tile(int row, int column) {
        this.row = row;
        this.column = column;
        piece = null;
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
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Removes a piece from the Tile.
     */
    public Piece removePiece() {
        Piece p = piece;
        piece = null;
        return p;
    }

    /**
     *
     * @param p
     */
    public void capturePiece(Piece p) {
        Piece p1 = getPiece();
        if(p.getColor() == Color.WHITE) {

        }
        else {

        }
        piece = p;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}
