package com.kjelland;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXplorerApplication extends Application {

    public static void main(String[] args) {
        Application.launch(args);

    }
    @Override
    public void start(final Stage primaryStage) throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(classLoader.getResource("window.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
