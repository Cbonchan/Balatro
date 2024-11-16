module edu.fiuba.algo3 {
    requires javafx.controls;
    requires json.simple;
    requires org.jetbrains.annotations;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;

    // Arhivos del trabajo
    exports  Modelo.Juego;
    exports Modelo.Jugador;
    exports Modelo.SistemaCartas.Poker.Palo;
    exports Modelo.SistemaCartas.Poker.Figura;
    exports Modelo.SistemaCartas.Poker;
    exports Modelo.SistemaCartas.Jugadas;
    exports Modelo.SistemaCartas.Tarot;
    exports Modelo.SistemaPuntaje;
}