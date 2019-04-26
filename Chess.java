/**
 * Handles GUI and player events
 * TODO: Add GUI
 */
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Chess extends Stage {

    private int turnCount;
    private boolean whitePlayerTurn;
    private Board board;
    private BorderPane pane;

    private ArrayList<Piece> capturedWhitePieces;
    private ArrayList<Piece> capturedBlackPieces;

    public Chess(int humanPlayers) {
        turnCount = 1;
        board = new Board(humanPlayers); //Chess is played on an 8 by 8 board.
        createWhitePieces();
        createBlackPieces();

        capturedWhitePieces = new ArrayList<>();
        capturedBlackPieces = new ArrayList<>();

        this.setTitle("Chess: JavaFX Edition");

        pane = new BorderPane();
        Scene scene = new Scene(pane);
        this.setScene(scene);

        //add css for colors
        scene.getStylesheets().add("chess.css");

        //adds the chess board to the borderpane
        pane.setCenter(board);

        //adds menubar to the top of the borderpane
        MenuBar menuBar = createMenuBar();
        pane.setTop(menuBar);
        this.getIcons().add(new Image("assets/pieces/rook_black.png"));
        this.show();

    }

    private void createBlackPieces() {
        for(int i = 0; i < board.getRow(); i++) {
            board.getTile(i, 6).setPiece(new Pawn(Color.BLACK));
        }

        //initialize Rooks
        board.getTile(0,7).setPiece(new Rook(Color.BLACK));
        board.getTile(7,7).setPiece(new Rook(Color.BLACK));
        //initialize knights
        board.getTile(1,7).setPiece(new Knight(Color.BLACK));
        board.getTile(6,7).setPiece(new Knight(Color.BLACK));
        //initialize bishops
        board.getTile(2,7).setPiece(new Bishop(Color.BLACK));
        board.getTile(5,7).setPiece(new Bishop(Color.BLACK));
        //initialize queen
        board.getTile(3,7).setPiece(new Queen(Color.BLACK));
        //initialize king
        board.getTile(4,7).setPiece(new King(Color.BLACK));
    }

    private void createWhitePieces() {
        for(int i = 0; i < board.getRow(); i++) {
            board.getTile(i, 1).setPiece(new Pawn(Color.WHITE));
        }

        //initialize Rooks
        board.getTile(0,0).setPiece(new Rook(Color.WHITE));
        board.getTile(7,0).setPiece(new Rook(Color.WHITE));
        //initialize knights
        board.getTile(1,0).setPiece(new Knight(Color.WHITE));
        board.getTile(6,0).setPiece(new Knight(Color.WHITE));
        //initialize bishops
        board.getTile(2,0).setPiece(new Bishop(Color.WHITE));
        board.getTile(5,0).setPiece(new Bishop(Color.WHITE));
        //initialize queen
        board.getTile(3,0).setPiece(new Queen(Color.WHITE));
        //initialize king
        board.getTile(4,0).setPiece(new King(Color.WHITE));
    }

    public String currentTurn() {
        return whitePlayerTurn ? Color.WHITE.toString() : Color.BLACK.toString();
    }

    public Tile[] parseMoves(String playerMove, Color playerTurn) {
        String move = playerMove.toLowerCase();
        Tile[] movement = new Tile[2];

        return movement;
    }

    //exits the game
    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void showInstructions() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("How to play");
        infoAlert.setHeaderText(null);

        Stage alertStage = (Stage)infoAlert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image("assets/icons/help.png"));

        infoAlert.setContentText("Capture the enemy player's pieces!\n\n" +
                        "Each player takes turns moving their pieces across the board.\n\n" +
                        "Check the opposing player's King.\n\n" +
                        "If a player's King can no longer move, they lose the game.");
        infoAlert.showAndWait();
    }

    private void showAbout() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("About this program");
        infoAlert.setHeaderText(null);

        // set window icon
        Stage alertStage = (Stage)infoAlert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image("assets/icons/help.png"));

        infoAlert.setContentText("Initial Design by Stefan Heng and Josh Sabio.\n\n" +
                "Programmed by Stefan Heng.\n\n" +
                "Chess pieces attributed to Nørresundby Skakklub");
        infoAlert.showAndWait();
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu gameMenu = new Menu("Game");
        menuBar.getMenus().add(gameMenu);

        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> exitGame());
        gameMenu.getItems().add(exitItem);


        Menu helpMenu = new Menu("Help");
        menuBar.getMenus().add(helpMenu);

        MenuItem instructionsItem = new MenuItem("How to Play");
        instructionsItem.setOnAction(e -> showInstructions());
        helpMenu.getItems().add(instructionsItem);

        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(e -> showAbout());
        helpMenu.getItems().add(aboutItem);

        return menuBar;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(board.toString());
        sb.append("\nCurrent turn: " + turnCount + "\n");
        sb.append(capturedWhitePieces);
        sb.append(capturedBlackPieces);
        return sb.toString();
    }
}
