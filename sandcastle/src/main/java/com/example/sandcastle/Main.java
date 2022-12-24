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
    public void start(Stage stage1) throws IOException {

        stg = stage1;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
        stage1.initStyle(StageStyle.UNDECORATED);
        //stage.setTitle("Hello!");
        stage1.setScene(scene);
        stage1.show();
    }
    public static void hideWindow() throws IOException {
        stg.close();
    }

    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}