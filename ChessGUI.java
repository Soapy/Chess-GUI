import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ChessGUI extends Stage {
    //maybe GridPane instead?
    BorderPane border;

    public ChessGUI() throws Exception {

        FileInputStream input = new FileInputStream("assets/pieces/bishop_black.png");

        Image img = new Image(input, 80, 80, false, false);
        ImageView imgView = new ImageView(img);

        Label label = new Label("Main Window", imgView);

        HBox box = new HBox();
        box.setPadding(new Insets(10, 15, 16, 17));
        box.setSpacing(30);
        box.setStyle("-fx-background-color: #41DCD0;");

        Button help = new Button("Help");
        help.setPrefSize(50, 50);

        Button play = new Button("Play");
        play.setPrefSize(300, 150);
        box.getChildren().addAll(label, help, play);
        box.setAlignment(Pos.CENTER);

        this.setScene(new Scene(box, 1280, 720));
        this.setTitle("Chess");
        this.show();
    }

    public Piece[] testPieceView() {
        Piece[] pieces = new Piece[6];

        return pieces;
    }
}
