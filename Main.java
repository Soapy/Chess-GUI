
/**
 * Creates an instance of StartScreen.
 * author: Stefan Heng
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        new StartScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
LOOKBACK - STEFAN HENG:

    Working with another person proved to be stressful. Due to our differing schedules and the refusal to work with me,
my partner Josh Sabio quit before we even began coding. As such, Josh Sabio did not add anything code-wise, and all the
code was implemented by me. Throughout the project, I learned how vital it was to read the
documentation for JavaFX through the docs on the official Oracle website. As me exposure to JavaFX was very minimal, I
would say that the majority of my time was spent learning how event handling worked, and experimenting with various
components that could placed within a layout such as a GridPane. Although anonymous inner methods or classes could have
been used to provide ease of use on this application, lambda expressions proved to be more useful. What could be done
in possibly 10 lines could easily be done in half of that with more readability. I realize my shortcomings on lambda
expressions despite having used it in Lab 1. As such, I will most likely learn more of the features present in Java 8
including lambda expressions and streams. Creating the Tile class was no easy feat; I had to learn how to overlay
an image over a button. Additionally, to add more flair to the game I used minimal CSS in order to provide a more
user-friendly GUI. The project is done but the AI could use more work as it moves very lazily.

    An application of OOP principles was easily-applicable in this project. For example, all 6 chess pieces
extended the abstract class Piece. This is a representation of the simple concept of inheritance in OOP.
Additionally, the class Board held an composition of Tiles as it had a "has-a" relationship with it.

    What I learned most in CS360 and throughout this project proved that this Golden Rule is always true:
"Read the Fabulous Manual, or Documentation." Without this useful piece of philosophy, I would not have been able to
learn how to implement a GUI-based version of Chess.

	Finally, I pledge that this project represents 90% of my own work.
	
    Please read README.md in order to see how to compile and run the application.
 */