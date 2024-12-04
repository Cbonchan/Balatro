module Modelo {
    requires javafx.controls;
    requires json.simple;
    requires com.google.gson;
    requires org.jetbrains.annotations;
    //requires javafx.fxml;
    requires java.desktop;
    requires javafx.fxml;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;

    // Archivos del trabajo
    //opens Modelo to javafx.fxml;
    //exports Modelo;
    exports Modelo.Juego;
    exports Modelo.Usuario;
    exports Modelo.SistemaCartas.Cartas.Palo;
    exports Modelo.SistemaCartas.Cartas.Figura;
    exports Modelo.SistemaCartas.Cartas;
    exports Modelo.SistemaCartas.Jugadas;
    exports Modelo.SistemaCartas.Activables.Joker;
    exports Modelo.SistemaCartas.Activables.Tarot;
    exports Modelo.SistemaPuntaje;

}