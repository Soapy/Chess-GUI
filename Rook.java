import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);

        //maybe use String.format() instead of ternary??
        //FIX FILE PATH
        img = color == Color.WHITE ? new Image("file: assets/rook_white.png") :
                new Image("file: assets/rook_black.png");
        imgView = new ImageView(img);
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
            // move east
            if(row == tRow && column < tColumn) {
                for(int i = column + 1; i < tColumn; i++) {
                    Tile temp = currentBoard[row][i];
                    flag = temp.hasPiece();
                    if(flag) {
                        break;
                    }
                }
            }
            //move west
            else if(row == tRow && column > tColumn) {
                for(int i = column - 1; i > tColumn; i--) {
                    Tile temp = currentBoard[row][i];
                    flag = temp.hasPiece();
                    if(flag) {
                        break;
                    }
                }
            }
            //move north
            else if(column == tColumn && row < tRow) {
                for(int i = row + 1; i < tRow; i++) {
                    Tile temp = currentBoard[i][column];
                    flag = temp.hasPiece();
                    if(flag) {
                        break;
                    }
                }
            }
            //move south
            else if(column == tColumn && row > tRow) {
                for(int i = row - 1; i > tRow; i--) {
                    Tile temp = currentBoard[i][column];
                    flag = temp.hasPiece();
                    if(flag) {
                        break;
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

        //moves west and east
        for(int i = 0; i < boardColumns; i++) {
            if(i != column) {
                legalMoves.add(board[row][i]);
            }
        }

        //moves north and south
        for(int i = 0; i < boardRows; i++) {
            if(i != row) {
                legalMoves.add(board[i][column]);
            }
        }

        return legalMoves;
    }
}
