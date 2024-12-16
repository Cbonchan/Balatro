package Modelo;

import Modelo.Juego.Ronda;
import Modelo.Juego.Tienda;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.Joker.Joker;
import Modelo.SistemaCartas.Activables.Tarot.Tarot;
import Modelo.SistemaCartas.Cartas.Carta;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import Modelo.Usuario.Jugador;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ModeloController implements Initializable {

    @FXML
    public FlowPane cartas_joker;

    @FXML
    private Button boton_descartar;

    @FXML
    private Button boton_jugar;

    @FXML
    private Button boton_deseleccionar;

    @FXML
    private Button activar_tarot;

    @FXML
    private FlowPane puntajeCartas;

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
    private Label numeroDescartes;

    @FXML
    private Label numeroJugadas;

    @FXML
    private FlowPane cartas_jugada;

    @FXML
    private FlowPane cartas_jugador;

    @FXML
    private FlowPane cartas_mano;

    @FXML
    private FlowPane cartas_tarot;

    private Stage stage;
    private Scene scene;
    private Parent root;

    //TESTING
    Jugador jugador = new Jugador();
    //Tienda tienda = new Tienda();
    int puntajeASuperar = 350;
    //ESTO DEBE SER REEMPLAZADO CON LA INICIALIZACION DEL JUEGO

    //POST: Pone las condiciones del juego tal y como deben estar al momento dar play
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nro_chips.setText("0");
        nro_mult.setText("0");
        nro_ronda.setText("1");
        puntos_a_superar.setText(Integer.toString(puntajeASuperar));
        jugador.actualizarCantidadDeManosYDescartes(3,4);
        numeroDescartes.setText(Integer.toString(jugador.obtenerCantidadDescartes()));
        numeroJugadas.setText(Integer.toString(jugador.obtenerCantidadJugadas()));
        puntaje.setText("0");
        jugador.agregarCartasFaltantes();
        jugar();
    }

    @FXML
    void jugar() {
        updateLabels();
        updateCartasJugador();
        updateCartasMano();
        updateCartasJoker();
        updateCartasTarot();
        updateGameState();
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

    //post: actualiza los labels de la ronda
    private void updateLabels() {
        puntaje.setText(Integer.toString(jugador.getPuntos()));
        numeroDescartes.setText(Integer.toString(jugador.obtenerCantidadDescartes()));

        if(jugador.obtenerCantidadJugadas()<0){
            numeroJugadas.setText("0");
        }else{
            numeroJugadas.setText(Integer.toString(jugador.obtenerCantidadJugadas()));
        }

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
//post: actualiza las cartas del jugador y sus estados
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
//post: actualiza las cartas de la mano y sus puntajes
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
            resaltarCartasJugada(cartas_mano);
            updatePuntajeCartas();
        }
    }
//post: actualiza los puntajes de las cartas sobre la mano
    private void updatePuntajeCartas(){
        puntajeCartas.getChildren().clear();
        List<Carta> cartasEspeciales = jugador.obtenerMano().obtenerJugada().cartasJugadas(jugador.obtenerMano().obtenerCartas());
        for (Carta carta : jugador.obtenerMano().obtenerCartas()) {
            if(cartasEspeciales.contains(carta)){
                Label label = new Label(("+"+Integer.toString(carta.getValorNumChips())));
                puntajeCartas.getChildren().add(label);
            }
            else {
                Label label = new Label(("+0"));
                puntajeCartas.getChildren().add(label);
            }
        }
    }
//post: limpia la lista de puntajes sobre la mano
    private void reiniciarPuntajeCartas(){
        puntajeCartas.getChildren().clear();
    }
//post: actualiza las cartas en los slots de jokers
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
//post: actualiza las cartas en los slots de tarots
    private void updateCartasTarot(){
        cartas_tarot.getChildren().clear();
        for (Tarot tarot: jugador.obtenerTarots()){
            ImageView imageView = new ImageView(tarot.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(tarot);
            mouseHoverEvents(imageView);

            cartas_joker.getChildren().add(imageView);
        }
    }
//post: verifica si el juego o ronda termino de una forma u otra
    private void updateGameState(){
        if((jugador.soyMayorA(puntajeASuperar))&&(!jugador.quedanJugadas())){
            mostrarVentanaEmergente("GANASTE", "Cumpliste con el puntaje pedido");
        }
        if(jugador.soyMayorA(puntajeASuperar)){
            mostrarVentanaEmergente("GANASTE", "Cumpliste con el puntaje pedido");
        }
        if(!jugador.quedanJugadas()){
            mostrarVentanaEmergente("PERDISTE", "No pudiste superar el puntaje");
        }
    return;
    }
//post: realiza la jugada usando las cartas de la mano
    @FXML
    public void realizarJugada(){
        if(!cartas_mano.getChildren().isEmpty()){
            jugador.jugarMano();
            jugador.agregarCartasFaltantes();
            updateLabels();
            updateCartasMano();
            updateCartasJugador();
            updateGameState();
            reiniciarPuntajeCartas();
        }
    }
//post: vacia la mano del jugador y dedistribuye las cartas
    @FXML
    public void cancelarMano(){
        jugador.cancelarEleccion();
        updateCartasMano();
        updateCartasJugador();
        updateLabels();
        reiniciarPuntajeCartas();
    }
//post: descarta las cartas de la mano y agrega las cartas faltantes a las cartas del jugador
    @FXML
    public void descartarCartasMano(){
        if(!cartas_mano.getChildren().isEmpty() && jugador.quedanDescartes()){
            jugador.descartarMano();
            updateLabels();
            updateCartasMano();
            updateCartasJugador();
            reiniciarPuntajeCartas();
        }
    }
//post: aumenta el tamaño de una carta dinamicamente si pertenece a una jugada
    private void resaltarCartasJugada(FlowPane flowPane) {
        List<Carta> cartasEspeciales = jugador.obtenerMano().obtenerJugada().cartasJugadas(jugador.obtenerMano().obtenerCartas());
        for (Node node : flowPane.getChildren()) {
            if (node instanceof ImageView) {
                ImageView imageView = (ImageView) node;
                Carta carta = (Carta) imageView.getUserData(); // Obtén la carta asociada

                if (cartasEspeciales.contains(carta)) {
                    // Ajustar tamaño para cartas especiales
                    aplicarAnimacion(imageView, 1.2);
                } else {
                    // Restaurar tamaño normal para las demás cartas
                    aplicarAnimacion(imageView, 1.0);
                }
            }
        }
    }
//post: animacion de las cartas llamada por el metodo resaltarCartasJugada
    private void aplicarAnimacion(ImageView imageView, double escala) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), imageView);
        scaleTransition.setToX(escala);
        scaleTransition.setToY(escala);
        scaleTransition.play();
    }
//post: crea una ventana emergente con un boton y el texto deseado
    private void mostrarVentanaEmergente(String Mensaje, String Descripcion) {
        Stage ventanaGanaste = new Stage();
        ventanaGanaste.setTitle(Mensaje);

        // Crear un layout simple
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);

        Label mensaje = new Label(Descripcion);
        Button botonCerrar = new Button("Aceptar");
        botonCerrar.setOnAction(event -> ventanaGanaste.close());

        layout.getChildren().addAll(mensaje, botonCerrar);

        // Configurar la escena
        Scene escena = new Scene(layout, 300, 150);
        ventanaGanaste.setScene(escena);

        // Mostrar la ventana
        ventanaGanaste.show();
    }


    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Balatro.view.tienda.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}