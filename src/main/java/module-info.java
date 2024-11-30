module edu.fiuba.algo3 {
    requires javafx.controls;
    requires json.simple;
    requires com.google.gson;
    requires org.jetbrains.annotations;
    requires javafx.fxml;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;

    // Arhivos del trabajo
    opens Modelo to javafx.fxml;
    exports Modelo;
    exports Modelo.Juego;
    exports Modelo.Usuario;
    exports Modelo.SistemaCartas.Poker.Palo;
    exports Modelo.SistemaCartas.Poker.Figura;
    exports Modelo.SistemaCartas.Poker;
    exports Modelo.SistemaCartas.Jugadas;
    exports Modelo.SistemaCartas.Activables.Tarot;
    exports Modelo.SistemaPuntaje;
}