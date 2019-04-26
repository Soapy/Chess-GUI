import javafx.scene.image.Image;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);

        //maybe use String.format() instead of ternary??
        //FIX FILE PATH
        img = color == Color.WHITE ? new Image("assets/pieces/knight_white.png") :
                new Image("assets/pieces/knight_black.png");
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

            if(getColor() == Color.WHITE) {

            }
            else {

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

        //knight can move forward
        if(x + 1 < boardRows && y - 2 >= 0) {
            legalMoves.add(board[x + 1][y - 2]);
        }

        if(x + 2 < boardRows && y - 1 >= 0) {
            legalMoves.add(board[x + 2][y - 1]);
        }

        if(x + 2 < boardRows && y + 1 < boardColumns) {
            legalMoves.add(board[x + 2][y + 1]);
        }

        if(x + 1 < boardRows && y + 2 < boardColumns) {
            legalMoves.add(board[x + 1][y + 2]);
        }

        //knight can move backward
        if(x - 1 >= 0 && y - 2 >= 0) {
            legalMoves.add(board[x + 1][y - 2]);
        }

        if(x - 2 >= 0 && y - 1 >= 0) {
            legalMoves.add(board[x + 2][y - 1]);
        }

        if(x - 2 >= 0 && y + 1 < boardColumns) {
            legalMoves.add(board[x + 2][y + 1]);
        }

        if(x - 1 >= 0 && y + 2 < boardColumns) {
            legalMoves.add(board[x + 1][y + 2]);
        }

        return legalMoves;
    }

    @Override
    public Moveset[] getPieceMoves() {
        Moveset[] m =
                {
                        Moveset.KNIGHT_LEFT_UP,
                        Moveset.KNIGHT_UP_LEFT,
                        Moveset.KNIGHT_UP_RIGHT,
                        Moveset.KNIGHT_RIGHT_UP,
                        Moveset.KNIGHT_RIGHT_DOWN,
                        Moveset.KNIGHT_DOWN_RIGHT,
                        Moveset.KNIGHT_DOWN_LEFT,
                        Moveset.KNIGHT_LEFT_DOWN
                };
        return m;
    }
}
