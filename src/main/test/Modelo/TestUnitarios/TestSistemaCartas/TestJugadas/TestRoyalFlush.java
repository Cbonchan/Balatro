package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*
        ;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Figura.*;

import Modelo.SistemaCartas.Jugadas.RoyalFlush;

public class TestRoyalFlush {

    @Test
    public void test01JugadaValidaConEscaleraRealDeCorazon() {
        // Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new Rey()),
                new Carta(new Corazon(), new Reina()),
                new Carta(new Corazon(), new Jota()),
                new Carta(new Corazon(), new Diez())
        );

        // Act
        boolean esValida = royalFlush.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02JugadaNoValidaConCincoCartasDelMismoPaloPeroNoEscaleraReal() {
        // Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new Nueve()),
                new Carta(new Corazon(), new Rey()),
                new Carta(new Corazon(), new Reina()),
                new Carta(new Corazon(), new Jota()),
                new Carta(new Corazon(), new Diez())
        );

        // Act
        boolean esValida = royalFlush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test03JugadaNoValidaConCincoCartasDeDiferentesPalos() {
        // Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Trebol(), new Reina()),
                new Carta(new Diamante(), new Jota()),
                new Carta(new Corazon(), new Diez())
        );

        // Act
        boolean esValida = royalFlush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test04JugadaNoValidaConMenosDeCincoCartas() {
        // Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new Rey()),
                new Carta(new Corazon(), new Reina()),
                new Carta(new Corazon(), new Jota())
        );

        // Act
        boolean esValida = royalFlush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test05JugadaValidaConEscaleraRealDePica() {
        // Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Carta> cartas = List.of(
                new Carta(new Pica(), new As()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Pica(), new Reina()),
                new Carta(new Pica(), new Jota()),
                new Carta(new Pica(), new Diez())
        );

        // Act
        boolean esValida = royalFlush.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test06JugadaNoValidaConCartasConsecutivasPeroNoEscaleraReal() {
        // Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new Nueve()),
                new Carta(new Corazon(), new Diez()),
                new Carta(new Corazon(), new Jota()),
                new Carta(new Corazon(), new Reina()),
                new Carta(new Corazon(), new Rey())
        );

        // Act
        boolean esValida = royalFlush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }
}