/**
 * Chess piece Queen. Can move diagonally, vertically, and horizontally.
 * Queen has the same movement logic as Bishop and Rook combined.
 * author: Stefan Heng
 */

import javafx.scene.image.Image;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);

        img = color == Color.WHITE ? new Image("assets/pieces/queen_white.png") :
                new Image("assets/pieces/queen_black.png");
    }

    /**
     * Movement logic of Queen.
     * @param t the tile to be moved to
     * @param b the board containing this piece
     * @return true if this Queen can move to t, false if it cannot move to t
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

            else if(Math.abs(tX - x) == Math.abs(tY - y)) {
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
                    for(int i = x + 1, j = (y - 1); i < tX && j > tX; i++, j--) {
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
                else if(x > tX) {
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

    /**
     * Obtains all the legal moves of this Queen in a game of Chess.
     * @return an array of legal moves that this Queen can perform.
     */
    @Override
    public Moveset[] getLegalMoves() {
        Moveset[] m = {Moveset.NORTH, Moveset.NORTHEAST, Moveset.NORTHWEST,
                Moveset.SOUTH, Moveset.SOUTHWEST, Moveset.SOUTHEAST,
                Moveset.EAST, Moveset.WEST};
        return m;
    }
}