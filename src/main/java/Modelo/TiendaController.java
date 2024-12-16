package Modelo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TiendaController {

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

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Balatro.view.1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
