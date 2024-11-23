package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;


import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Jugadas.Flush;

public class TestFlush {

    @Test
    public void test01JugadaValidaConCincoCartasDelMismoPalo() {
        // Arrange
        Flush flush = new Flush();
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Diamante(), new Dos()),
                new Poker(new Diamante(), new Tres()),
                new Poker(new Diamante(), new Cuatro()),
                new Poker(new Diamante(), new Seis())
        );

        // Act
        boolean esValida = flush.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02JugadaNoValidaConCartasDeDistintoPalo() {
        // Arrange
        Flush flush = new Flush();
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Pica(), new Dos()),
                new Poker(new Corazon(), new Tres()),
                new Poker(new Trebol(), new Cuatro()),
                new Poker(new Diamante(), new Seis())
        );

        // Act
        boolean esValida = flush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test03JugadaNoValidaConMenosDeCincoCartas() {
        // Arrange
        Flush flush = new Flush();
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Diamante(), new Dos()),
                new Poker(new Diamante(), new Tres()),
                new Poker(new Diamante(), new Cuatro())
        );

        // Act
        boolean esValida = flush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

        @Test
    public void test04JugadaValidaConCincoCartasDelMismoPaloYDistintasFiguras() {
        // Arrange
        Flush flush = new Flush();
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new As()),
                new Poker(new Diamante(), new Rey()),
                new Poker(new Diamante(), new Reina()),
                new Poker(new Diamante(), new Jota()),
                new Poker(new Diamante(), new Diez())
        );

        // Act
        boolean esValida = flush.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }


    @Test
    public void test05JugadaValidaConCincoCartasDelMismoPaloPeroNoConsecutivas() {
    // Arrange
    Flush flush = new Flush();
    List<Poker> cartas = List.of(
            new Poker(new Diamante(), new As()),
            new Poker(new Diamante(), new Tres()),
            new Poker(new Diamante(), new Cinco()),
            new Poker(new Diamante(), new Siete()),
            new Poker(new Diamante(), new Nueve())
    );

    // Act
    boolean esValida = flush.esJugadaValida(cartas);

    // Assert
    assertTrue(esValida);
    }

    @Test
    public void test06JugadaNoValidaConCuatroCartasDelMismoPaloYUnaDeOtroPalo() {
        // Arrange
        Flush flush = new Flush();
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new As()),
                new Poker(new Diamante(), new Tres()),
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Diamante(), new Siete()),
                new Poker(new Pica(), new Nueve())
        );

        // Act
        boolean esValida = flush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

}
