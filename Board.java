public class Board {
    private Tile[][] board; //Maintains a game board.

    public Board(int row, int column) {
        board = new Tile[row][column];
        createTiles();
    }

    public void createTiles() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                Location loc = new Location(i, j);
                board[i][j] = new Tile(loc, loc.toString());
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