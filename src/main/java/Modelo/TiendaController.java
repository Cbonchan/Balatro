package Modelo;

import Modelo.Juego.Juego;
import Modelo.Juego.Tienda;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.ActivableEnCarta;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.Usuario.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
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
    private FlowPane tarots_en_mano_tienda;

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
    Carta cartaSeleccionada;
    Activable jokerJugadorSeleccionado;
    Activable jokerSeleccionado;
    Activable tarotJugadorSeleccionado;
    Activable tarotSeleccionada;
    ActivableEnCarta tarotJugadorEnCartaSeleccionado;
    ActivableEnCarta tarotEnCartaSeleccionado;
//prepara los requisitos para la tienda
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Obtén la instancia única de Juego
            this.juegoEnCurso = Juego.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.jugador=juegoEnCurso.getJugador();
        this.tienda=juegoEnCurso.getRondaActual().getTienda();

        jugar();
    }

//inicia la tienda
    @FXML
    void jugar() {
        updateCartasJokerJugador();
        updateTodasLasTarotsDelJugador();
        updateCartasJokerTienda();
        updateTodasLasTarotsEnLaTienda();
        updateCartaDePokerEnTienda();
    }

//post: cambia la pantalla a las rondas jugables
    public void switchToScene1(ActionEvent event) throws IOException {
        juegoEnCurso.avanzarRonda();

        root = FXMLLoader.load(getClass().getResource("Balatro.view.1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//post: actualiza las cartas en los slots de jokers del jugador
    private void updateCartasJokerJugador(){
        jokers_jugador.getChildren().clear();
        for (Activable joker: jugador.obtenerJokers()){
            ImageView imageView = new ImageView(joker.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(joker);

            final boolean[] seleccionada = {false};

            imageView.setOnMouseClicked(event -> {
                if (!seleccionada[0]) {
                    // Seleccionar: hacer la carta más grande
                    imageView.setFitWidth(110); // Nuevo ancho más grande
                    imageView.setFitHeight(170); // Nuevo alto más grande
                    jokerJugadorSeleccionado = (Activable) imageView.getUserData();
                    seleccionada[0] = true; // Cambiar el estado a seleccionada
                } else {
                    // Deseleccionar: volver al tamaño original
                    imageView.setFitWidth(98); // Ancho original
                    imageView.setFitHeight(150); // Alto original
                    jokerJugadorSeleccionado = null; // Ninguna carta seleccionada
                    seleccionada[0] = false; // Cambiar el estado a deseleccionada
                }
            });
            configurarTooltipActivable(imageView,joker);
            jokers_jugador.getChildren().add(imageView);
        }
    }

//post: actualiza las cartas de joker en la tienda y sus selecciones
    private void updateCartasJokerTienda(){
        jokers_tienda.getChildren().clear();
        for (Activable joker: tienda.getJokers()){
            ImageView imageView = new ImageView(joker.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(joker);

            final boolean[] seleccionada = {false};

            imageView.setOnMouseClicked(event -> {
                if (!seleccionada[0]) {
                    // Seleccionar: hacer la carta más grande
                    imageView.setFitWidth(110); // Nuevo ancho más grande
                    imageView.setFitHeight(170); // Nuevo alto más grande
                    jokerSeleccionado = (Activable) imageView.getUserData();
                    seleccionada[0] = true; // Cambiar el estado a seleccionada
                } else {
                    // Deseleccionar: volver al tamaño original
                    imageView.setFitWidth(98); // Ancho original
                    imageView.setFitHeight(150); // Alto original
                    jokerSeleccionado = null; // Ninguna carta seleccionada
                    seleccionada[0] = false; // Cambiar el estado a deseleccionada
                }
            });
            configurarTooltipActivable(imageView,joker);
            jokers_tienda.getChildren().add(imageView);
        }
    }

//post: actualiza las cartas en los slots de tarots del jugador
    private void updateCartasTarotJugador(){
        tarots_jugador.getChildren().clear();
        for (Activable tarot: jugador.obtenerTarots()){
            ImageView imageView = new ImageView(tarot.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(tarot);

            final boolean[] seleccionada = {false};

            imageView.setOnMouseClicked(event -> {
                if (!seleccionada[0]&&(tarotEnCartaSeleccionado==null)) {
                    // Seleccionar: hacer la carta más grande
                    imageView.setFitWidth(110); // Nuevo ancho más grande
                    imageView.setFitHeight(170); // Nuevo alto más grande
                    tarotJugadorSeleccionado = (Activable) imageView.getUserData();
                    seleccionada[0] = true; // Cambiar el estado a seleccionada
                } else {
                    // Deseleccionar: volver al tamaño original
                    imageView.setFitWidth(98); // Ancho original
                    imageView.setFitHeight(150); // Alto original
                    tarotJugadorSeleccionado = null; // Ninguna carta seleccionada
                    seleccionada[0] = false; // Cambiar el estado a deseleccionada
                }
            });
            configurarTooltipActivable(imageView,tarot);
            tarots_jugador.getChildren().add(imageView);
        }

    }

    private void updateTarotEnCartaJugador(){
        for (ActivableEnCarta tarotEnCarta: jugador.obtenerTarotsParaCarta()){
            ImageView imageView = new ImageView(tarotEnCarta.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(tarotEnCarta);

            final boolean[] seleccionada = {false};

            imageView.setOnMouseClicked(event -> {
                if (!seleccionada[0]&&(tarotSeleccionada==null)) {
                    // Seleccionar: hacer la carta más grande
                    imageView.setFitWidth(110); // Nuevo ancho más grande
                    imageView.setFitHeight(170); // Nuevo alto más grande
                    tarotJugadorEnCartaSeleccionado = (ActivableEnCarta) imageView.getUserData();
                    seleccionada[0] = true; // Cambiar el estado a seleccionada
                } else {
                    // Deseleccionar: volver al tamaño original
                    imageView.setFitWidth(98); // Ancho original
                    imageView.setFitHeight(150); // Alto original
                    tarotJugadorEnCartaSeleccionado = null; // Ninguna carta seleccionada
                    seleccionada[0] = false; // Cambiar el estado a deseleccionada
                }
            });
            configurarTooltipActivableEnCarta(imageView,tarotEnCarta);
            tarots_jugador.getChildren().add(imageView);
        }
    }

//post: actualiza las cartas de tarot en la tienda y sus selecciones
    private void updateCartasTarotTienda(){
        tarots_tienda.getChildren().clear();

        for (Activable tarot: tienda.getTarot()){
            ImageView imageView = new ImageView(tarot.getImage());
            imageView.setFitWidth(98); // Ancho de la carta
            imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView.setUserData(tarot);

            final boolean[] seleccionada = {false};

            imageView.setOnMouseClicked(event -> {
                if (!seleccionada[0]&&(tarotEnCartaSeleccionado==null)) {
                    // Seleccionar: hacer la carta más grande
                    imageView.setFitWidth(110); // Nuevo ancho más grande
                    imageView.setFitHeight(170); // Nuevo alto más grande
                    tarotSeleccionada = (Activable) imageView.getUserData();
                    seleccionada[0] = true; // Cambiar el estado a seleccionada
                } else {
                    // Deseleccionar: volver al tamaño original
                    imageView.setFitWidth(98); // Ancho original
                    imageView.setFitHeight(150); // Alto original
                    tarotSeleccionada = null; // Ninguna carta seleccionada
                    seleccionada[0] = false; // Cambiar el estado a deseleccionada
                }
            });
            configurarTooltipActivable(imageView, tarot);
            tarots_tienda.getChildren().add(imageView);
        }

    }

    private void updateCartasTarotEnCartaTienda(){
        tarots_en_mano_tienda.getChildren().clear();

        for (ActivableEnCarta tarotEnCarta: tienda.getTarotsEnCarta()){
            ImageView imageView2 = new ImageView(tarotEnCarta.getImage());
            imageView2.setFitWidth(98); // Ancho de la carta
            imageView2.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
            imageView2.setUserData(tarotEnCarta);

            final boolean[] seleccionada = {false};

            imageView2.setOnMouseClicked(event -> {
                if (!seleccionada[0]&&(tarotSeleccionada==null)) {
                    // Seleccionar: hacer la carta más grande
                    imageView2.setFitWidth(110); // Nuevo ancho más grande
                    imageView2.setFitHeight(170); // Nuevo alto más grande
                    tarotEnCartaSeleccionado = (ActivableEnCarta) imageView2.getUserData();
                    seleccionada[0] = true; // Cambiar el estado a seleccionada
                } else {
                    // Deseleccionar: volver al tamaño original
                    imageView2.setFitWidth(98); // Ancho original
                    imageView2.setFitHeight(150); // Alto original
                    tarotEnCartaSeleccionado = null; // Ninguna carta seleccionada
                    seleccionada[0] = false; // Cambiar el estado a deseleccionada
                }
            });
            configurarTooltipActivableEnCarta(imageView2, tarotEnCarta);
            tarots_en_mano_tienda.getChildren().add(imageView2);
        }
    }

    private void updateTodasLasTarotsDelJugador(){
        updateCartasTarotJugador();
        updateTarotEnCartaJugador();
    }
    private void updateTodasLasTarotsEnLaTienda(){
        updateCartasTarotTienda();
        updateCartasTarotEnCartaTienda();
    }

//post: actualiza el estado de la carta de poker a la venta y su seleccion
    private void updateCartaDePokerEnTienda(){
        carta_poker_tienda.getChildren().clear();

        ImageView imageView = new ImageView(tienda.getCartaALaVenta().getImage());
        imageView.setFitWidth(100); // Ancho de la carta
        imageView.setFitHeight(150); // Alto de la carta

            // Asociar la carta al ImageView utilizando setUserData
        imageView.setUserData(tienda.getCartaALaVenta());
            //mouseHoverEvents(imageView);

        final boolean[] seleccionada = {false};

        imageView.setOnMouseClicked(event -> {
            if (!seleccionada[0]) {
                // Seleccionar: hacer la carta más grande
                imageView.setFitWidth(110); // Nuevo ancho más grande
                imageView.setFitHeight(170); // Nuevo alto más grande
                cartaSeleccionada = (Carta) imageView.getUserData();
                seleccionada[0] = true; // Cambiar el estado a seleccionada
            } else {
                // Deseleccionar: volver al tamaño original
                imageView.setFitWidth(98); // Ancho original
                imageView.setFitHeight(150); // Alto original
                cartaSeleccionada = null; // Ninguna carta seleccionada
                seleccionada[0] = false; // Cambiar el estado a deseleccionada
            }
        });

        carta_poker_tienda.getChildren().add(imageView);


    }

//post:se encargan de darle la carta comprada al jugador y sacarla de la tienda
    public void comprarJoker(){
        if(jokerSeleccionado!=null && jugador.obtenerJokers().size()<5){
            jugador.agregarJoker(jokerSeleccionado);
            tienda.getJokers().remove(jokerSeleccionado);
            jokerSeleccionado = null;
            updateCartasJokerTienda();
            updateCartasJokerJugador();
        }
    }
    public void comprarTarot(){
        if(tarotSeleccionada!=null){
            jugador.agregarTarot(tarotSeleccionada);
            tienda.getTarot().remove(tarotSeleccionada);
            tarotSeleccionada = null;
            updateTodasLasTarotsEnLaTienda();
            updateTodasLasTarotsDelJugador();
        }
        if(tarotEnCartaSeleccionado!=null){
            jugador.agregarTarotParaCarta(tarotEnCartaSeleccionado);
            tienda.getTarotsEnCarta().remove(tarotEnCartaSeleccionado);
            tarotEnCartaSeleccionado = null;
            updateTodasLasTarotsEnLaTienda();
            updateTodasLasTarotsDelJugador();
        }

    }
    public void comprarCarta(){
         jugador.obtenerMazo().agregarCarta(cartaSeleccionada);
         tienda.venderCarta();
         cartaSeleccionada = null;
         updateCartaDePokerEnTienda();
    }

//post:se encargan de eliminar de las listas del jugador las cartas seleccionadas
    public void venderJoker(){
        if(jokerJugadorSeleccionado!=null){
            jugador.obtenerJokers().remove(jokerJugadorSeleccionado);
            jokerJugadorSeleccionado = null;
            updateCartasJokerJugador();
        }
    }
    public void venderTarot(){
        if(tarotJugadorSeleccionado!=null){
            jugador.eliminarTarot(tarotJugadorSeleccionado);
            tarotJugadorSeleccionado = null;
        }
        if(tarotJugadorEnCartaSeleccionado!=null){
            jugador.eliminarTarotParaCarta(tarotJugadorEnCartaSeleccionado);
            tarotJugadorEnCartaSeleccionado = null;
        }

        updateTodasLasTarotsDelJugador();

    }

    private void configurarTooltipActivable(ImageView imageView, Activable activable){
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
