/**
 * Represents a Chess piece's color.
 * author: Stefan Heng
 */
public enum Color {
    WHITE,
    BLACK;

    public String toString() {
        if(this == WHITE) {
            return "White";
        }
        else {
            return "Black";
        }
    }
}
