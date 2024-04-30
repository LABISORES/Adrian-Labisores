import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField num1Field;
    private TextField num2Field;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        num1Field = new TextField();
        num1Field.setPromptText("Enter first number");

        num2Field = new TextField();
        num2Field.setPromptText("Enter second number");

        resultLabel = new Label();

        Button addButton = new Button("Addition (+)");
        addButton.setOnAction(e -> calculate('+'));
        Button subtractButton = new Button("Subtraction (-)");
        subtractButton.setOnAction(e -> calculate('-'));
        Button multiplyButton = new Button("Multiplication (*)");
        multiplyButton.setOnAction(e -> calculate('*'));
        Button divideButton = new Button("Division (/)");
        divideButton.setOnAction(e -> calculate('/'));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        gridPane.add(num1Field, 0, 0, 2, 1);
        gridPane.add(num2Field, 0, 1, 2, 1);
        gridPane.add(addButton, 0, 2);
        gridPane.add(subtractButton, 1, 2);
        gridPane.add(multiplyButton, 0, 3);
        gridPane.add(divideButton, 1, 3);
        gridPane.add(resultLabel, 0, 4, 2, 1);

        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Basic Arithmetic Calculator");
        primaryStage.show();
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        throw new ArithmeticException("Error: Division by zero");
                    break;
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Invalid input");
        } catch (ArithmeticException e) {
            resultLabel.setText(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
