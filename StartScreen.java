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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StartScreen extends Stage {
    private Label label;

    public StartScreen() {
        label = new Label("Chess JavaFX Edition");
        //label.setFont();

        Button versusHuman = new Button("versus Human");
        Button versusComputer = new Button("versus Computer");
        Button computerVersusComputer = new Button("Computer versus Computer");

        versusHuman.setPrefSize(150, 100);
        versusComputer.setPrefSize(150, 100);
        computerVersusComputer.setPrefSize(150, 100);

        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(50.0);

        layout.getChildren().addAll(label, versusHuman, versusComputer, computerVersusComputer);
        layout.setAlignment(Pos.CENTER);

        this.setScene(new Scene(layout, 800, 600));
        this.setTitle("Main Menu");
        this.show();

        versusHuman.setOnAction(event -> {
            try {
                new ChessGUI();
                close();
            }
            catch (Exception e) { //what exception specifically?
                e.printStackTrace();
            }
        });
    }

}
