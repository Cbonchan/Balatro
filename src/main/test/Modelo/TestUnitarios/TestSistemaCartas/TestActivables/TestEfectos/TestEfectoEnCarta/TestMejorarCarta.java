package Modelo.TestUnitarios.TestSistemaCartas.TestActivables.TestEfectos.TestEfectoEnCarta;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarCarta;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.*;
import Modelo.SistemaCartas.Cartas.Palo.*;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMejorarCarta {

    @Test
    public void test01MejorarCartaHighCard() {
        // Arrange
        Carta carta = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta);
        // Se ocupa una mano "High Card (5,1) + 10 = 15 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 1;
        int valorEsperado = 6;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test02MejorarCartaPair() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Trebol(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        // Se ocupa una mano "Pair (10,2)" + 20 = 30 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(2);
        int incrementador = 2;
        int valorEsperado = 88;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta1);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test03MejorarCartaTwoPair() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Trebol(), new Rey());
        Carta carta3 = new Carta(new Corazon(), new Reina());
        Carta carta4 = new Carta(new Trebol(), new Reina());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        mano.agregarCarta(carta4);
        // Se ocupa una mano "Two Pair (20,2)" + 40  = 60 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(2);
        int incrementador = 20;
        int valorEsperado = 280;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta1);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test04MejorarCartaThreeOfAKind() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Diamante(), new Rey());
        Carta carta3 = new Carta(new Trebol(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        // Se ocupa una mano "Three of a Kind (30,3)" + 30 = 60 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(2);
        int incrementador = 1;
        int valorEsperado = 306;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta1);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test05MejorarCartaStraight() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Dos());
        Carta carta2 = new Carta(new Pica(), new Tres());
        Carta carta3 = new Carta(new Trebol(), new Cuatro());
        Carta carta4 = new Carta(new Corazon(), new Cinco());
        Carta carta5 = new Carta(new Diamante(), new Seis());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        mano.agregarCarta(carta4);
        mano.agregarCarta(carta5);
        // Se ocupa una mano "Straight (30,4)" + 20 = 50 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(3);
        int incrementador = 12;
        int valorEsperado = 720;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta1);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test06MejorarCartaFlush() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Tres());
        Carta carta3 = new Carta(new Corazon(), new Reina());
        Carta carta4 = new Carta(new Corazon(), new Jota());
        Carta carta5 = new Carta(new Corazon(), new Dos());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        mano.agregarCarta(carta4);
        mano.agregarCarta(carta5);
        // Se ocupa una mano "Flush (35, 4)" + 35 = 70 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 12;
        int valorEsperado = 320;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta5);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test07MejorarCartaFullHouse() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Diamante(), new Rey());
        Carta carta3 = new Carta(new Trebol(), new Rey());
        Carta carta4 = new Carta(new Trebol(), new Reina());
        Carta carta5 = new Carta(new Diamante(), new Reina());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        mano.agregarCarta(carta4);
        mano.agregarCarta(carta5);
        // Se ocupa una mano "Full House (40, 4)" + 50 = 90 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(5);
        int incrementador = 1;
        int valorEsperado = 1620;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta1);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test08MejorarCartaFourOfAKind() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Diamante(), new Rey());
        Carta carta3 = new Carta(new Trebol(), new Rey());
        Carta carta4 = new Carta(new Pica(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        mano.agregarCarta(carta4);
        // Se ocupa una mano "Four of a Kind (60, 7)" + 40 = 100 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 40;
        int valorEsperado = 910;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta1);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test09MejorarCartaStraightFlush() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Cuatro());
        Carta carta2 = new Carta(new Corazon(), new Dos());
        Carta carta3 = new Carta(new Corazon(), new Tres());
        Carta carta4 = new Carta(new Corazon(), new Cinco());
        Carta carta5 = new Carta(new Corazon(), new Seis());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        mano.agregarCarta(carta4);
        mano.agregarCarta(carta5);
        // Se ocupa una mano "Straight Flush (100,8)" + 20 = 120 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(2);
        int incrementador = 14;
        int valorEsperado = 2080;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta1);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test10MejorarCartaRoyalFlush() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Reina());
        Carta carta3 = new Carta(new Corazon(), new Jota());
        Carta carta4 = new Carta(new Corazon(), new Diez());
        Carta carta5 = new Carta(new Corazon(), new As());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        mano.agregarCarta(carta4);
        mano.agregarCarta(carta5);
        // Se ocupa una mano "Royal Flush (100,8)" + 51 = 151 (Chips)

        MejorarCarta mejorarCarta = new MejorarCarta();
        Multiplicador multiplicador = new Multiplicador(2);
        int incrementador = 10;
        int valorEsperado = 2400;

        // Act
        mejorarCarta.activar(incrementador, multiplicador, carta5);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }
}