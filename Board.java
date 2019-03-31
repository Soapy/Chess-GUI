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

    /**
     * The logic of where a unit is able to move to.
     */
    public void move(Piece piece) {
        String str = piece.getName();
        piece.move(board);
    }

    /**
     * If a unit moves onto a tile that contains an enemy unit, then enemy unit is replaced by the new unit.
     */
    public void capture() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Tile[] row : board) {
            for(Tile column : row) {
                if(column.hasPiece()) {
                    sb.append(column.getPiece().toString());
                }
                else {
                    sb.append("xxx");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
