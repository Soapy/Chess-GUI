/**
 * The initial Stage displayed to the player when first launching the game.
 * author: Stefan Heng
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartScreen extends Stage {

	/** 
	* Sets up the start screen and allows the player to choose whether or not
	* they would like to face a human or computer player. Creates mew stage afterwards
	* that holds the actual Chess game itself.
	/**
    public StartScreen() {
        Text text = new Text("Chess");
        text.setStyle("-fx-font-weight: bold");
        text.setFont(Font.font("Verdana", 70));
        text.setFill(Color.YELLOWGREEN);

        Button versusHuman = new Button("versus Human");
        Button versusComputer = new Button("versus CPU");

        versusHuman.setPrefSize(120, 90);
        versusComputer.setPrefSize(120, 90);

        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(50.0);

        layout.getChildren().addAll(text, versusHuman, versusComputer);
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
            catch (Exception e) {
                e.printStackTrace();
            }
        });

        versusComputer.setOnAction(event -> {
            try {
                new Chess(1);
                close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
