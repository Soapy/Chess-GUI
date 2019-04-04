import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean move(Tile t, Board b) {
        boolean flag = false;
        if(t.hasPiece() && t.getPiece().getColor() == getColor()) {
            flag = false;
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
        int boardColumns = board[0].length;
        int boardRows = board.length;

        //knight can move forward
        if(row + 1 < boardRows && column - 2 >= 0) {
            legalMoves.add(board[row + 1][column - 2]);
        }

        if(row + 2 < boardRows && column - 1 >= 0) {
            legalMoves.add(board[row + 2][column - 1]);
        }

        if(row + 2 < boardRows && column + 1 < boardColumns) {
            legalMoves.add(board[row + 2][column + 1]);
        }

        if(row + 1 < boardRows && column + 2 < boardColumns) {
            legalMoves.add(board[row + 1][column + 2]);
        }

        //knight can move backward
        if(row + -1 >= 0 && column - 2 >= 0) {
            legalMoves.add(board[row + 1][column - 2]);
        }

        if(row - 2 >= 0 && column - 1 >= 0) {
            legalMoves.add(board[row + 2][column - 1]);
        }

        if(row - 2 >= 0 && column + 1 < boardColumns) {
            legalMoves.add(board[row + 2][column + 1]);
        }

        if(row - 1 >= 0 && column + 2 < boardColumns) {
            legalMoves.add(board[row + 1][column + 2]);
        }

        return legalMoves;
    }
}
