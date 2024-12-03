package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Palo.*;
import Modelo.SistemaCartas.Cartas.Figura.*;

import Modelo.SistemaCartas.Jugadas.ThreeOfAKind;

public class TestThreeOfAKind {

    @Test
    public void test01JugadaValidaConTresCartasIguales() {
        // Arrange
        ThreeOfAKind threeOfAKind = new ThreeOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As()),
                new Carta(new Trebol(), new As())
        );

        // Act
        boolean esValida = threeOfAKind.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02JugadaNoValidaConDosCartasIguales() {
        // Arrange
        ThreeOfAKind threeOfAKind = new ThreeOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As())
        );

        // Act
        boolean esValida = threeOfAKind.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test03JugadaNoValidaConTresCartasDiferentes() {
        // Arrange
        ThreeOfAKind threeOfAKind = new ThreeOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Trebol(), new Reina())
        );

        // Act
        boolean esValida = threeOfAKind.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test04JugadaValidaConMasDeTresCartasYUnTrio() {
        // Arrange
        ThreeOfAKind threeOfAKind = new ThreeOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As()),
                new Carta(new Trebol(), new As()),
                new Carta(new Diamante(), new Rey())
        );

        // Act
        boolean esValida = threeOfAKind.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test05JugadaNoValidaConMenosDeTresCartas() {
        // Arrange
        ThreeOfAKind threeOfAKind = new ThreeOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey())
        );

        // Act
        boolean esValida = threeOfAKind.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test06JugadaValidaConTresCartasIgualesYDosCartasDiferentes() {
        // Arrange
        ThreeOfAKind threeOfAKind = new ThreeOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new As()),
                new Carta(new Trebol(), new As()),
                new Carta(new Diamante(), new Rey()),
                new Carta(new Corazon(), new Reina())
        );

        // Act
        boolean esValida = threeOfAKind.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }
}