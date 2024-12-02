package Modelo;

import Modelo.SistemaCartas.Poker.Carta;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import Modelo.Usuario.Jugador;

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
        jugar();
    }

    @FXML
    void jugar() {
        jugador.agregarCartasFaltantes();
        updateCartasJugador();
        updateCartasMano();
    }

    private void updateLabels() {
        puntaje.setText(Integer.toString(jugador.getPuntos()));
        tipo_jugada.setText(jugador.obtenerMano().obtenerJugada().getNombre());
    }

    private void mouseHoverEvents(ImageView imageView) {
        // ** Configurar efecto de hover **
        imageView.setOnMouseEntered(event -> {
            imageView.setFitWidth(150); // Aumentar tamaño al pasar el mouse
            imageView.setFitHeight(200);
        });
        imageView.setOnMouseExited(event -> {
            imageView.setFitWidth(140); // Restaurar tamaño al retirar el mouse
            imageView.setFitHeight(190);
        });
    }

    private void updateCartasJugador(){
        cartas_jugador.getChildren().clear(); // Limpiar cualquier contenido previo

        for (Carta carta : jugador.obtenerCartas()) {
            // Crear un ImageView para la carta
            ImageView imageView = new ImageView(carta.getImage());
            imageView.setFitWidth(140); // Ancho de la carta
            imageView.setFitHeight(190); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(carta);
            mouseHoverEvents(imageView);

            // Configurar evento al hacer clic
            //Seleccionar Carta
            imageView.setOnMouseClicked(event -> {
                Carta cartaSeleccionada = (Carta) imageView.getUserData();
                jugador.seleccionarCarta(cartaSeleccionada);
                updateLabels();
                updateCartasMano();
            });


            Tooltip tooltip = new Tooltip("Carta: " + carta.getFigura().getNombre() + " de " + carta.getPalo().getNombre());
            Tooltip.install(imageView, tooltip);

            // Agregar el ImageView al FlowPane
            cartas_jugador.getChildren().add(imageView);
        }
    }

    private void updateCartasMano(){
        cartas_mano.getChildren().clear();
        for (Carta carta : jugador.obtenerMano().obtenerCartas()) {
            ImageView imageView = new ImageView(carta.getImage());
            imageView.setFitWidth(100); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(carta);
            mouseHoverEvents(imageView);

            cartas_mano.getChildren().add(imageView);
        }
    }
}

