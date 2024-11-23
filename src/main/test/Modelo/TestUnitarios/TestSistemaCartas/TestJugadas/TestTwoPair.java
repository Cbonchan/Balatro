package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;

import Modelo.SistemaCartas.Jugadas.TwoPair;

public class TestTwoPair {

    @Test
    public void test01JugadaValidaConDosPares() {
        // Arrange
        TwoPair twoPair = new TwoPair();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As()),
                new Carta(new Trebol(), new Rey()),
                new Carta(new Diamante(), new Rey())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As()),
                new Carta(new Trebol(), new Rey())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As()),
                new Carta(new Trebol(), new As()),
                new Carta(new Diamante(), new Rey())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Trebol(), new Reina()),
                new Carta(new Diamante(), new Jota()),
                new Carta(new Corazon(), new Diez())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As()),
                new Carta(new Trebol(), new Rey())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As()),
                new Carta(new Trebol(), new Rey()),
                new Carta(new Diamante(), new Rey()),
                new Carta(new Corazon(), new Reina())
        );

        // Act
        boolean esValida = twoPair.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }
}