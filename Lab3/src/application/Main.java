package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Example usage of dualClock method
        Stage clockStage = dualClock(22, 44, 37);
        clockStage.show();
    }

    public Stage dualClock(int hour, int minute, int second) {
        Stage stage = new Stage();
        stage.setTitle("Dual Clock");

        // Create 12-hour analog clock
        StackPane analogClock12Hour = createAnalogClock12Hour(hour, minute, second);

        // Create 24-hour digital clock
        String digitalTime = String.format("%02d:%02d:%02d", hour, minute, second);
        Label digitalClockLabel = new Label(digitalTime);
        digitalClockLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: #2b8ef7;");

        // Layout for clocks
        VBox clockLayout = new VBox(20, analogClock12Hour, digitalClockLabel);
        clockLayout.setAlignment(Pos.CENTER);

        // Create scene and set the stage
        Scene scene = new Scene(clockLayout, 400, 500);
        stage.setScene(scene);

        return stage;
    }

    private StackPane createAnalogClock12Hour(int hour, int minute, int second) {
        // Convert to 12-hour format
        int hour12 = hour % 12;
        if (hour12 == 0) hour12 = 12; // Handle midnight and noon

        // Create the clock face
        Circle clockFace = new Circle(150, Color.WHITE);
        clockFace.setStroke(Color.BLACK);
        clockFace.setStrokeWidth(2);

        // Create hour numbers
        StackPane clock = new StackPane(clockFace);
        clock.setAlignment(Pos.CENTER);

        for (int i = 1; i <= 12; i++) {
            double angle = i * 30 - 90;  // 30 degrees per hour, starting at the top (90 degrees offset)
            double x = 120 * Math.cos(Math.toRadians(angle));
            double y = 120 * Math.sin(Math.toRadians(angle));

            Text number = new Text(x, y, Integer.toString(i));
            number.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            number.setFill(Color.BLACK);
            clock.getChildren().add(number);
        }

        // Create clock hands
        Line hourHand = createHand(60, (hour12 + (minute / 60.0)) * (360.0 / 12), 4);
        Line minuteHand = createHand(100, minute * 6, 3);  // 360 degrees / 60 minutes
        Line secondHand = createHand(120, second * 6, 2);  // 360 degrees / 60 seconds
        secondHand.setStroke(Color.RED);  // Different color for the second hand

        clock.getChildren().addAll(hourHand, minuteHand, secondHand);

        return clock;
    }

    private Line createHand(double length, double angle, double width) {
        // Convert angle to radians and adjust by subtracting 90 degrees to correct alignment
        double endX = length * Math.cos(Math.toRadians(angle - 90));
        double endY = length * Math.sin(Math.toRadians(angle - 90));

        Line hand = new Line(0, 0, endX, endY);
        hand.setStroke(Color.BLACK);
        hand.setStrokeWidth(width);
        return hand;
    }
}

