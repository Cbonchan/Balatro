package Modelo.TestUnitarios.TestSistemaCartas.TestActivables.TestEfectos;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.SumarPuntaje;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.*;
import Modelo.SistemaCartas.Cartas.Palo.*;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSumarPuntaje {

    @Test
    public void test01SumarPuntajeHighCard() {
        // Arrange
        Carta carta = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta);
        // Se ocupa una mano "High Card (5,1) + 10 = 15 (Chips)

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 25;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test02SumarPuntajePair() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        // Se ocupa una mano "Pair (10,2)" + 20 = 30 (Chips)

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 20;
        int valorEsperado = 100;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test03SumarPuntajeTwoPair() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Rey());
        Carta carta3 = new Carta(new Corazon(), new Reina());
        Carta carta4 = new Carta(new Corazon(), new Reina());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        mano.agregarCarta(carta4);
        // Se ocupa una mano "Two Pair (20,2)" + 40  = 60 (Chips)

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 40;
        int valorEsperado = 200;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test04SumarPuntajeThreeOfAKind() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Rey());
        Carta carta3 = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        // Se ocupa una mano "Three of a Kind (30,3)" + 30 = 60 (Chips)

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 30;
        int valorEsperado = 270;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test05SumarPuntajeStraight() {
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

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 20;
        int valorEsperado = 280;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test06SumarPuntajeFlush() {
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

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 40;
        int valorEsperado = 440;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test07SumarPuntajeFullHouse() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Rey());
        Carta carta3 = new Carta(new Corazon(), new Rey());
        Carta carta4 = new Carta(new Trebol(), new Reina());
        Carta carta5 = new Carta(new Diamante(), new Reina());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        mano.agregarCarta(carta4);
        mano.agregarCarta(carta5);
        // Se ocupa una mano "Full House (40, 4)" + 50 = 90 (Chips)

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 50;
        int valorEsperado = 560;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test08SumarPuntajeFourOfAKind() {
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

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 40;
        int valorEsperado = 980;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test09SumarPuntajeStraightFlush() {
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

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 20;
        int valorEsperado = 1120;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test10SumarPuntajeRoyalFlush() {
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

        SumarPuntaje sumarPuntaje = new SumarPuntaje();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 51;
        int valorEsperado = 1616;

        // Act
        sumarPuntaje.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }
}