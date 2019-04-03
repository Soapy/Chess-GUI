import java.util.ArrayList;
import java.util.Set;

public abstract class Piece{
    private Color color;
    private String name;
    private Tile tile;

    public Piece(Color color, String name, Tile tile) {
        this.color = color;
        this.name = name;
        this.tile = tile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean move(Tile t) {
        Piece current = t.getPiece();
        boolean flag = true;

        if(current != null) {
            if(current.getColor() == color) {
                flag = false;
            }
            else {

            }
        }
        this.tile.removePiece();
        this.tile = t;
        this.setTile(t);

        return flag;
    }

    public int[] getCardinals(Tile[][] board, int row, int column) {
        //row corresponds solely to north and south directions
        int rowNorth = 0;
        int rowSouth = 7;

        //column corresponds solely to west and east directions
        int columnEast = 7;
        int columnWest = 0;

        for(int i = 0; i < row; i++) {
            if(board[i][column].hasPiece()) {
                if(board[i][column].getPiece().getColor() != color) {
                    rowNorth = i;
                }

                else {
                    rowNorth = i + 1;
                }
            }
        }

        for (int i = 7; i > row; i--) {
            if (board[i][column].hasPiece()) {
                if(board[i][column].getPiece().getColor() != color) {
                    rowSouth = i;
                }

                else {
                    rowSouth = i - 1;
                }
            }
        }

        for (int i = 0; i < column; i++) {
            if (board[row][i].hasPiece()) {
                if(board[row][i].getPiece().getColor() != color) {
                    columnWest = i;
                }
                else {
                    columnWest = i + 1;
                }
            }
        }

        for(int i = 7; i > column; i--) {
            if(board[row][i].hasPiece()) {
                if(board[row][i].getPiece().getColor() != color) {
                    columnEast = i;
                }
                else {
                    columnEast = i - 1;
                }
            }
        }

        int[] cardinalDirs = {rowNorth, rowSouth, columnWest, columnEast};

        return cardinalDirs;
    }

    public ArrayList<Tile> getDiagonals(Tile[][] board, int row, int column) {
        ArrayList<Tile> diagDirs = new ArrayList<>();

        int columnNorthWest = column - 1;
        int columnSouthWest = column - 1;
        int columnNorthEast = column + 1;
        int columnSouthEast = column + 1;

        int rowNorthWest = row - 1;
        int rowSouthWest = row + 1;
        int rowNorthEast = row - 1;
        int rowSouthEast = row + 1;

        //Determines row and column's northwest
        while(columnNorthWest >= 0 && rowNorthWest >= 0) {
            if(board[rowNorthWest][columnNorthWest].hasPiece()) {
                if(board[rowNorthWest][columnNorthWest].getPiece().getColor() == color) {
                    break;
                }

                else {
                    diagDirs.add(board[rowNorthWest][columnNorthWest]);
                    break;
                }
            }

            else {
                diagDirs.add(board[rowNorthWest][columnNorthWest]);
                rowNorthWest--;
                columnNorthWest--;
            }
        }


        //Determines row and column's northeast
        while(columnNorthEast < 8 && rowNorthEast >= 0) {
            if(board[rowNorthEast][columnNorthEast].hasPiece()) {
                if(board[rowNorthEast][columnNorthEast].getPiece().getColor() == color) {
                    break;
                }

                else {
                    diagDirs.add(board[rowNorthEast][columnNorthEast]);
                    break;
                }
            } else {
                diagDirs.add(board[rowNorthEast][columnNorthEast]);
                rowNorthEast--;
                columnNorthEast++;
            }
        }

        //Determines row and column's southwest
        while (columnSouthWest >= 0 && rowSouthWest < 8) {
            if(board[rowSouthWest][columnSouthWest].hasPiece()) {
                if (board[rowSouthWest][rowSouthWest].getPiece().getColor() == color) {
                    break;
                }

                else {
                    diagDirs.add(board[rowSouthWest][columnSouthWest]);
                    break;
                }
            }
            else {
                diagDirs.add(board[rowSouthWest][columnSouthWest]);
                rowSouthWest++;
                columnSouthWest--;
            }
        }

        //Determines row and column's southeast
        while(columnSouthEast < 8 && rowSouthEast < 8) {
            if(board[rowSouthEast][columnSouthEast].hasPiece()) {
                if(board[rowSouthEast][columnSouthEast].getPiece().getColor() == color) {
                    break;
                }

                else {
                    diagDirs.add(board[rowSouthEast][columnSouthEast]);
                    break;
                }
            }

            else {
                diagDirs.add(board[rowSouthEast][columnSouthEast]);
                rowSouthEast++;
                columnSouthEast++;
            }
        }
        return diagDirs;
    }

    /**
     *
     * @param board
     * @return All the legal moves for this piece
     */
    public abstract ArrayList<Tile> getLegalMoves(Tile[][] board);

    public String toString() {
        String str = this.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder(str.substring(0, 2));
        sb.append(color.name().charAt(0));

        return sb.toString();
    }
}
