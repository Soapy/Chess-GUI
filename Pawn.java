import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean hasMoved;

    public Pawn(Color color, Tile tile) {
        super(color, "Pawn", tile);
        hasMoved = false;
    }

    public void setHasMoved() {
        hasMoved = true;
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    /**
     *
     */
    @Override
    public boolean move(Tile t) {
        hasMoved = true;
        return super.move(t);
    }

    /**
     *
     * @param t
     * @return All the legal moves for this piece
     */
    @Override
    public ArrayList<Tile> getLegalMoves(Tile[][] t) {
        ArrayList<Tile> arr = new ArrayList<>();

        int row = getTile().getRow();
        int column = getTile().getColumn();

        if(getColor() == Color.WHITE) {
            if(row - 1 >= 0) {
                if(!t[row - 1][column].hasPiece()) {
                    arr.add(t[row - 1][column]); // can move one space forward
                }
            }

            if(!hasMoved) {
                if(!t[row - 2][column].hasPiece()) {
                    arr.add(t[row - 2][column]); //can move two spaces forward
                }
            }

            if(row - 1 >= 0 && column + 1 <= 8) {
                if(!t[row - 1][column + 1].hasPiece()) {
                    arr.add(t[row - 1][column + 1]); //moves diagonally northwest (1 up, 1 right)
                }
            }

            if(row - 1 >= 0 && column - 1 > 8) {
                if(!t[row - 1][column + 1].hasPiece()) {
                    arr.add(t[row - 1][column - 1]); //moves diagonally northeast (1 up, 1 left)
                }
            }
        }

        else {
            if(row + 1 <= 8) {
                if(!t[row + 1][column].hasPiece()) {
                    arr.add(t[row + 1][column]); // can move one space downwards
                }
            }

            if(!hasMoved) {
                if(!t[row + 2][column].hasPiece()) {
                    arr.add(t[row + 2][column]); //can move two spaces downwards
                }
            }

            if(row + 1 <= 8 && column + 1 <= 8) {
                if(!t[row + 1][column + 1].hasPiece()) {
                    arr.add(t[row + 1][column + 1]); //moves diagonally southwest (1 down, 1 right)
                }
            }

            if(row + 1 <= 8 && column - 1 >= 8) {
                if(!t[row + 1][column + 1].hasPiece()) {
                    arr.add(t[row + 1][column - 1]); //moves diagonally southeast (1 down, 1 left)
                }
            }
        }

        return arr;
    }
}
