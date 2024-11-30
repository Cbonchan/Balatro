package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;

import  Modelo.SistemaCartas.Jugadas.HighCard;

public class TestHighCard {

    @Test
    public void test01EsValidaCon1Carta() {
        // Arrange
        HighCard highCard = new HighCard();
        Carta carta = new Carta(new Diamante(), new As());
        List<Carta> cartas = List.of(carta);

        // Act
        boolean esValida = highCard.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02EsJugadaValidaCon2CartasDeDiferentePaloYFigura() {
        // Arrange
        HighCard highCard = new HighCard();
        Carta carta1 = new Carta(new Diamante(), new As());
        Carta carta2 = new Carta(new Pica(), new Rey());
        List<Carta> cartas = List.of(carta1, carta2);

        // Act
        boolean esValida = highCard.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test03DeVuelveCorrectamenteLaCartaMasAltaCon2Cartas() {
        // Arrange
        HighCard highCard = new HighCard();
        Carta carta1 = new Carta(new Diamante(), new As());
        Carta carta2 = new Carta(new Pica(), new Rey());
        List<Carta> cartas = List.of(carta1, carta2);

        // Act
        List<Carta> cartasJugadas = highCard.cartasJugadas(cartas);

        // Assert
        assertEquals(carta1, cartasJugadas.get(0)); // As es la carta más alta
    }

    @Test
    public void test04EsJugadaValidaCon5CartasDeDiferentePaloYFigura() {
        // Arrange
        HighCard highCard = new HighCard();
        Carta carta1 = new Carta(new Diamante(), new As());
        Carta carta2 = new Carta(new Pica(), new Rey());
        Carta carta3 = new Carta(new Corazon(), new Reina());
        Carta carta4 = new Carta(new Trebol(), new Jota());
        Carta carta5 = new Carta(new Diamante(), new Diez());
        List<Carta> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
        boolean esValida = highCard.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test05DeVuelveCorrectamenteLaCartaMasAltaCon5Cartas() {
        // Arrange
        HighCard highCard = new HighCard();
        Carta carta1 = new Carta(new Diamante(), new As());
        Carta carta2 = new Carta(new Pica(), new Rey());
        Carta carta3 = new Carta(new Corazon(), new Reina());
        Carta carta4 = new Carta(new Trebol(), new Jota());
        Carta carta5 = new Carta(new Diamante(), new Diez());
        List<Carta> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
        List<Carta> cartasJugadas = highCard.cartasJugadas(cartas);

        // Assert
        assertEquals(carta1, cartasJugadas.get(0));
    }

    @Test
    public void test06HighCardNoEsValidaConLaManoVacia() {
        // Arrange
        HighCard highCard = new HighCard();
        List<Carta> cartas = List.of();

        // Act
        boolean esValida = highCard.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

}
