package Modelo.TestUnitarios.TestUsuario;

// Importaciones
import Modelo.Usuario.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Carta;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

//! Este test, realmente es de Jugador, no de Jugada

public class TestJugada {

    @Test
    public void test01LaManoHighCardSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Diamante() ,new Reina());
        Carta cartaCarta2 = new Carta(new Pica() ,new Siete());
        Carta cartaCarta3 = new Carta(new Corazon() ,new Cinco());
        Carta cartaCarta4 = new Carta(new Trebol() ,new Tres());
        Carta cartaCarta5 = new Carta(new Pica() ,new Diez());
        int valorEsperado = 15;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test02LaManoPairSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Diamante() ,new Rey());
        Carta cartaCarta2 = new Carta(new Trebol() ,new Rey());
        Carta cartaCarta3 = new Carta(new Trebol() ,new Siete());
        Carta cartaCarta4 = new Carta(new Pica() ,new Dos());
        Carta cartaCarta5 = new Carta(new Corazon() ,new Jota());
        int valorEsperado = 60;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test03LaManoTwoPairSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Diamante() ,new Reina());
        Carta cartaCarta2 = new Carta(new Pica() ,new Reina());
        Carta cartaCarta3 = new Carta(new Corazon() ,new Cinco());
        Carta cartaCarta4 = new Carta(new Pica() ,new Cinco());
        Carta cartaCarta5 = new Carta(new Trebol() ,new Dos());
        int valorEsperado = 100;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);

    }

    @Test
    public void test04LaManoThreeOfAKindSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Corazon() ,new Ocho());
        Carta cartaCarta2 = new Carta(new Pica() ,new Ocho());
        Carta cartaCarta3 = new Carta(new Trebol() ,new Ocho());
        Carta cartaCarta4 = new Carta(new Trebol() ,new Dos());
        Carta cartaCarta5 = new Carta(new Diamante() ,new Diez());
        int valorEsperado = 162;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test05LaManoStraightSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Diamante() ,new Tres());
        Carta cartaCarta2 = new Carta(new Trebol() ,new Cuatro());
        Carta cartaCarta3 = new Carta(new Diamante() ,new Cinco());
        Carta cartaCarta4 = new Carta(new Pica() ,new Seis());
        Carta cartaCarta5 = new Carta(new Corazon() ,new Siete());
        int valorEsperado = 220;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test06LaManoFlushSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Trebol() ,new Siete());
        Carta cartaCarta2 = new Carta(new Trebol() ,new Cuatro());
        Carta cartaCarta3 = new Carta(new Trebol() ,new Reina());
        Carta cartaCarta4 = new Carta(new Trebol() ,new As());
        Carta cartaCarta5 = new Carta(new Trebol() ,new Dos());
        int valorEsperado = 276;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test07LaManoFullHouseSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Corazon() ,new As());
        Carta cartaCarta2 = new Carta(new Pica() ,new As());
        Carta cartaCarta3 = new Carta(new Diamante() ,new As());
        Carta cartaCarta4 = new Carta(new Diamante() ,new Rey());
        Carta cartaCarta5 = new Carta(new Pica() ,new Rey());
        int valorEsperado = 372;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test08LaManoFourOfAKindSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Diamante() ,new Seis());
        Carta cartaCarta2 = new Carta(new Pica() ,new Seis());
        Carta cartaCarta3 = new Carta(new Corazon() ,new Seis());
        Carta cartaCarta4 = new Carta(new Trebol() ,new Seis());
        Carta cartaCarta5 = new Carta(new Diamante() ,new Tres());
        int valorEsperado = 588;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test09LaManoStraightFlushSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Pica() ,new Reina());
        Carta cartaCarta2 = new Carta(new Pica() ,new Jota());
        Carta cartaCarta3 = new Carta(new Pica() ,new Diez());
        Carta cartaCarta4 = new Carta(new Pica() ,new Nueve());
        Carta cartaCarta5 = new Carta(new Pica() ,new Ocho());
        int valorEsperado = 1176;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test10LaManoRoyalFLushSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Pica() ,new As());
        Carta cartaCarta2 = new Carta(new Pica() ,new Rey());
        Carta cartaCarta3 = new Carta(new Pica() ,new Reina());
        Carta cartaCarta4 = new Carta(new Pica() ,new Jota());
        Carta cartaCarta5 = new Carta(new Pica() ,new Diez());
        int valorEsperado = 1208;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);

        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

}
