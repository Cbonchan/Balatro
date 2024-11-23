package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Figura.*;

import Modelo.SistemaCartas.Jugadas.Pair;

public class TestPair {

    @Test
    public void test01JugadaValidaConDosCartasIguales() {
        // Arrange
        Pair pair = new Pair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new As())
        );

        // Act
        boolean esValida = pair.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02JugadaNoValidaConDosCartasDiferentes() {
        // Arrange
        Pair pair = new Pair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new Rey())
        );

        // Act
        boolean esValida = pair.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test03JugadaValidaConMasDeDosCartasYUnPar() {
        // Arrange
        Pair pair = new Pair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new As()),
                new Poker(new Trebol(), new Rey())
        );

        // Act
        boolean esValida = pair.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test04JugadaNoValidaConMasDeDosCartasSinPar() {
        // Arrange
        Pair pair = new Pair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new Rey()),
                new Poker(new Trebol(), new Reina())
        );

        // Act
        boolean esValida = pair.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test05JugadaNoValidaConUnaSolaCarta() {
        // Arrange
        Pair pair = new Pair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As())
        );

        // Act
        boolean esValida = pair.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test06NoJugadaValidaConCincoCartasDistintas() {
        // Arrange
        Pair pair = new Pair();
        List<Poker> cartas = List.of(
                new Poker(new Corazon(), new As()),
                new Poker(new Pica(), new Dos()),
                new Poker(new Trebol(), new Rey()),
                new Poker(new Diamante(), new Ocho())
        );

        // Act
        boolean esValida = pair.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }
}