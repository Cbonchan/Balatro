package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Cartas.Palo.*;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.*;

import Modelo.SistemaCartas.Jugadas.StraightFlush;

public class TestStraightFlush {

    @Test
    public void test01JugadaValidaConEscaleraDeColor() {
        // Arrange
        StraightFlush straightFlush = new StraightFlush();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new Diez()),
                new Carta(new Corazon(), new Jota()),
                new Carta(new Corazon(), new Reina()),
                new Carta(new Corazon(), new Rey()),
                new Carta(new Corazon(), new As())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new Dos()),
                new Carta(new Corazon(), new Cinco()),
                new Carta(new Corazon(), new Siete()),
                new Carta(new Corazon(), new Nueve()),
                new Carta(new Corazon(), new Rey())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new Diez()),
                new Carta(new Pica(), new Jota()),
                new Carta(new Trebol(), new Reina()),
                new Carta(new Diamante(), new Rey()),
                new Carta(new Corazon(), new As())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new Diez()),
                new Carta(new Corazon(), new Jota()),
                new Carta(new Corazon(), new Reina()),
                new Carta(new Corazon(), new Rey())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new Diez()),
                new Carta(new Corazon(), new Jota()),
                new Carta(new Corazon(), new Reina()),
                new Carta(new Corazon(), new Rey()),
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new Dos())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new Seis()),
                new Carta(new Corazon(), new Siete()),
                new Carta(new Corazon(), new Ocho()),
                new Carta(new Corazon(), new Nueve()),
                new Carta(new Corazon(), new Diez())
        );

        // Act
        boolean esValida = straightFlush.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }
}