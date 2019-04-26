import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StartScreen extends Stage {

    public StartScreen() {

        Text text = new Text("Chess");
        text.setStyle("-fx-font-weight: bold");
        text.setFont(Font.font("Verdana", 70));
        text.setFill(Color.YELLOWGREEN);

        Button versusHuman = new Button("versus Human");
        Button versusComputer = new Button("versus CPU");
        Button computerVersusComputer = new Button("CPU versus CPU");

        versusHuman.setPrefSize(120, 90);
        versusComputer.setPrefSize(120, 90);
        computerVersusComputer.setPrefSize(120, 90);

        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(50.0);

        //Tile tile = new Tile(new Location(0, 0), false);
        layout.getChildren().addAll(text, versusHuman, versusComputer, computerVersusComputer);
        layout.setAlignment(Pos.CENTER);

        this.getIcons().add(new Image("assets/pieces/pawn_black.png"));

        Scene scene = new Scene(layout, 1024,640);
        scene.getStylesheets().add("startscreen.css");

        this.setScene(scene);

        this.setTitle("Main Menu");
        this.show();

        versusHuman.setOnAction(event -> {
            try {
                new Chess(2);
                close();
            }
            catch (Exception e) { //what exception specifically?
                e.printStackTrace();
            }
        });

        versusComputer.setOnAction(event -> {
            try {
                new Chess(1);
                close();
            }
            catch (Exception e) { //what exception specifically?
                e.printStackTrace();
            }
        });

        computerVersusComputer.setOnAction(event -> {
            try {
                new Chess(0);
                close();
            }
            catch (Exception e) { //what exception specifically?
                e.printStackTrace();
            }
        });
    }

}
