public class Board {
    public Tile[][] board; //Maintains a game board.

    public Board(int row, int column) {
        board = new Tile[row][column];
        createBoard();
    }

    private void createBoard() {

        for(int i = 0; i < board.length; i++) {
            char row = (char)(i + 97);
            for(int j = 0; j < board[i].length; j++) {
                StringBuilder sb = new StringBuilder(row);
                sb.append(j);
                Tile tile = new Tile(sb.toString());
                board[i][j] = tile;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Tile[] row : board) {
            for(Tile column : row) {
                if(column.hasPiece()) {
                    sb.append(column.getPiece().getName());
                }
                else {
                    sb.append("x");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
