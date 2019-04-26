import javafx.scene.image.Image;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);

        //maybe use String.format() instead of ternary??
        //FIX FILE PATH
        img = color == Color.WHITE ? new Image("assets/pieces/rook_white.png") :
                new Image("assets/pieces/rook_black.png");
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

            int x = currentLoc.getX();
            int y = currentLoc.getY();
            int tX = tLoc.getX();
            int tY = tLoc.getY();
            // move east
            if(x == tX && y < tY) {
                for(int i = y + 1; i < tY; i++) {
                    Tile temp = currentBoard[x][i];
                    flag = temp.hasPiece();
                    if(flag) {
                        break;
                    }
                }
            }
            //move west
            else if(x == tX && y > tY) {
                for(int i = y - 1; i > tY; i--) {
                    Tile temp = currentBoard[x][i];
                    flag = temp.hasPiece();
                    if(flag) {
                        break;
                    }
                }
            }
            //move north
            else if(y == tY && x < tX) {
                for(int i = x + 1; i < tX; i++) {
                    Tile temp = currentBoard[i][y];
                    flag = temp.hasPiece();
                    if(flag) {
                        break;
                    }
                }
            }
            //move south
            else if(y == tY && x > tX) {
                for(int i = x - 1; i > tX; i--) {
                    Tile temp = currentBoard[i][y];
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

        int x = myLocation.getX();
        int y = myLocation.getY();
        int boardColumns = board[0].length;
        int boardRows = board.length;

        //moves west and east
        for(int i = 0; i < boardColumns; i++) {
            if(i != x) {
                legalMoves.add(board[i][y]);
            }
        }

        //moves north and south
        for(int i = 0; i < boardRows; i++) {
            if(i != y) {
                legalMoves.add(board[x][i]);
            }
        }
        return legalMoves;
    }

    @Override
    public Moveset[] getPieceMoves() {
        Moveset[] m =
                {
                        Moveset.UP,
                        Moveset.RIGHT,
                        Moveset.DOWN,
                        Moveset.LEFT
                };
        return m;
    }
}
