import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Board extends GridPane {
    private Tile[][] board; //Maintains a game board.
    public Tile lastClickedTile = null;
    private boolean turnWhite; //determines whether or not it is the white player's turn
    private int humanPlayers;

    public Board(int humanPlayers) {
        super();
        turnWhite = true;
        this.humanPlayers = humanPlayers;

        board = new Tile[8][8];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean isWhite = ((i + j) % 2 != 0);

                Location loc = new Location(i, j);
                board[i][j] = new Tile(loc, isWhite);

                this.add(board[i][j], i, 7 - j);
                final int x = i;
                final int y = j;
                board[i][j].setOnAction( e -> onTileMouseClick(x, y) );
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

    public void setLastClickedTile(Tile tile) {
        if(lastClickedTile != null) {
            lastClickedTile.getStyleClass().removeAll("chess-current-tile");
        }

        lastClickedTile = tile;
        if(lastClickedTile != null) {
            lastClickedTile.getStyleClass().add("chess-current-tile");
        }
    }

    public Tile getLastClickedTile() {
        return lastClickedTile;
    }

    public void onTileMouseClick(int x, int y) {
        if (lastClickedTile != null && lastClickedTile.hasPiece()) {
            Movement m = new Movement(lastClickedTile.getLoc().getX(), lastClickedTile.getLoc().getY(), x, y);
            if(doMove(m)) {
                turnWhite = !turnWhite;
            }
            this.setLastClickedTile(null);
        }
        else {
            if (board[x][y].hasPiece())
            {
                //makes the most recently clicked tile the selected tile
                this.setLastClickedTile(board[x][y]);
            }
        }
    }

    private boolean doMove(Movement m) {
        boolean flag;
        if(moveIsValid(m))
        {
            Tile oldSpace = board[m.getOldX()][m.getOldY()];
            Tile newSpace = board[m.getNewX()][m.getNewY()];
            newSpace.setPiece(oldSpace.removePiece());
            flag = true;
        }
        else
        {
            flag = false;
        }
        return flag;
    }

    private Movement getRandomMove() {
        Tile tile = board[0][0];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j].hasPiece() && board[i][j].getPiece().getColor() == Color.BLACK) {
                    tile = new Tile(new Location(i, j), false);
                }
            }
        }
        ArrayList<Tile> legalMoves = tile.getPiece().getLegalMoves(this);
        return new Movement(tile.getLoc().getX(), tile.getLoc().getY(), legalMoves.get(0).getLoc().getX(),
                legalMoves.get(0).getLoc().getY());
    }

    public boolean moveIsValid(Movement p) {
        Tile oldSpace;
        Tile newSpace;
        Piece piece;
        Moveset[] moves;

        if (p == null) {
            return false;
        }

        //maybe catch a different exception? NPE is always terrible
        try {
            oldSpace = board[p.getOldX()][p.getOldY()];
        }
        catch (NullPointerException e) {
            return false;
        }

        //maybe catch a different exception? NPE is always terrible
        try {
            newSpace = board[p.getNewX()][p.getNewY()];
        }
        catch (NullPointerException e) {
            return false;
        }

        if (!oldSpace.hasPiece()) {
            return false;
        }

        piece = oldSpace.getPiece();
        moves = piece.getPieceMoves();
        boolean matchesPieceMoves = false;

        int multiMoveCount;
        int checkMoveX;
        int checkMoveY;
        boolean moveLoop = true;

        MoveLoop:
        for (Moveset m : moves) {
            multiMoveCount = 1;
            if(!checkMove(piece)) {multiMoveCount = 8;}

            boolean hasCollided = false;

            for(int c = 1; c <= multiMoveCount; c++)
            {
                if (hasCollided){break;}

                checkMoveX = m.getX() * c;
                checkMoveY = m.getY() * c;

                Tile tempSpace;

                try
                {
                    tempSpace = board[p.getOldX() + checkMoveX]
                            [p.getOldY() + checkMoveY];
                }
                catch (Exception e) { //too generic of an exception to catch??
                    break;
                }

                if(tempSpace.hasPiece())
                {
                    hasCollided = true;
                    boolean piecesSameColor = tempSpace.getPiece().getColor() == oldSpace.getPiece().getColor();
                    if (piecesSameColor){
                        break;
                    }
                }

                if(p.getGapX() == checkMoveX && p.getGapY() == checkMoveY)
                {
                    matchesPieceMoves = true;
                    piece.setHasMoved(true);
                    break MoveLoop;
                }
            }
        }
        return matchesPieceMoves;
    }

    private boolean checkMove(Piece p) {
        boolean flag;
        if(p instanceof Pawn || p instanceof King || p instanceof Knight) {
            flag = true;
        }
        else {
            flag = false;
        }
        return flag;
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