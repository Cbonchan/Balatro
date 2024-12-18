module Modelo {
    requires javafx.controls;
    requires javafx.media;
    requires json.simple;
    requires com.google.gson;
    requires org.jetbrains.annotations;
    requires javafx.fxml;
    requires java.desktop;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;

    // Archivos del trabajo
    opens Modelo to javafx.fxml;
    exports Modelo;

    exports Modelo.Juego;

    exports Modelo.SistemaCartas.Activables.Joker;
    exports  Modelo.SistemaCartas.Activables.SistemaDeEfecto;
    exports Modelo.SistemaCartas.Activables.Tarot;

    exports Modelo.SistemaCartas.Cartas;
    exports Modelo.SistemaCartas.Cartas.Palo;
    exports Modelo.SistemaCartas.Cartas.Figura;
    exports Modelo.SistemaCartas.Activables;
    exports Modelo.SistemaCartas.Jugadas;

    exports Modelo.SistemaPuntaje;

    exports Modelo.Usuario;
}