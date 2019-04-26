import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Tile extends Button {

    private Location loc;
    private Piece piece;

    public Tile(Location loc, boolean isWhite) {
        this.loc = loc;
        piece = null;

        this.getStyleClass().add("chess");
        this.getStyleClass().add(isWhite ? "chess-white" : "chess-black");
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

        ImageView img = this.piece == null ? new ImageView() : new ImageView(piece.getImage());
        img.setFitWidth(50);
        img.setFitHeight(50);
        this.setGraphic(img);
    }

    public Piece getPiece() {
        return piece;
    }

    public Location getLoc() {
        return loc;
    }
    /**
     * Removes a piece from the Tile.
     */
    public Piece removePiece() {
        Piece p = piece;
        setPiece(null);
        return p;
    }

}
