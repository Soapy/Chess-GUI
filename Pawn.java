import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean hasMoved;

    public Pawn(Color color) {
        super(color);
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
    public boolean move(Tile t, Board b) {
        boolean flag = true;

        //sets flag to false if t and current tile are the same tile
        if(getTile() == t) {
            flag = false;
        }

        //checks if t is the same color as the already existing piece
        if(t.hasPiece() && t.getPiece().getColor() == getColor()) {
            flag = false;
        }

        // Collect the necessary information and set up variables.
        Location currentLoc = getTile().getLoc();
        Location tLoc = t.getLoc();

        Tile[][] currentBoard = b.getBoard();

        int column = currentLoc.getColumn();
        int row = currentLoc.getRow();
        int tColumn = tLoc.getColumn();
        int tRow = tLoc.getRow();

        // Check relevant moves if the pawn is white.
        if(getColor() == Color.WHITE) {
            if(tColumn == column && tRow == (row + 1) && !t.hasPiece()) {
                flag = true;
            }

            else if(tColumn == column && tRow == (row + 2) && !t.hasPiece()) {
                if(!currentBoard[column][row + 1].hasPiece() && !hasMoved) {
                    flag = true;
                }
            }

            else if((tColumn == (column + 1) || tColumn == (column - 1)) && tRow == (row + 1)) {
                if(t.hasPiece() && t.getPiece().getColor() == Color.BLACK) {
                    flag = true;
                }
            }
            flag = false;
        }

        // Check relevant moves if the pawn in black.
        else {
            if(tColumn == column && tRow == (column - 1) && !t.hasPiece()) {
                flag = true;
            }

            else if(tColumn == column && tRow == (row - 2) && !t.hasPiece()) {
                if(!currentBoard[column][row - 1].hasPiece() && !hasMoved) {
                    flag = true;
                }
            }

            else if((tColumn == (column + 1) || tColumn == (column - 1)) && tRow == (row - 1)) {
                if(!t.hasPiece() && t.getPiece().getColor() == Color.BLACK) {
                    flag = true;
                }
            }
            flag = false;
        }
        return flag;
    }


    /**
     *
     * @param b
     * @return All the legal moves for this piece
     */
    @Override
    public ArrayList<Tile> getLegalMoves(Board b) {
        ArrayList<Tile> legalMoves = new ArrayList<>();

        Location myLocation = getTile().getLoc();
        Tile[][] currentBoard = b.getBoard();

        int column = myLocation.getColumn();
        int row = myLocation.getRow();
        int boardColumns = currentBoard[0].length;
        int boardRows = currentBoard.length;

        //white pawn movement logic
        if(getColor() == Color.WHITE) {
            if(row + 1 < boardRows) {
                legalMoves.add(currentBoard[row + 1][column]);

                if(column + 1 < boardColumns) {
                    legalMoves.add(currentBoard[row + 1][column + 1]);
                }

                if(column - 1 >= 0) {
                    legalMoves.add(currentBoard[row + 1][column - 1]);
                }
            }

            if(row + 2 < boardRows && !hasMoved) {
                legalMoves.add(currentBoard[row + 2][column]);
            }
        }

        //black pawn movement logic
        else {
            if(row - 1 < boardRows) {
                legalMoves.add(currentBoard[row - 1][column]);

                if(column + 1 < boardColumns) {
                    legalMoves.add(currentBoard[row - 1][column + 1]);
                }

                if(column - 1 >= 0) {
                    legalMoves.add(currentBoard[row - 1][column - 1]);
                }
            }

            if(row - 2 >= 0 && !hasMoved) {
                legalMoves.add(currentBoard[row - 2][column]);
            }
        }

        return legalMoves;
    }
}
