package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTac extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Example usage of tictacBoard method
        String[][] board = {
            {"X", "O", "X"},
            {"O", "X", "O"},
            {"X", "O", "X"}
        };
        Stage boardStage = tictacBoard(board);
        boardStage.show();
    }

    public Stage tictacBoard(String[][] board) {
        Stage stage = new Stage();
        stage.setTitle("Tic-Tac-Toe Board");

        // Create a GridPane for the tic-tac-toe board
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Load images for X and O
        Image xImage = new Image("file:resources/x.png"); // Path to X image
        Image oImage = new Image("file:resources/o.png"); // Path to O image

        // Populate the GridPane with images based on the board array
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                String cell = board[row][col];
                ImageView imageView = new ImageView();

                if ("X".equals(cell)) {
                    imageView.setImage(xImage);
                } else if ("O".equals(cell)) {
                    imageView.setImage(oImage);
                }

                // Set size and other properties of the ImageView
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);

                // Add the image to the GridPane
                gridPane.add(imageView, col, row);
            }
        }

        // Create a scene and set the stage
        Scene scene = new Scene(gridPane, 320, 320);
        stage.setScene(scene);

        return stage;
    }
}
