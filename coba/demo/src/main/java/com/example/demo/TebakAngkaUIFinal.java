package com.example.demo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

public class TebakAngkaUIFinal extends Application {

    private int targetNumber;
    private int attemptCount;
    private final int MAX = 100;

    private TextField guessField;
    private Button guessButton;
    private Label feedbackLabel;
    private Label countLabel;

    private Random random = new Random();

    @Override
    public void start(Stage stage) {
        resetGame();

        // Judul
        Label title = new Label("\uD83C\uDFAF Tebak Angka 1–100");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setTextFill(Color.DARKBLUE);

        // Feedback
        feedbackLabel = new Label("");
        feedbackLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        // Input
        guessField = new TextField();
        guessField.setPromptText("Masukkan angka di sini");
        guessField.setFont(Font.font("Arial", 14));
        guessField.setPrefWidth(180);

        // Tombol
        guessButton = new Button("🎲 Coba Tebak!");
        guessButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        guessButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        guessButton.setOnAction(e -> handleGuess());

        // Hover (opsional)
        guessButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e ->
                guessButton.setStyle("-fx-background-color: #45A049; -fx-text-fill: white;"));
        guessButton.addEventHandler(MouseEvent.MOUSE_EXITED, e ->
                guessButton.setStyle(guessButton.getText().equals("Main Lagi") ?
                        "-fx-background-color: #2196F3; -fx-text-fill: white;" :
                        "-fx-background-color: #4CAF50; -fx-text-fill: white;"));

        // Jumlah percobaan
        countLabel = new Label("Jumlah percobaan: 0");
        countLabel.setFont(Font.font("Arial", 12));
        countLabel.setTextFill(Color.GRAY);

        // Layout input
        HBox inputBox = new HBox(10, guessField, guessButton);
        inputBox.setAlignment(Pos.CENTER);

        // Root layout
        VBox root = new VBox(15, title, feedbackLabel, inputBox, countLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #EAF6FF;");

        // Scene
        Scene scene = new Scene(root, 440, 300);
        stage.setTitle("Tebak Angka Advance");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void handleGuess() {
        String input = guessField.getText();
        if (input.isEmpty()) {
            setFeedback("⚠️ Masukkan angka terlebih dahulu!", Color.ORANGE);
            return;
        }

        int guess;
        try {
            guess = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            setFeedback("⚠️ Input harus berupa angka!", Color.ORANGE);
            return;
        }

        attemptCount++;
        countLabel.setText("Jumlah percobaan: " + attemptCount);

        if (guess < targetNumber) {
            setFeedback("🔽 Terlalu kecil!", Color.ORANGE);
        } else if (guess > targetNumber) {
            setFeedback("🔼 Terlalu besar!", Color.ORANGE);
        } else {
            setFeedback("✔ Tebakan benar!", Color.GREEN);
            guessField.setDisable(true);
            guessButton.setText("Main Lagi");
            guessButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
            guessButton.setOnAction(e -> resetGame());
        }

        guessField.clear();
    }

    private void setFeedback(String text, Color color) {
        feedbackLabel.setText(text);
        feedbackLabel.setTextFill(color);
    }

    private void resetGame() {
        targetNumber = random.nextInt(MAX) + 1;
        attemptCount = 0;
        countLabel.setText("Jumlah percobaan: 0");
        setFeedback("", Color.BLACK);
        guessField.setDisable(false);
        guessField.clear();
        guessButton.setText("🎲 Coba Tebak!");
        guessButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        guessButton.setOnAction(e -> handleGuess());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
