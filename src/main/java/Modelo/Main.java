package Modelo;
import Modelo.Juego.Juego;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Balatro.view.tienda.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("BALATROGOTY2024INGODWETRUST");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}