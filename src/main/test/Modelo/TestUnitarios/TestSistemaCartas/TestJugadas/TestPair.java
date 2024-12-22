package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Cartas.Palo.*;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.*;

import Modelo.SistemaCartas.Jugadas.Pair;

public class TestPair {

    @Test
    public void test01JugadaValidaConDosCartasIguales() {
        // Arrange
        Pair pair = new Pair();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Trebol(), new Rey()),
                new Carta(new Pica(), new As())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Trebol(), new Reina())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As())
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
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Dos()),
                new Carta(new Trebol(), new Rey()),
                new Carta(new Diamante(), new Ocho())
        );

        // Act
        boolean esValida = pair.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }
}