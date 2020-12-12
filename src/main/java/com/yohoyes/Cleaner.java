package com.yohoyes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 入口
 * @author yohoyes
 */
public class Cleaner extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("Main.fxml"));
        primaryStage.setTitle("FileCleaner");
        primaryStage.setScene(new Scene(root, 571, 321));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
