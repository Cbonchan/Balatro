/*


package Modelo;

import Modelo.SistemaCartas.Poker.Carta;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;

import Modelo.Usuario.Jugador;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ModeloController implements Initializable {

    @FXML
    private Button boton_descartar;

    @FXML
    private Button boton_jugar;

    @FXML
    private Label nro_chips;

    @FXML
    private Label nro_mult;

    @FXML
    private Label nro_ronda;

    @FXML
    private Label puntaje;

    @FXML
    private Label puntos_a_superar;

    @FXML
    private Label tipo_jugada;

    @FXML
    private FlowPane cartas_jugada;

    @FXML
    private FlowPane cartas_jugador;

    @FXML
    private FlowPane cartas_mano;

    @FXML
    private FlowPane cartas_tarot;

    @FXML
    void descartarMano(ActionEvent event) {

    }
//TESTING
    Jugador jugador = new Jugador();
//ESTO DEBE SER REEMPLAZADO CON LA INICIALIZACION DEL JUEGO

    //POST: Pone las condiciones del juego tal y como deben estar al momento dar play
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nro_chips.setText("0");
        nro_mult.setText("0");
        nro_ronda.setText("1");
        puntaje.setText("0");
        jugador.agregarCartasFaltantes();
    }

    @FXML
    void jugar(ActionEvent event) {
        this.jugador.jugarMano();
    }

    private void updateLabels()
    {
        puntaje.setText(Integer.toString(jugador.getPuntos()));
        tipo_jugada.setText(jugador.obtenerMano().obtenerJugada().getNombre());
    }

}
 */


