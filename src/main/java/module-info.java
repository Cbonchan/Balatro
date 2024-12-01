module edu.fiuba.algo3 {
    requires javafx.controls;
    requires json.simple;
    requires com.google.gson;
    requires org.jetbrains.annotations;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;

    // Arhivos del trabajo
    exports  Modelo.Juego;

    exports Modelo.SistemaCartas.Activables;
    exports  Modelo.SistemaCartas.Activables.Joker;
    exports  Modelo.SistemaCartas.Activables.SistemaDeEfecto;
    exports Modelo.SistemaCartas.Activables.Tarot;

    exports Modelo.SistemaCartas.Jugadas;

    exports Modelo.SistemaCartas.Poker.Figura;
    exports Modelo.SistemaCartas.Poker.Palo;
    exports Modelo.SistemaCartas.Poker;

    exports Modelo.SistemaPuntaje;

    exports  Modelo.Usuario;
}