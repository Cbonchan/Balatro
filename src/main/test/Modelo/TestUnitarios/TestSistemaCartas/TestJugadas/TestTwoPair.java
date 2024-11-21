package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;

import Modelo.SistemaCartas.Jugadas.TwoPair;

public class TestTwoPair {

    @Test
    public void test01JugadaValidaConDosPares() {
        // Arrange
        TwoPair twoPair = new TwoPair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new As()),
                new Poker(new Trebol(), new Rey()),
                new Poker(new Diamante(), new Rey())
        );

        // Act
        boolean esValida = twoPair.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02JugadaNoValidaConUnPar() {
        // Arrange
        TwoPair twoPair = new TwoPair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new As()),
                new Poker(new Trebol(), new Rey())
        );

        // Act
        boolean esValida = twoPair.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test03JugadaNoValidaConTresCartasIguales() {
        // Arrange
        TwoPair twoPair = new TwoPair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new As()),
                new Poker(new Trebol(), new As()),
                new Poker(new Diamante(), new Rey())
        );

        // Act
        boolean esValida = twoPair.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test04JugadaNoValidaConCincoCartasSinPares() {
        // Arrange
        TwoPair twoPair = new TwoPair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new Rey()),
                new Poker(new Trebol(), new Reina()),
                new Poker(new Diamante(), new Jota()),
                new Poker(new Corazon(), new Diez())
        );

        // Act
        boolean esValida = twoPair.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test05JugadaNoValidaConMenosDeCuatroCartas() {
        // Arrange
        TwoPair twoPair = new TwoPair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new As()),
                new Poker(new Trebol(), new Rey())
        );

        // Act
        boolean esValida = twoPair.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test06JugadaValidaConDosParesYUnaCartaDiferente() {
        // Arrange
        TwoPair twoPair = new TwoPair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new As()),
                new Poker(new Trebol(), new Rey()),
                new Poker(new Diamante(), new Rey()),
                new Poker(new Corazon(), new Reina())
        );

        // Act
        boolean esValida = twoPair.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }
}