import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Color color) {
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

            Tile[][] currentBoard = b.getBoard();

            int column = currentLoc.getColumn();
            int row = currentLoc.getRow();
            int tColumn = tLoc.getColumn();
            int tRow = tLoc.getRow();

            if(Math.abs(tRow - row) == Math.abs(tColumn - column)) {
                // move northeast
                if(row < tRow && column < tColumn) {
                    for(int i = row + 1, j = (column + 1); i < tRow && j < tColumn; i++, j++) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
                // move southeast
                else if(row < tRow && column > tColumn) {
                    for(int i = row + 1, j = (column - 1); i < tRow && j > tColumn; i++, j--) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
                // move northwest
                else if(row > tRow && column < tColumn) {
                    for(int i = row - 1, j = (column + 1); i > tRow && j < tColumn; i--, j++) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
                // move southwest
                else if(row > tRow && column > tColumn) {
                    for(int i = row - 1, j = (column - 1); i > tRow && j > tColumn; i--, j--) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
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
        int boardColumns = board[0].length;
        int boardRows = board.length;

        //moves northeast
        for(int i = column + 1, j = row + 1; i < boardColumns && j < boardRows; i++, j++) {
            legalMoves.add(board[j][i]);
        }

        //moves southeast
        for(int i = column + 1, j = row - 1; i < boardColumns && j >= 0; i++, j--) {
            legalMoves.add(board[j][i]);
        }

        //moves northwest
        for(int i = column - 1, j = row + 1; i >= 0 && j < boardRows; i--, j++) {
            legalMoves.add(board[j][i]);
        }

        //moves southwest
        for(int i = column - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {
            legalMoves.add(board[j][i]);
        }

        return legalMoves;
    }
}
