package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;


import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Jugadas.Flush;

public class TestFlush {

    @Test
    public void test01JugadaValidaConCincoCartasDelMismoPalo() {
        // Arrange
        Flush flush = new Flush();
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Diamante(), new Dos()),
                new Carta(new Diamante(), new Tres()),
                new Carta(new Diamante(), new Cuatro()),
                new Carta(new Diamante(), new Seis())
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
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Pica(), new Dos()),
                new Carta(new Corazon(), new Tres()),
                new Carta(new Trebol(), new Cuatro()),
                new Carta(new Diamante(), new Seis())
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
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Diamante(), new Dos()),
                new Carta(new Diamante(), new Tres()),
                new Carta(new Diamante(), new Cuatro())
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
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new As()),
                new Carta(new Diamante(), new Rey()),
                new Carta(new Diamante(), new Reina()),
                new Carta(new Diamante(), new Jota()),
                new Carta(new Diamante(), new Diez())
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
    List<Carta> cartas = List.of(
            new Carta(new Diamante(), new As()),
            new Carta(new Diamante(), new Tres()),
            new Carta(new Diamante(), new Cinco()),
            new Carta(new Diamante(), new Siete()),
            new Carta(new Diamante(), new Nueve())
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
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new As()),
                new Carta(new Diamante(), new Tres()),
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Diamante(), new Siete()),
                new Carta(new Pica(), new Nueve())
        );

        // Act
        boolean esValida = flush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

}
