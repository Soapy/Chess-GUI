import javafx.scene.image.Image;
import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);

        //maybe use String.format() instead of ternary??
        //FIX FILE PATH
        img = color == Color.WHITE ? new Image("assets/pieces/bishop_white.png") :
                new Image("assets/pieces/bishop_black.png");
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

            if(Math.abs(tX - x) == Math.abs(tY - y)) {
                // move northeast
                if(x < tX && y < tY) {
                    for(int i = x + 1, j = (y + 1); i < tX && j < tY; i++, j++) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
                // move southeast
                else if(x < tX && y > tY) {
                    for(int i = x + 1, j = (y - 1); i < tX && j > tY; i++, j--) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
                // move northwest
                else if(x > tX && y < tY) {
                    for(int i = x - 1, j = (y + 1); i > tX && j < tY; i--, j++) {
                        Tile temp = currentBoard[i][j];
                        flag = temp.hasPiece();
                        if(flag) {
                            break;
                        }
                    }
                }
                // move southwest
                else if(x > tX && y > tY) {
                    for(int i = x - 1, j = (y - 1); i > tX && j > tY; i--, j--) {
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

        int x = myLocation.getX();
        int y = myLocation.getY();
        int boardColumns = board[0].length;
        int boardRows = board.length;

        //moves northeast
        for(int i = x + 1, j = y + 1; i < boardColumns && j < boardRows; i++, j++) {
            legalMoves.add(board[i][j]);
        }

        //moves southeast
        for(int i = x + 1, j = y - 1; i < boardColumns && j >= 0; i++, j--) {
            legalMoves.add(board[i][j]);
        }

        //moves northwest
        for(int i = x - 1, j = y + 1; i >= 0 && j < boardRows; i--, j++) {
            legalMoves.add(board[i][j]);
        }

        //moves southwest
        for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            legalMoves.add(board[i][j]);
        }
        return legalMoves;
    }

    public Moveset[] getPieceMoves()
    {
        Moveset[] m =
                {
                        Moveset.UP_RIGHT,
                        Moveset.DOWN_RIGHT,
                        Moveset.DOWN_LEFT,
                        Moveset.UP_LEFT
                };
        return m;
    }
}
