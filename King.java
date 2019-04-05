import java.util.ArrayList;

public class King extends Piece {

    public King(Color color) {
        super(color);
    }

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

        if(flag) {
            Location currentLoc = getTile().getLoc();
            Location tLoc = t.getLoc();

            int column = currentLoc.getColumn();
            int row = currentLoc.getRow();
            int tColumn = tLoc.getColumn();
            int tRow = tLoc.getRow();

            //states that king can only move one tile away from its original location
            if(Math.abs(tRow - row) < 2 && Math.abs(tColumn - column) < 2) {
                flag = true;
            }

            else {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public ArrayList<Tile> getLegalMoves(Board b) {
        ArrayList<Tile> legalMoves = new ArrayList<>();

        Location myLocation = getTile().getLoc();
        Tile[][] board = b.getBoard();

        int column = myLocation.getColumn();
        int row = myLocation.getRow();
        int boardColumns = board[0].length; //8
        int boardRows = board.length; //8

        if(column + 1 >= 0) {
            //moves east
            legalMoves.add(board[row][column + 1]);
            if(row + 1 < boardRows) {
                //moves northeast
                legalMoves.add(board[row + 1][column + 1]);
            }
            if(row - 1 >= 0) {
                //moves southeast
                legalMoves.add(board[row - 1][column + 1]);
            }
        }
        if(column - 1 >= 0) {
            //moves west
            legalMoves.add(board[row][column - 1]);
            if(row - 1 >= 0) {
                //moves southwest
                legalMoves.add(board[row - 1][column - 1]);
            }
            if(row + 1 < boardRows) {
                //moves northwest
                legalMoves.add(board[row + 1][column - 1]);
            }
        }

        if(row - 1 >= 0) {
            //moves south
            legalMoves.add(board[row - 1][column]);
        }

        if(row + 1 < boardColumns) {
            //moves north
            legalMoves.add(board[row + 1][column]);
        }

        return legalMoves;
    }
}
