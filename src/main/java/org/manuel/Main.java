package org.manuel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.manuel.controllers.SortController;
//import org.manuel.controllers.AnimationController;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * JavaFX App
 */
public class Main extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("mainscreen"));
//        stage.setScene(scene);
//        stage.show();
        SortController sortController = new SortController();
        sortController.setStyle("-fx-background-color: #f7f5f5");

        Scene scene = new Scene(sortController,
                SortController.WINDOW_WIDTH,
                SortController.WINDOW_HEIGHT);

        stage.setTitle("Visual Sorting Algorithms");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}

