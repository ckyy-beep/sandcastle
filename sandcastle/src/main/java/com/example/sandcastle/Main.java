package com.example.sandcastle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    @Override
    // Hier wordt log in scherm open gemaakt
    public void start(Stage stage1) throws IOException {
        stg = stage1;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root, 520, 400);
        stage1.initStyle(StageStyle.UNDECORATED);
        //stage.setTitle("Hello!");
        stage1.setScene(scene);
        stage1.show();
    }

    public static void hideWindow() throws IOException {
        stg.close();
    }

    public static void main(String[] args) {
        launch();
    }
}