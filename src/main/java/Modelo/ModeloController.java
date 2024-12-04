/*


package Modelo;

import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.Joker.Joker;
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

    public FlowPane cartas_joker;
    @FXML
    private Button boton_descartar;

    @FXML
    private Button boton_jugar;

    @FXML
    private Button boton_deseleccionar;

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
        jugar();
    }

    @FXML
    void jugar() {
        updateLabels();
        updateCartasJugador();
        updateCartasMano();
    }

    private void mouseHoverEvents(ImageView imageView) {
        // ** Configurar efecto de hover **
        imageView.setOnMouseEntered(event -> {
            imageView.setFitWidth(imageView.getFitWidth()+20); // Aumentar tamaño al pasar el mouse
            imageView.setFitHeight(imageView.getFitHeight()+20);
        });
        imageView.setOnMouseExited(event -> {
            imageView.setFitWidth(imageView.getFitWidth()-20); // Restaurar tamaño al retirar el mouse
            imageView.setFitHeight(imageView.getFitHeight()-20);
        });
    }

    private void updateLabels() {
        puntaje.setText(Integer.toString(jugador.getPuntos()));

        if(jugador.obtenerMano().obtenerJugada()==null){
            tipo_jugada.setText("No hay jugada");
        }else{
            tipo_jugada.setText(jugador.obtenerMano().obtenerJugada().getNombre());
        }

        //REEMPLAZAR CON NUEVA IMPLEMENTACION DE PUNTAJE EN MANO
        if(jugador.obtenerMano().obtenerJugada()==null){
            nro_chips.setText("0");
            nro_mult.setText("0");
        }else {
            nro_chips.setText(Integer.toString(jugador.obtenerChips()));
            nro_mult.setText(Integer.toString(jugador.obtenerMult()));
        }
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
                updateCartasMano();
                updateCartasJugador();
                updateLabels();
            });

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
            //mouseHoverEvents(imageView);

            cartas_mano.getChildren().add(imageView);
        }
    }

    private void updateCartasJoker(){
        cartas_joker.getChildren().clear();
        for (Joker joker: jugador.obtenerJokers()){
            ImageView imageView = new ImageView(joker.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(joker);
            mouseHoverEvents(imageView);

            cartas_joker.getChildren().add(imageView);
        }
    }

   /* private void updateGameState(){
        updateLabels();
        updateCartasMano();
        updateCartasJugador();
    }*/

    @FXML
    public void realizarJugada(){
        jugador.jugarMano();
        jugador.agregarCartasFaltantes();
        updateLabels();
        updateCartasMano();
        updateCartasJugador();
    }
    @FXML
    public void cancelarMano(){
        jugador.cancelarEleccion();
        updateCartasMano();
        updateCartasJugador();
        updateLabels();
    }
    @FXML
    public void descartarCartasMano(){
        jugador.descartarMano();
        updateCartasMano();
        updateCartasJugador();
    }
}
 */


