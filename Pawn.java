/**
 * Movement logic for the Pawn piece
 */
import javafx.scene.image.Image;
import java.util.ArrayList;

public class Pawn extends Piece {

    //boolean variable to check if the this Pawn has moved
    /**
     * Pawn Constructor
     * @param color assigns a color to the Pawn piece
     */
    public Pawn(Color color) {
        super(color);

        //maybe use String.format() instead of ternary??
        //FIX FILE PATH
        img = color == Color.WHITE ? new Image("assets/pieces/pawn_white.png") :
                new Image("assets/pieces/pawn_black.png");
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

        int x = currentLoc.getX();
        int y = currentLoc.getY();
        int tX = tLoc.getX();
        int tY = tLoc.getY();

        if(flag) {
            // check moves if pawn is white
            if(getColor() == Color.WHITE) {
                //if first pace forward is empty
                if(tX == x && tY == (y + 1) && !t.hasPiece()) {
                    flag = true;
                }

                //if first and second space if empty
                else if(tX == x && tY == (y + 2) && !t.hasPiece()) {
                    //if this pawn has not moved
                    if(!currentBoard[x][y + 1].hasPiece() && !hasMoved) {
                        flag = true;
                    }
                }

                //captures
                else if((tX == (x + 1) || tX == (x - 1)) && tY == (y + 1)) {
                    if(t.hasPiece() && t.getPiece().getColor() == Color.BLACK) {
                        flag = true;
                    }
                }
            }

            // check moves if pawn is black
            else {
                //if first space forward is empty
                if(tX == x && tY == (y - 1) && !t.hasPiece()) {
                    flag = true;
                }

                //if first and second space if empty
                else if(tX == x && tY == (y - 2) && !t.hasPiece()) {
                    if(!currentBoard[x][y - 1].hasPiece() && !hasMoved) {
                        flag = true;
                    }
                }

                //capture
                else if((tX == (x + 1) || tX == (x - 1)) && tY == (y - 1)) {
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

        int x = myLocation.getX();
        int y = myLocation.getY();
        int boardColumns = board[0].length;
        int boardRows = board.length;

        //white pawn movement logic
        if(getColor() == Color.WHITE) {
            //checks if one tile forward is within board bounds and unblocked
            if(y + 1 < boardRows && !board[x][y + 1].hasPiece()) {
                legalMoves.add(board[x][y + 1]);

                //moves to the right diagonal tile and captures the piece existing on it
                if(x + 1 < boardColumns && board[x + 1][y + 1].hasPiece()) {
                    if(board[x + 1][y + 1].getPiece().getColor() == Color.BLACK)
                    {
                        legalMoves.add(board[x + 1][y + 1]);
                    }
                }

                //moves to the left diagonal tile and captures the piece existing on it
                if(x - 1 >= 0 && board[x - 1][y + 1].hasPiece()) {
                    if(board[x - 1][y + 1].getPiece().getColor() == Color.BLACK)
                    {
                        legalMoves.add(board[x - 1][y + 1]);
                    }
                }
            }

            //checks if two tiles forward is within board bounds and unblocked
            if(y + 2 < boardRows && !hasMoved && !board[x][y + 1].hasPiece()
                    && !board[x][y + 2].hasPiece()) {
                legalMoves.add(board[x][y + 2]);
            }
        }

        //black pawn movement logic
        else {
            //checks if one tile forward is within board bounds and unblocked
            if(y - 1 < boardRows && !board[x][y - 1].hasPiece()) {
                legalMoves.add(board[x][y - 1]);

                //moves to the right diagonal tile and captures the piece existing on it
                if(x + 1 < boardColumns && !board[x - 1][y + 1].hasPiece()) {
                    if (board[x + 1][y - 1].getPiece().getColor() == Color.BLACK)
                    {
                        legalMoves.add(board[x + 1][y - 1]);
                    }
                }

                //moves to the left diagonal tile and captures the piece existing on it
                if(x - 1 >= 0 && !board[x - 1][y - 1].hasPiece()) {
                    if (board[x - 1][y - 1].getPiece().getColor() == Color.BLACK)
                    {
                        legalMoves.add(board[x - 1][y - 1]);
                    }
                }
            }

            //checks if two tiles forward is within board bounds and unblocked
            if(y - 2 >= 0 && !hasMoved && !board[x][y - 2].hasPiece()
                    && !board[x][y - 2].hasPiece()) {
                legalMoves.add(board[x][y - 2]);
            }
        }
        return legalMoves;
    }

    public Moveset[] getPieceMoves()
    {
        /*
         * Pawn movement is HIGHLY conditional, so this branches.
         * The list ensures correct direction and two-space movement.
         * All the board-dependent things (like diagonal iff capturing) are ChessBoard's job.
         */
        boolean isWhite = this.getColor() == Color.WHITE;

        //braces ensure toArray() works later, see ArrayList docs for why
        Moveset[] moves = {};

        //since pawns will never be white AND black, only returns moves of correct direction
        if(isWhite)
        {
            ArrayList<Moveset> whiteMoves = new ArrayList<>();

            //standard straight, can't capture using this
            whiteMoves.add(Moveset.UP);

            //diagonals, can and must capture using this
            whiteMoves.add(Moveset.UP_RIGHT);
            whiteMoves.add(Moveset.UP_LEFT);

            //if hasn't moved, UP is valid board move, can't capture using this
            if(!hasMoved) {whiteMoves.add(Moveset.DOUBLE_UP);}

            moves = whiteMoves.toArray(moves);
        }
        else
        {
            ArrayList<Moveset> blackMoves = new ArrayList<>();

            //standard straight, can't capture
            blackMoves.add(Moveset.DOWN);

            //diagonals, can and must capture using this
            blackMoves.add(Moveset.DOWN_RIGHT);
            blackMoves.add(Moveset.DOWN_LEFT);

            //if hasn't moved, DOWN is valid board move, can't capture using this
            if(!hasMoved) {blackMoves.add(Moveset.DOUBLE_DOWN);}

            moves = blackMoves.toArray(moves);
        }

        return moves;
    }
}
