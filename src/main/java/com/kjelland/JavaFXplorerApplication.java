package com.kjelland;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class JavaFXplorerApplication extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        FXMLLoader loader = new FXMLLoader();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        loader.setLocation(classLoader.getResource("window.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
