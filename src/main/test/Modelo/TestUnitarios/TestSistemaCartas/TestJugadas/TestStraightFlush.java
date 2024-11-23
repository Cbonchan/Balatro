package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Figura.*;

import Modelo.SistemaCartas.Jugadas.StraightFlush;

public class TestStraightFlush {

    @Test
    public void test01JugadaValidaConEscaleraDeColor() {
        // Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new Diez()),
                new Poker(new Corazon(), new Jota()),
                new Poker(new Corazon(), new Reina()),
                new Poker(new Corazon(), new Rey()),
                new Poker(new Corazon(), new As())
        );

        // Act
        boolean esValida = straightFlush.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02JugadaNoValidaConCincoCartasDelMismoPaloPeroNoConsecutivas() {
        // Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new Dos()),
                new Poker(new Corazon(), new Cinco()),
                new Poker(new Corazon(), new Siete()),
                new Poker(new Corazon(), new Nueve()),
                new Poker(new Corazon(), new Rey())
        );

        // Act
        boolean esValida = straightFlush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test03JugadaNoValidaConCincoCartasConsecutivasDeDiferentesPalos() {
        // Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new Diez()),
                new Poker(new Pica(), new Jota()),
                new Poker(new Trebol(), new Reina()),
                new Poker(new Diamante(), new Rey()),
                new Poker(new Corazon(), new As())
        );

        // Act
        boolean esValida = straightFlush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test04JugadaNoValidaConMenosDeCincoCartas() {
        // Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new Diez()),
                new Poker(new Corazon(), new Jota()),
                new Poker(new Corazon(), new Reina()),
                new Poker(new Corazon(), new Rey())
        );

        // Act
        boolean esValida = straightFlush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test05JugadaNoValidaConMasDeCincoCartas() {
        // Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new Diez()),
                new Poker(new Corazon(), new Jota()),
                new Poker(new Corazon(), new Reina()),
                new Poker(new Corazon(), new Rey()),
                new Poker(new Corazon(), new As()),
                new Poker(new Corazon(), new Dos())
        );

        // Act
        boolean esValida = straightFlush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test06JugadaValidaConEscaleraDeColorDeCincoCartasConsecutivas() {
        // Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new Seis()),
                new Poker(new Corazon(), new Siete()),
                new Poker(new Corazon(), new Ocho()),
                new Poker(new Corazon(), new Nueve()),
                new Poker(new Corazon(), new Diez())
        );

        // Act
        boolean esValida = straightFlush.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }
}