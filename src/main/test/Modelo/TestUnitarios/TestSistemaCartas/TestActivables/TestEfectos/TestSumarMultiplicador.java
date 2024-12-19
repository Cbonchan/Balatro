package Modelo.TestUnitarios.TestSistemaCartas.TestActivables.TestEfectos;


import Modelo.SistemaCartas.Activables.SistemaDeEfecto.SumarMultiplicador;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.*;
import Modelo.SistemaCartas.Cartas.Palo.*;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSumarMultiplicador {

    @Test
    public void test01SumarMultiplicadorHighCard() {
        // Arrange
        Carta carta = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta);
        // Se ocupa una mano "High Card (5,1) + 10 = 15 (Chips)

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 30;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test02SumarMultiplicadorPair() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        // Se ocupa una mano "Pair (10,2)" + 20 = 30 (Chips)

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 120;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test03SumarMultiplicadorTwoPair() {
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

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 240;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test04SumarMultiplicadorThreeOfAKind() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Rey());
        Carta carta3 = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        // Se ocupa una mano "Three of a Kind (30,3)" + 30 = 60 (Chips)

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 360;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test05SumarMultiplicadorStraight() {
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

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 400;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test06SumarMultiplicadorFlush() {
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

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 560;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test07SumarMultiplicadorFullHouse() {
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

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 720;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test08SumarMultiplicadorFourOfAKind() {
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

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 1400;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test09SumarMultiplicadorStraightFlush() {
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

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 1920;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test10SumarMultiplicadorRoyalFlush() {
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

        SumarMultiplicador sumarMultiplicador = new SumarMultiplicador();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 0; // No se usa en este efecto
        int valorEsperado = 2416;

        // Act
        sumarMultiplicador.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }
}