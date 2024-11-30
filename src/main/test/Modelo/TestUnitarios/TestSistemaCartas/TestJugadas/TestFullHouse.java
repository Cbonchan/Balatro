package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;


import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Jugadas.FullHouse;

public class TestFullHouse {

    @Test
    public void test01JugadaValidaConTresCartasConIgualFiguraYDosCartasIgualFigura() {
        // Arrange
        FullHouse fullHouse = new FullHouse();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Trebol(), new As()),
                new Carta(new Diamante(), new As()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Trebol(), new Rey())
        );

        // Act
        boolean esValida = fullHouse.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02JugadaNoValidaConTresCartasIgualesYDosCartasDiferentes() {
        // Arrange
        FullHouse fullHouse = new FullHouse();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Trebol(), new Reina())
        );

        // Act
        boolean esValida = fullHouse.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test03JugadaNoValidaConCuatroCartasIgualesYUnaCartaDiferente() {
        // Arrange
        FullHouse fullHouse = new FullHouse();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new As()),
                new Carta(new Trebol(), new Rey())
        );

        // Act
        boolean esValida = fullHouse.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test04JugadaNoValidaConCincoCartasDiferentes() {
        // Arrange
        FullHouse fullHouse = new FullHouse();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Trebol(), new Reina()),
                new Carta(new Diamante(), new Jota()),
                new Carta(new Corazon(), new Diez())
        );

        // Act
        boolean esValida = fullHouse.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test05JugadaNoValidaConMenosDeCincoCartas() {
        // Arrange
        FullHouse fullHouse = new FullHouse();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey())
        );

        // Act
        boolean esValida = fullHouse.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test06JugadaValidaConTresCartasIgualFiguraYPaloYDosCartasIgualesDeOtroPalo() {
        // Arrange
        FullHouse fullHouse = new FullHouse();
        List<Carta> cartas = List.of(
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new As()),
                new Carta(new Corazon(), new As()),
                new Carta(new Pica(), new Rey()),
                new Carta(new Pica(), new Rey())
        );

        // Act
        boolean esValida = fullHouse.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }
}