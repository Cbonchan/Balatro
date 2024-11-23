package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Jugadas.FourOfAKind;

public class TestFourOfAKind {

    @Test
    public void test01JugadaValidaConCuatroCartasDeLaMismaFigura() {
        // Arrange
        FourOfAKind fourOfAKind = new FourOfAKind();
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Pica(), new Cinco()),
                new Poker(new Corazon(), new Cinco()),
                new Poker(new Trebol(), new Cinco()),
                new Poker(new Diamante(), new Seis())
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
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Pica(), new Cinco()),
                new Poker(new Corazon(), new Cinco()),
                new Poker(new Trebol(), new Cuatro()),
                new Poker(new Diamante(), new Seis())
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
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Pica(), new Cinco()),
                new Poker(new Corazon(), new Cinco())
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
        Poker carta1 = new Poker(new Diamante(), new Cinco());
        Poker carta2 = new Poker(new Pica(), new Cinco());
        Poker carta3 = new Poker(new Corazon(), new Cinco());
        Poker carta4 = new Poker(new Trebol(), new Cinco());
        Poker carta5 = new Poker(new Diamante(), new Seis());
        List<Poker> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
        List<Poker> cartasJugadas = fourOfAKind.cartasJugadas(cartas);

        // Assert
        assertEquals(List.of(carta1, carta2, carta3, carta4), cartasJugadas);
    }

        @Test
    public void test05JugadaNoValidaConCincoCartasDistintasFiguras() {
        // Arrange
        FourOfAKind fourOfAKind = new FourOfAKind();
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Pica(), new Rey()),
                new Poker(new Corazon(), new Jota()),
                new Poker(new Trebol(), new Cuatro()),
                new Poker(new Diamante(), new Siete())
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
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Pica(), new Cinco()),
                new Poker(new Corazon(), new Cinco()),
                new Poker(new Trebol(), new Cinco())
        );

        // Act
        boolean esValida = fourOfAKind.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

}