package Modelo;

import Modelo.Juego.Juego;
import Modelo.Juego.Ronda;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.ActivableEnCarta;
import Modelo.SistemaCartas.Cartas.Carta;
import javafx.animation.ScaleTransition;
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
import javafx.scene.media.*;
import Modelo.Usuario.Jugador;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ModeloController implements Initializable {

    @FXML
    public FlowPane cartas_joker;

    @FXML
    private AnchorPane Scene_pane;

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
    private Label cartas_mazo;

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
    private FlowPane cartas_jugador;

    @FXML
    private FlowPane cartas_mano;

    @FXML
    private FlowPane cartas_tarot;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Juego juegoEnCurso;
    Jugador jugador;
    Ronda rondaDeJuego;
    int puntajeASuperar ;
    ActivableEnCarta activableEnCartaSeleccionada;
    Activable activableSeleccionada;

    //POST: Pone las condiciones del juego tal y como deben estar al momento dar play
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //elementos de la escena
        nro_chips.setText("0");
        nro_mult.setText("0");

        try {
            // Obtén la instancia única de Juego
            this.juegoEnCurso = Juego.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.rondaDeJuego = juegoEnCurso.getRondaActual();
        jugador = this.juegoEnCurso.getJugador();
        rondaDeJuego.comenzar(jugador);

        numeroDescartes.setText(Integer.toString(jugador.obtenerCantidadDescartes()));
        numeroJugadas.setText(Integer.toString(jugador.obtenerCantidadJugadas()));
        puntaje.setText("0");
        cartas_mazo.setText(Integer.toString(jugador.obtenerMazo().getCartasDisponibles()));
        jugar();
    }

    @FXML
    void jugar() {
        music();
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

    public void music(){
        // Usar getResource para obtener la ruta relativa
        String musicFile = Objects.requireNonNull(getClass().getResource("/sounds/01.MainTheme.mp3")).toExternalForm();

        // Crear el objeto Media
        Media sound = new Media(musicFile);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    //post: actualiza los labels de la ronda
    private void updateLabels() {

        nro_ronda.setText(Integer.toString(rondaDeJuego.getNro()));
        puntajeASuperar = rondaDeJuego.getPuntajeASuperar();
        puntos_a_superar.setText(Integer.toString(puntajeASuperar));

        cartas_mazo.setText(Integer.toString(jugador.obtenerMazo().getCartasDisponibles()));
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
            nro_mult.setText(Float.toString(jugador.obtenerMult()));
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
        for (Activable joker: jugador.obtenerJokers()){
            ImageView imageView = new ImageView(joker.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(joker);
            mouseHoverEvents(imageView);

            configurarTooltipActivable(imageView, joker);

            cartas_joker.getChildren().add(imageView);
        }
    }

//post: actualiza las cartas en los slots de tarots
    private void updateCartasTarot(){
        cartas_tarot.getChildren().clear();
        for (Activable tarot: jugador.obtenerTarots()){
            ImageView imageView = new ImageView(tarot.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(tarot);
            mouseHoverEvents(imageView);

            final boolean[] seleccionada = {false};

            imageView.setOnMouseClicked(event -> {
                if (!seleccionada[0]&&(activableEnCartaSeleccionada==null)) {
                    // Seleccionar: hacer la carta más grande
                    imageView.setFitWidth(110); // Nuevo ancho más grande
                    imageView.setFitHeight(170); // Nuevo alto más grande
                    activableSeleccionada = (Activable) imageView.getUserData();
                    seleccionada[0] = true; // Cambiar el estado a seleccionada
                } else {
                    // Deseleccionar: volver al tamaño original
                    imageView.setFitWidth(98); // Ancho original
                    imageView.setFitHeight(150); // Alto original
                    activableSeleccionada = null; // Ninguna carta seleccionada
                    seleccionada[0] = false; // Cambiar el estado a deseleccionada
                }
            });
            configurarTooltipActivable(imageView, tarot);
            cartas_tarot.getChildren().add(imageView);
        }
        for (ActivableEnCarta tarotEnCarta: jugador.obtenerTarotsParaCarta()){
            ImageView imageView = new ImageView(tarotEnCarta.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(tarotEnCarta);
            mouseHoverEvents(imageView);

            final boolean[] seleccionada = {false};

            imageView.setOnMouseClicked(event -> {
                if (!seleccionada[0]&&(activableSeleccionada == null)) {
                    // Seleccionar: hacer la carta más grande
                    imageView.setFitWidth(110); // Nuevo ancho más grande
                    imageView.setFitHeight(170); // Nuevo alto más grande
                    activableEnCartaSeleccionada = (ActivableEnCarta) imageView.getUserData();
                    seleccionada[0] = true; // Cambiar el estado a seleccionada
                } else {
                    // Deseleccionar: volver al tamaño original
                    imageView.setFitWidth(98); // Ancho original
                    imageView.setFitHeight(150); // Alto original
                    activableEnCartaSeleccionada = null; // Ninguna carta seleccionada
                    seleccionada[0] = false; // Cambiar el estado a deseleccionada
                }
            });
            configurarTooltipActivableEnCarta(imageView,tarotEnCarta);
            cartas_tarot.getChildren().add(imageView);
        }
    }

//post: verifica si el juego o ronda termino de una forma u otra
    private void updateGameState(){
        if(juegoEnCurso.getNroRonda()==9){
            mostrarVentanaEmergente("VICTORIA","Superaste las 8 rondas del juego, felicidades");
        }
        else if((jugador.soyMayorA(puntajeASuperar))&&(!jugador.quedanJugadas())){
            mostrarVentanaEmergente("GANASTE", "Cumpliste con el puntaje pedido");
        }
        else if(jugador.soyMayorA(puntajeASuperar)){
            mostrarVentanaEmergente("GANASTE", "Cumpliste con el puntaje pedido");
        }
        else if(!jugador.quedanJugadas()){
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
        if (Mensaje.equals("GANASTE")){
            botonCerrar.setOnAction(event -> {
                try {
                    switchToScene2();
                    ventanaGanaste.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        else{
            botonCerrar.setOnAction(event -> ventanaGanaste.close());
        }

        layout.getChildren().addAll(mensaje, botonCerrar);

        // Configurar la escena
        Scene escena = new Scene(layout, 300, 150);
        ventanaGanaste.setScene(escena);

        // Mostrar la ventana
        ventanaGanaste.show();
    }

//post: cambia la escena a la escena de la tienda
    public void switchToScene2() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Balatro.view.tienda.fxml"));
        stage = (Stage) nro_chips.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //post: Activa los tarots
    public void ActivarTarot(){
        if(activableEnCartaSeleccionada!=null){
            activableEnCartaSeleccionada.activar(jugador.obtenerMano().obtenerCartas().get(0), "Sin contexto");
            jugador.eliminarTarotParaCarta(activableEnCartaSeleccionada);
            updateCartasTarot();
            updateCartasMano();
        } else if(activableSeleccionada!=null){
            activableSeleccionada.activar(jugador.obtenerMano(), "Sin contexto");
            jugador.eliminarTarot(activableSeleccionada);
            updateCartasTarot();
            updateCartasMano();
        }

    }

    private void configurarTooltipActivable(ImageView imageView, Activable activable) {
        Tooltip tooltip = new Tooltip(activable.getDescripcion());
        tooltip.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-font-size: 14px;");

        // Asociar el Tooltip al ImageView
        Tooltip.install(imageView, tooltip);
    }

    private void configurarTooltipActivableEnCarta(ImageView imageView, ActivableEnCarta activableEnCarta){
        Tooltip tooltip = new Tooltip(activableEnCarta.getDescripcion());
        tooltip.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-font-size: 14px;");

        // Asociar el Tooltip al ImageView
        Tooltip.install(imageView, tooltip);

    }
}