package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

import  Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;

import  Modelo.SistemaCartas.Jugadas.HighCard;

public class TestHighCard {

    @Test
    public void test01EsValidaCon1Carta() {
        // Arrange
        HighCard highCard = new HighCard();
        Poker carta = new Poker(new Diamante(), new As());
        List<Poker> cartas = List.of(carta);

        // Act
        boolean esValida = highCard.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02EsJugadaValidaCon2CartasDeDiferentePaloYFigura() {
        // Arrange
        HighCard highCard = new HighCard();
        Poker carta1 = new Poker(new Diamante(), new As());
        Poker carta2 = new Poker(new Pica(), new Rey());
        List<Poker> cartas = List.of(carta1, carta2);

        // Act
        boolean esValida = highCard.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test03DeVuelveCorrectamenteLaCartaMasAltaCon2Cartas() {
        // Arrange
        HighCard highCard = new HighCard();
        Poker carta1 = new Poker(new Diamante(), new As());
        Poker carta2 = new Poker(new Pica(), new Rey());
        List<Poker> cartas = List.of(carta1, carta2);

        // Act
        List<Poker> cartasJugadas = highCard.cartasJugadas(cartas);

        // Assert
        assertEquals(carta1, cartasJugadas.get(0)); // As es la carta más alta
    }

    @Test
    public void test04EsJugadaValidaCon5CartasDeDiferentePaloYFigura() {
        // Arrange
        HighCard highCard = new HighCard();
        Poker carta1 = new Poker(new Diamante(), new As());
        Poker carta2 = new Poker(new Pica(), new Rey());
        Poker carta3 = new Poker(new Corazon(), new Reina());
        Poker carta4 = new Poker(new Trebol(), new Jota());
        Poker carta5 = new Poker(new Diamante(), new Diez());
        List<Poker> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
        boolean esValida = highCard.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test05DeVuelveCorrectamenteLaCartaMasAltaCon5Cartas() {
        // Arrange
        HighCard highCard = new HighCard();
        Poker carta1 = new Poker(new Diamante(), new As());
        Poker carta2 = new Poker(new Pica(), new Rey());
        Poker carta3 = new Poker(new Corazon(), new Reina());
        Poker carta4 = new Poker(new Trebol(), new Jota());
        Poker carta5 = new Poker(new Diamante(), new Diez());
        List<Poker> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
        List<Poker> cartasJugadas = highCard.cartasJugadas(cartas);

        // Assert
        assertEquals(carta1, cartasJugadas.get(0));
    }

    @Test
    public void test06HighCardNoEsValidaConLaManoVacia() {
        // Arrange
        HighCard highCard = new HighCard();
        List<Poker> cartas = List.of();

        // Act
        boolean esValida = highCard.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

}
