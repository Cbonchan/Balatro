package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*
        ;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Figura.*;

import Modelo.SistemaCartas.Jugadas.RoyalFlush;

public class TestRoyalFlush {

    @Test
    public void test01JugadaValidaConEscaleraRealDeCorazon() {
        // Arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Corazon(), new Rey()),
                new Poker(new Corazon(), new Reina()),
                new Poker(new Corazon(), new Jota()),
                new Poker(new Corazon(), new Diez())
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
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new Nueve()),
                new Poker(new Corazon(), new Rey()),
                new Poker(new Corazon(), new Reina()),
                new Poker(new Corazon(), new Jota()),
                new Poker(new Corazon(), new Diez())
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
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new Rey()),
                new Poker(new Trebol(), new Reina()),
                new Poker(new Diamante(), new Jota()),
                new Poker(new Corazon(), new Diez())
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
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Corazon(), new Rey()),
                new Poker(new Corazon(), new Reina()),
                new Poker(new Corazon(), new Jota())
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
        List<Poker> cartas = List.of(
                new Poker(new Pica(), new As()),
                new Poker(new Pica(), new Rey()),
                new Poker(new Pica(), new Reina()),
                new Poker(new Pica(), new Jota()),
                new Poker(new Pica(), new Diez())
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
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new Nueve()),
                new Poker(new Corazon(), new Diez()),
                new Poker(new Corazon(), new Jota()),
                new Poker(new Corazon(), new Reina()),
                new Poker(new Corazon(), new Rey())
        );

        // Act
        boolean esValida = royalFlush.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }
}