import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Board extends GridPane {
    private Tile[][] board; //Maintains a game board.

    public Board(int row, int column) {
        board = new Tile[row][column];
        createTiles();
    }

    public void createTiles() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                Location loc = new Location(i, j);
                board[i][j] = new Tile(loc);
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public Tile getTile(int row, int column) {
        return board[row][column];
    }

    public int getRow() {
        return board.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int rowCode = 0;
        char colCode = 'a';

        sb.append(" ");
        for(int i = 0; i < board.length; i++) {
            sb.append(" " + colCode + " ");
            colCode++;
        }
        sb.append("\n");

        for(Tile[] row : board) {
            sb.append(rowCode + " ");
            for(Tile column : row) {
                if(column.hasPiece()) {
                    sb.append(column.getPiece().toString());
                }
                else {
                    sb.append("xx");
                }
                sb.append(" ");
            }
            sb.append("\n");
            rowCode++;
        }
        return sb.toString();
    }
}