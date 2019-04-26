import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ChessGUI extends Stage {
    Chess chess;
    //maybe GridPane instead?
    BorderPane pane;

    public ChessGUI(int humanPlayers) throws Exception {
        pane = new BorderPane();
        chess = new Chess(2);

        pane.setCenter(chess.getBoard());

        /*HBox box = new HBox();
        box.setPadding(new Insets(10, 15, 16, 17));
        box.setSpacing(30);
        box.setStyle("-fx-background-color: #41DCD0;");

        Button help = new Button("Help");
        help.setPrefSize(50, 50);

        Button play = new Button("Play");
        play.setPrefSize(300, 150);
        box.setAlignment(Pos.CENTER);

        this.setScene(new Scene(box, 1280, 720));*/
        this.setTitle("Chess");
        this.show();
    }

    public Piece[] testPieceView() {
        Piece[] pieces = new Piece[6];

        return pieces;
    }
}
