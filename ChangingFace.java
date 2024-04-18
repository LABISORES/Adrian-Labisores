import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;

public class ChangingFace extends Application {
    @Override
    public void start(Stage stage) {
        // create and configure the main circle for the face
        Circle face = new Circle(125, 125, 80);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.RED);
        // create and configure the circle for the right eye
        Circle rightEye = new Circle(86, 100, 10);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLUE);
        // create and configure the circle for the left eye
        Circle leftEye = new Circle(162, 100, 10);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLUE);
        // create and configure a smiling mouth (this is how it will start)
        Arc mouth = new Arc(125, 150, 45, 35, 0, -180);
        mouth.setFill(Color.YELLOW);
        mouth.setStroke(Color.BLUE);
        mouth.setType(ArcType.OPEN);
        // create and configure the text
        Text caption = new Text(68, 240, "Changing Face");
        caption.setFill(Color.BLUE);
        caption.setFont(Font.font("Verdana", 15));
        // create a group that holds all the features
        Group group = new Group(face, rightEye, leftEye, mouth, caption);
        // create a button that will make the face smile
        Button smileButton = createButton("Smile");
        // create a button that will make the face frown
        Button frownButton = createButton("Frown");
        // create a button that will make the face wow
        Button wowButton = createButton("Wow");
        // create a color picker button
        ColorPicker colorPicker = new ColorPicker(Color.YELLOW);
        colorPicker.setStyle("-fx-color-label-visible: false;"); // hide color label
        // create and configure a horizontal container to hold the buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        // add the buttons to the horizontal container
        buttonBox.getChildren().addAll(wowButton, smileButton, frownButton, colorPicker);
        // create and configure a vertical container to hold the button box and the face group
        VBox root = new VBox(10);
        root.setBackground(Background.EMPTY);
        root.setAlignment(Pos.CENTER);
        // add the button box and the face group to the vertical container
        root.getChildren().addAll(buttonBox, group);
        // create and configure a new scene
        Scene scene = new Scene(root, 250, 275, Color.YELLOW);
        // supply the code that is executed when the smile button is pressed
        smileButton.setOnAction(e -> mouth.setLength(-180));
        // supply the code that is executed when the frown button is pressed
        frownButton.setOnAction(e -> mouth.setLength(180));
        // supply the code that is executed when the wow button is pressed
        wowButton.setOnAction(e -> mouth.setLength(360));
        // supply the code that is executed when the color picker value changes
        colorPicker.setOnAction(e -> face.setFill(colorPicker.getValue()));
        // add the scene to the stage, then set the title
        stage.setScene(scene);
        stage.setTitle("Changing Face by Adrian Labisores");
        // show the stage
        stage.show();
    }

    // Method to create styled buttons
    private Button createButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: linear-gradient(#61a2b1, #2A5058); " +
                        "-fx-background-radius: 30; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 12pt;");
        DropShadow shadow = new DropShadow();
        // Adding the shadow when hovered
        button.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, 
                e -> button.setEffect(shadow));
        // Removing the shadow when not hovered
        button.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_EXITED, 
                e -> button.setEffect(null));
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
