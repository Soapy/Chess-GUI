/**
 * Movement logic for the Pawn piece
 */
import java.util.ArrayList;

public class Pawn extends Piece {

    //boolean variable to check if the this Pawn has moved
    private boolean hasMoved;

    /**
     * Pawn Constructor
     * @param color assigns a color to the Pawn piece
     */
    public Pawn(Color color) {
        super(color);
        hasMoved = false;
    }

    /**
     * Sets the Pawn piece to Moved
     */
    public void setHasMoved() {
        hasMoved = true;
    }

    /**
     * Gets the hasMoved boolean variable
     * @return hasMoved
     */
    public boolean getHasMoved() {
        return hasMoved;
    }

    /**
     * Contains the movement logic of the Pawn piece
     * @param t the tile of the this Pawn
     * @param b the game board with this Pawn
     * @return flag
     */
    @Override
    public boolean move(Tile t, Board b) {
        //boolean variable that checks if the this Pawn can move to a Tile
        boolean flag = true;

        //sets flag to false if t and current tile are the same tile
        if(getTile() == t) {
            flag = false;
        }

        //checks if t is the same color as the already existing piece
        if(t.hasPiece() && t.getPiece().getColor() == getColor()) {
            flag = false;
        }

        Location currentLoc = getTile().getLoc();
        Location tLoc = t.getLoc();

        Tile[][] currentBoard = b.getBoard();

        int column = currentLoc.getColumn();
        int row = currentLoc.getRow();
        int tColumn = tLoc.getColumn();
        int tRow = tLoc.getRow();

        if(flag) {
            // check moves if pawn is white
            if(getColor() == Color.WHITE) {
                //if first pace forward is empty
                if(tColumn == column && tRow == (row + 1) && !t.hasPiece()) {
                    flag = true;
                }

                //if first and second pace if empty
                else if(tColumn == column && tRow == (row + 2) && !t.hasPiece()) {
                    //if this pawn has not moved
                    if(!currentBoard[row + 1][column].hasPiece() && !hasMoved) {
                        flag = true;
                    }
                }

                //capture
                else if((tColumn == (column + 1) || tColumn == (column - 1)) && tRow == (row + 1)) {
                    if(t.hasPiece() && t.getPiece().getColor() == Color.BLACK) {
                        flag = true;
                    }
                }
            }

            // check moves if pawn is black
            else {
                //if first pace forward is empty
                if(tColumn == column && tRow == (column - 1) && !t.hasPiece()) {
                    flag = true;
                }

                //if first and second pace if empty
                else if(tColumn == column && tRow == (row - 2) && !t.hasPiece()) {
                    if(!currentBoard[row - 2][column].hasPiece() && !hasMoved) {
                        flag = true;
                    }
                }

                //capture
                else if((tColumn == (column + 1) || tColumn == (column - 1)) && tRow == (row - 1)) {
                    if(!t.hasPiece() && t.getPiece().getColor() == Color.WHITE) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }


    /**
     *
     * @param b the board with this Pawn
     * @return legalMoves which is an ArrayList with all the legal moves for the this Pawn
     */
    @Override
    public ArrayList<Tile> getLegalMoves(Board b) {
        //ArrayList of legal moves for this Pawn
        ArrayList<Tile> legalMoves = new ArrayList<>();

        Location myLocation = getTile().getLoc();
        Tile[][] board = b.getBoard();

        int column = myLocation.getColumn();
        int row = myLocation.getRow();
        int boardColumns = board[0].length; //8
        int boardRows = board.length; //8

        //white pawn movement logic
        if(getColor() == Color.WHITE) {
            //checks if one tile forward is within board bounds and unblocked
            if(row + 1 < boardRows && !board[row + 1][column].hasPiece()) {
                legalMoves.add(board[row + 1][column]);

                //moves to the right diagonal tile and captures the piece existing on it
                if(column + 1 < boardColumns && board[row + 1][column + 1].hasPiece()) {
                    if (board[row + 1][column + 1].getPiece().getColor() == Color.BLACK)
                    {
                        legalMoves.add(board[row + 1][column + 1]);
                    }
                }

                //moves to the left diagonal tile and captures the piece existing on it
                if(column - 1 >= 0 && board[row + 1][column - 1].hasPiece()) {
                    if (board[row + 1][column - 1].getPiece().getColor() == Color.BLACK)
                    {
                        legalMoves.add(board[row + 1][column - 1]);
                    }
                }
            }

            //checks if two tiles forward is within board bounds and unblocked
            if(row + 2 < boardRows && !hasMoved && !board[row + 1][column].hasPiece()
                    && !board[row + 2][column].hasPiece()) {
                legalMoves.add(board[row + 2][column]);
            }
        }

        //black pawn movement logic
        else {
            //checks if one tile forward is within board bounds and unblocked
            if(row - 1 < boardRows && !board[row - 1][column].hasPiece()) {
                legalMoves.add(board[row - 1][column]);

                //moves to the right diagonal tile and captures the piece existing on it
                if(column + 1 < boardColumns && !board[row - 1][column + 1].hasPiece()) {
                    if (board[row - 1][column + 1].getPiece().getColor() == Color.BLACK)
                    {
                        legalMoves.add(board[row - 1][column + 1]);
                    }
                }

                //moves to the left diagonal tile and captures the piece existing on it
                if(column - 1 >= 0 && !board[row - 1][column - 1].hasPiece()) {
                    if (board[row - 1][column - 1].getPiece().getColor() == Color.BLACK)
                    {
                        legalMoves.add(board[row - 1][column - 1]);
                    }
                }
            }

            //checks if two tiles forward is within board bounds and unblocked
            if(row - 2 >= 0 && !hasMoved && !board[row - 1][column].hasPiece()
                    && !board[row - 2][column].hasPiece()) {
                legalMoves.add(board[row - 2][column]);
            }
        }

        return legalMoves;
    }
}
