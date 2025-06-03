package com.example

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class TebakAngkaApp extends Application {
    private int targetNumber;
    private int attemptCount;

    private TextField guessField;
    private Button guessButton;
    private Label feedbackLabel;
    private Label countLabel;

    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        // Initialize game state
        resetGame();

        // UI components
        guessField = new TextField();
        guessField.setPromptText("Masukkan tebakan");
        guessField.setPrefWidth(100);

        guessButton = new Button("Coba Tebak!");
        guessButton.setOnAction(e -> handleGuess());

        feedbackLabel = new Label("Silakan mulai menebak...");
        countLabel = new Label("Percobaan: 0");

        // Layouts
        HBox inputBox = new HBox(10, guessField, guessButton);
        inputBox.setPadding(new Insets(10));

        VBox root = new VBox(10, inputBox, feedbackLabel, countLabel);
        root.setPadding(new Insets(15));

        // Scene and stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game Tebak Angka");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void handleGuess() {
        String text = guessField.getText();
        if (text == null || text.isEmpty()) {
            feedbackLabel.setText("Masukkan angka terlebih dahulu!");
            return;
        }

        try {
            int guess = Integer.parseInt(text);
            attemptCount++;
            countLabel.setText("Percobaan: " + attemptCount);

            if (guess < targetNumber) {
                feedbackLabel.setText("Terlalu kecil!");
            } else if (guess > targetNumber) {
                feedbackLabel.setText("Terlalu besar!");
            } else {
                feedbackLabel.setText("Tebakan benar! Angka: " + targetNumber);
                guessButton.setText("Main Lagi");
                guessButton.setOnAction(e -> resetGame());
            }
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Input bukan angka valid!");
        }
    }

    private void resetGame() {
        targetNumber = random.nextInt(100) + 1;
        attemptCount = 0;
        if (guessButton != null) {
            guessButton.setText("Coba Tebak!");
            guessButton.setOnAction(e -> handleGuess());
        }
        if (feedbackLabel != null) {
            feedbackLabel.setText("Silakan mulai menebak...");
        }
        if (countLabel != null) {
            countLabel.setText("Percobaan: 0");
        }
        if (guessField != null) {
            guessField.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
