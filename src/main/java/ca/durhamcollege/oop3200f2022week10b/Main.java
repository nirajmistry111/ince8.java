// Name = Niraj Mistry
// Student id = 100855211

package ca.durhamcollege.oop3200f2022week10b;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Vector2-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Vector2 List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}