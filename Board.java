public class Board {
    private Tile[][] board; //Maintains a game board.

    public Board(int row, int column) {
        board = new Tile[row][column];
        createPieces();
    }


    private void createPieces() {
        createWhitePieces();
        createBlackPieces();
    }

    private void createBlackPieces() { //FIX THIS! VERY UGLY BUT IT WORKS.
        for(int i = 0; i < board[1].length; i++) {
            Pawn pawn = new Pawn(Color.BLACK, new Tile(1, i));
            board[1][i].setPiece(pawn);
        }
        Rook rook = new Rook(Color.BLACK, new Tile(0, 0);
        board[0][0].setPiece(rook);
        board[0][7].setPiece(rook, new Tile(0, 7);
        Knight knight = new Knight(Color.BLACK, new Tile(0, 1);
        board[0][1].setPiece(knight);
        board[0][6].setPiece(knight, new Tile(0 ,6);
        Bishop bishop = new Bishop(Color.BLACK, new Tile(0, 2));
        board[0][2].setPiece(bishop);
        board[0][5].setPiece(bishop, new Tile(0, 5));
        Queen queen = new Queen(Color.BLACK, new Tile(0,3));
        board[0][3].setPiece(queen);
        King king = new King(Color.BLACK, new Tile(0,4));
        board[0][4].setPiece(king);
    }

    private void createWhitePieces() { //FIX THIS! VERY UGLY BUT IT WORKS.
        for(int i = 0; i < board[6].length; i++) {
            Pawn pawn = new Pawn(Color.WHITE, new Tile(6, i));
            board[6][i].setPiece(pawn);
        }
        Rook rook = new Rook(Color.WHITE, new Tile(7, 0));
        board[7][0].setPiece(rook);
        board[7][7].setPiece(rook, new Tile(7, 7);
        Knight knight = new Knight(Color.WHITE, new Tile(7, 1);
        board[7][1].setPiece(knight);
        board[7][6].setPiece(knight, new Tile(7, 6);
        Bishop bishop = new Bishop(Color.WHITE, new Tile(7, 2);
        board[7][2].setPiece(bishop);
        board[7][5].setPiece(bishop, new Tile(7, 5);
        Queen queen = new Queen(Color.WHITE, new Tile(7, 3);
        board[7][3].setPiece(queen);
        King king = new King(Color.WHITE, new Tile(7, 4));
        board[7][4].setPiece(king);
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
    public void move(Tile tile) {
        if(tile.hasPiece()) {
            Location loc = new Location(tile.getPiece().getLocation().getRow(), tile.getPiece().getLocation().getColumn());
            board[loc.getRow()][loc.getColumn()].setPiece(tile.getPiece());
            tile.removePiece();
        }
    }

    /**
     * If a unit moves onto a tile that contains an enemy unit, then enemy unit is replaced by the new unit.
     */
    public void capture() {

    }

    public Tile[][] getBoard() {
        return board;
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
