package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
  @Override
  public void start(Stage stage) {

    String javaVersion = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");

    Label label = new Label("Hello JavaFX World!");

    Button button = new Button("Change the World!");

    button.setOnAction(e -> label.setText("JavaFX " + javafxVersion + ", running on Java " + javaVersion + "."));

    VBox controls = new VBox(15.0, label, button);
    controls.setAlignment(Pos.CENTER);

    BorderPane borderPane = new BorderPane();
    BorderPane.setAlignment(controls, Pos.CENTER);
    borderPane.setCenter(controls);

    Scene scene = new Scene(borderPane, 640, 480);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}