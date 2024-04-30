import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class GuessTheNumber extends Application {
    private int secretNumber;
    private int attempts;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Guess the Number Game");

        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;
        attempts = 0;

        Label promptLabel = new Label("Guess the number (between 1 and 100):");
        TextField guessField = new TextField();
        Button guessButton = new Button("Guess");

        Label infoLabel = new Label();

        guessButton.setOnAction(e -> {
            String guessText = guessField.getText();
            if (guessText.matches("\\d+")) {
                int guess = Integer.parseInt(guessText);
                attempts++;
                if (guess == secretNumber) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Congratulations!");
                    alert.setHeaderText(null);
                    alert.setContentText(String.format("Correct! You guessed the number in %d attempts.", attempts));
                    alert.showAndWait();
                    primaryStage.close();
                } else {
                    String hint = guess > secretNumber ? "Too high" : "Too low";
                    infoLabel.setText(String.format("Attempt %d: %s. Try again.", attempts, hint));
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid number.");
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(promptLabel, guessField, guessButton, infoLabel);
        layout.setAlignment(Pos.CENTER);

        
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
