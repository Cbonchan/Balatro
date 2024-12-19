package Modelo.TestUnitarios.TestSistemaCartas.TestActivables.TestEfectos;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarJugada;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.*;
import Modelo.SistemaCartas.Cartas.Palo.Corazon;

import Modelo.SistemaCartas.Cartas.Palo.Diamante;
import Modelo.SistemaCartas.Cartas.Palo.Pica;
import Modelo.SistemaCartas.Cartas.Palo.Trebol;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMejorarJugada {

    @Test
    public void test01MejorarJugadaIncrementaPuntajeHighCard() {
        // Arrange
        Carta carta = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta);
        // Se ocupa una mano "High Card (5,1)"  + 10  = 15 (Chips)

        MejorarJugada mejorarJugada = new MejorarJugada("carta alta");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 5;
        int valorEsperado = 40;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test02MejorarJugadaIncrementaPuntajePair() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        // Se ocupa una mano "Pair (10,2)" +  20  = 30 (Chips)

        MejorarJugada mejorarJugada = new MejorarJugada("par");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 120;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test03MejorarJugadaIncrementaPuntajeTwoPair() {
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
        // Se ocupa una mano "Two Pair (20,2)" + 40= 60 (Chips)

        MejorarJugada mejorarJugada = new MejorarJugada("doble par");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 210;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test04MejorarJugadaIncrementaPuntajeThreeOfAKind() {
        // Arrange
        Carta carta1 = new Carta(new Corazon(), new Rey());
        Carta carta2 = new Carta(new Corazon(), new Rey());
        Carta carta3 = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);
        mano.agregarCarta(carta3);
        // Se ocupa una mano "Three of a Kind (30, 3)" + 30  = 60 (Chips)

        MejorarJugada mejorarJugada = new MejorarJugada("trio");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 280;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test05MejorarJugadaIncrementaPuntajeStraight() {
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
        // Se ocupa una mano "Straight (30, 4)" y 20 = 50 (Chips Base)

        MejorarJugada mejorarJugada = new MejorarJugada("escalera");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 300;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test06MejorarJugadaIncrementaPuntajeFlush() {
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

        MejorarJugada mejorarJugada = new MejorarJugada("color");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 400;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test07MejorarJugadaIncrementaPuntajeFullHouse() {
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
        // Se ocupa una mano "Full House (40, 4)" +  50 chips  =  90 (Chips)

        MejorarJugada mejorarJugada = new MejorarJugada("full");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 500;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test08MejorarJugadaIncrementaPuntajeFourOfAKind() {
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
        // Se ocupa una mano "Four of a Kind (60,7)" +  40 = 100 (Chips)

        MejorarJugada mejorarJugada = new MejorarJugada("poker");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 880;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test09MejorarJugadaIncrementaPuntajeStraightFlush() {
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
        // Se ocupa una mano "Straight Flush (100, 8)" + 20  = 120 (Chips)

        MejorarJugada mejorarJugada = new MejorarJugada("escalera de color");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 1170;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test10MejorarJugadaIncrementaPuntajeRoyalFlush() {
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
        // Se ocupa una mano "Royal Flush (100,8)"  + 51 = 151 (Base)

        MejorarJugada mejorarJugada = new MejorarJugada("escalera real de color");
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 10;
        int valorEsperado = 1449;

        // Act
        mejorarJugada.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }
}