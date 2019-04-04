public class Board {
    private Tile[][] board; //Maintains a game board.

    public Board(int row, int column) {
        board = new Tile[row][column];
        createTiles();
        createPieces();
    }

    public void createTiles() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                Location loc = new Location(i, j);
                board[i][j] = new Tile(loc, loc.toString());
            }
        }
    }

    private void createPieces() {
        createWhitePieces();
        createBlackPieces();
    }

    private void createBlackPieces() {
        for(int i = 0; i < board[1].length; i++) {
            Pawn pawn = new Pawn(Color.BLACK);
            board[1][i].setPiece(pawn);
        }

        //initialize Rooks
        board[0][0].setPiece(new Rook(Color.BLACK));
        board[0][7].setPiece(new Rook(Color.BLACK));
        //initialize knights
        board[0][1].setPiece(new Knight(Color.BLACK));
        board[0][6].setPiece(new Knight(Color.BLACK));
        //initialize bishops
        board[0][2].setPiece(new Bishop(Color.BLACK));
        board[0][5].setPiece(new Bishop(Color.BLACK));
        //initialize queen
        board[0][3].setPiece(new Queen(Color.BLACK));
        //initialize king
        board[0][4].setPiece(new King(Color.BLACK));
    }

    private void createWhitePieces() {
        for(int i = 0; i < board[6].length; i++) {
            Pawn pawn = new Pawn(Color.BLACK);
            board[6][i].setPiece(pawn);
        }

        //initialize Rooks
        board[7][0].setPiece(new Rook(Color.BLACK));
        board[7][7].setPiece(new Rook(Color.BLACK));
        //initialize knights
        board[7][1].setPiece(new Knight(Color.BLACK));
        board[7][6].setPiece(new Knight(Color.BLACK));
        //initialize bishops
        board[7][2].setPiece(new Bishop(Color.BLACK));
        board[7][5].setPiece(new Bishop(Color.BLACK));
        //initialize queen
        board[7][3].setPiece(new Queen(Color.BLACK));
        //initialize king
        board[7][4].setPiece(new King(Color.BLACK));
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
