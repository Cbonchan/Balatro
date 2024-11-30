package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Jugadas.FourOfAKind;

public class TestFourOfAKind {

    @Test
    public void test01JugadaValidaConCuatroCartasDeLaMismaFigura() {
        // Arrange
        FourOfAKind fourOfAKind = new FourOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Pica(), new Cinco()),
                new Carta(new Corazon(), new Cinco()),
                new Carta(new Trebol(), new Cinco()),
                new Carta(new Diamante(), new Seis())
        );

        // Act
        boolean esValida = fourOfAKind.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02JugadaNoValidaConTresCartasDeLaMismaFigura() {
        // Arrange
        FourOfAKind fourOfAKind = new FourOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Pica(), new Cinco()),
                new Carta(new Corazon(), new Cinco()),
                new Carta(new Trebol(), new Cuatro()),
                new Carta(new Diamante(), new Seis())
        );

        // Act
        boolean esValida = fourOfAKind.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test03JugadaNoValidaConMenosDeCuatroCartas() {
        // Arrange
        FourOfAKind fourOfAKind = new FourOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Pica(), new Cinco()),
                new Carta(new Corazon(), new Cinco())
        );

        // Act
        boolean esValida = fourOfAKind.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test04CartasJugadasDevuelveCuatroCartasDeLaMismaFigura() {
        // Arrange
        FourOfAKind fourOfAKind = new FourOfAKind();
        Carta carta1 = new Carta(new Diamante(), new Cinco());
        Carta carta2 = new Carta(new Pica(), new Cinco());
        Carta carta3 = new Carta(new Corazon(), new Cinco());
        Carta carta4 = new Carta(new Trebol(), new Cinco());
        Carta carta5 = new Carta(new Diamante(), new Seis());
        List<Carta> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
        List<Carta> cartasJugadas = fourOfAKind.cartasJugadas(cartas);

        // Assert
        assertEquals(List.of(carta1, carta2, carta3, carta4), cartasJugadas);
    }

        @Test
    public void test05JugadaNoValidaConCincoCartasDistintasFiguras() {
        // Arrange
        FourOfAKind fourOfAKind = new FourOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Corazon(), new Jota()),
                new Carta(new Trebol(), new Cuatro()),
                new Carta(new Diamante(), new Siete())
        );

        // Act
        boolean esValida = fourOfAKind.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test06JugadaValidaConCuatroCartasDeLaMismaFigura() {
        // Arrange
        FourOfAKind fourOfAKind = new FourOfAKind();
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Pica(), new Cinco()),
                new Carta(new Corazon(), new Cinco()),
                new Carta(new Trebol(), new Cinco())
        );

        // Act
        boolean esValida = fourOfAKind.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

}