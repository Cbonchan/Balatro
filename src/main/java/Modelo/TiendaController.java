package Modelo;

import Modelo.Juego.Juego;
import Modelo.Juego.Tienda;
import Modelo.Usuario.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TiendaController implements Initializable {

    @FXML
    private FlowPane carta_poker_tienda;

    @FXML
    private FlowPane jokers_jugador;

    @FXML
    private FlowPane jokers_tienda;

    @FXML
    private FlowPane tarots_jugador;

    @FXML
    private FlowPane tarots_tienda;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Juego juegoEnCurso;
    Tienda tienda;
    Jugador jugador;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Obtén la instancia única de Juego
            this.juegoEnCurso = Juego.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

        public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Balatro.view.1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
