package org.example.demo2_fx_docker;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TemperatureConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels
        Label celsiusLabel = new Label("Celsius:");
        Label fahrenheitLabel = new Label("Fahrenheit:");

        // TextFields
        TextField celsiusInput = new TextField();
        TextField fahrenheitOutput = new TextField();
        fahrenheitOutput.setEditable(false); // Output only

        // Button
        Button convertButton = new Button("Convert");

        // Conversion logic
        convertButton.setOnAction(e -> {
            try {
                double celsius = Double.parseDouble(celsiusInput.getText());
                double fahrenheit = TemperatureUtil.celsiusToFahrenheit(celsius);
                fahrenheitOutput.setText(String.format("%.2f", fahrenheit));
            } catch (NumberFormatException ex) {
                fahrenheitOutput.setText("Invalid input");
            }
        });

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(celsiusLabel, 0, 0);
        grid.add(celsiusInput, 1, 0);
        grid.add(convertButton, 1, 1);
        grid.add(fahrenheitLabel, 0, 2);
        grid.add(fahrenheitOutput, 1, 2);

        // Scene
        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setTitle("Celsius to Fahrenheit Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
