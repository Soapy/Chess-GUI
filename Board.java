/**
 * Holds an array of Tiles. The actual game of Chess is played here.
 * author: Stefan Heng
 */

import javafx.scene.layout.GridPane;

public class Board extends GridPane {
    private Tile[][] board; //Maintains a game board.
    public Tile lastClickedTile = null;
    private boolean turnWhite, //determines whether or not it is the white player's turn
                    checkmate;
    private int humanPlayers;

    /**
     * @param humanPlayers if the number of humanPlayers determines whether or not the player will face an AI player.
     */
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
                board[i][j].setOnAction(e -> onTileMouseClick(x, y));
                /*if(humanPlayers < 2) {
                    doMove(getRandomMove());
                }*/

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

    /**
     * Determines the last clicked tile.
     * @param tile the tile that was last clicked
     */
    public void setLastClickedTile(Tile tile) {
        if(lastClickedTile != null) {
            lastClickedTile.getStyleClass().removeAll("chess-current-tile");
        }

        lastClickedTile = tile;
        if(lastClickedTile != null) {
            lastClickedTile.getStyleClass().add("chess-current-tile");
        }
    }

    /**
     * Determines what will be done if the player clicks on a tile.
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     */
    public void onTileMouseClick(int x, int y) {
        if (lastClickedTile != null && lastClickedTile.hasPiece()) {
            Movement m = new Movement(lastClickedTile.getLoc().getX(), lastClickedTile.getLoc().getY(), x, y);
            if(doMove(m)) {
                turnWhite = !turnWhite;
            }
            this.setLastClickedTile(null);
        }
        else {
            if (board[x][y].hasPiece()) {
                //makes the most recently clicked tile the selected tile
                this.setLastClickedTile(board[x][y]);
            }
        }
    }

    /**
     * Moves the piece.
     * @param m the movement logic of how the piece on the tile will move
     * @return true if the piece can legally move to the new tile, false if it cannot
     */
    private boolean doMove(Movement m) {
        boolean flag;
        if(moveIsValid(m)) {
            Tile oldSpace = board[m.getOldX()][m.getOldY()];
            Tile newSpace = board[m.getNewX()][m.getNewY()];
            newSpace.setPiece(oldSpace.removePiece());
            flag = true;
        }
        else {
            flag = false;
        }
        return flag;
    }

    /**
     * Gets a random move of a random piece.
     * @return a random move of a random piece on the board in Chess
     */
    private Movement getRandomMove() {
        Tile tile = board[0][0];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j].hasPiece() && board[i][j].getPiece().getColor() == Color.BLACK) {
                    tile = new Tile(new Location(i, j), false);
                }
            }
        }
        Moveset[] legalMoves = tile.getPiece().getLegalMoves();
        return new Movement(tile.getLoc().getX(), tile.getLoc().getY(),
                            legalMoves[0].getX(), legalMoves[0].getY());
    }

    /**
     * @param p the movement logic of the piece
     * @return true if this move is valid, false if it is an illegal move
     */
    public boolean moveIsValid(Movement p) {
        Tile oldTile;
        Piece piece;
        Moveset[] moves;

        if (p == null) {
            return false;
        }

        oldTile = board[p.getOldX()][p.getOldY()];

        if(!oldTile.hasPiece()) {
            return false;
        }

        piece = oldTile.getPiece();
        moves = piece.getLegalMoves();
        boolean matchesPieceMoves = false;

        int multiMoveCount, checkMoveX, checkMoveY;

        //uses label in order to break out of both the inner and outer loop
        MoveLoop:
        for (Moveset m : moves) {
            multiMoveCount = 1;
            if(!checkMove(piece)) {
                multiMoveCount = 8;
            }

            boolean hasCollided = false;

            for(int c = 1; c <= multiMoveCount; c++) {
                if (hasCollided){
                    break;
                }

                checkMoveX = m.getX() * c;
                checkMoveY = m.getY() * c;

                Tile tempSpace;
                tempSpace = board[p.getOldX() + checkMoveX][p.getOldY() + checkMoveY];

                if(tempSpace.hasPiece()) {
                    hasCollided = true;
                    boolean piecesSameColor = tempSpace.getPiece().getColor() == oldTile.getPiece().getColor();
                    if(piecesSameColor){
                        break;
                    }
                }

                if(p.getDiffX() == checkMoveX && p.getDiffY() == checkMoveY) {
                    matchesPieceMoves = true;
                    piece.setHasMoved(true);
                    break MoveLoop; //breaks out of inner and outer loops
                }
            }
        }
        return matchesPieceMoves;
    }

    /**
     * Checks to see if p can move a certain way.
     * @param p the Piece that is to be moved
     * @return true if p can move this way, false if it cannot
     */
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

    /**
     * Prints a string representation of a board.
     * @return a string of this current board
     */
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