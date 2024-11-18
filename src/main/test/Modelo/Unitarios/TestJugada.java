package Modelo.Unitarios;

// Importaciones
import Modelo.Juego.*;
import Modelo.Jugador.*;
import Modelo.SistemaCartas.Jugadas.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Poker;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

public class TestJugada {

    @Test
    public void test01LaManoTwoPairSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker cartaPoker1 = new Poker(new Diamante() ,new Reina());
        Poker cartaPoker2 = new Poker(new Pica() ,new Reina());
        Poker cartaPoker3 = new Poker(new Corazon() ,new Cinco());
        Poker cartaPoker4 = new Poker(new Pica() ,new Cinco());
        Poker cartaPoker5 = new Poker(new Trebol() ,new Dos());
        int valorEsperado = 100;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test02LaManoPairSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Rey());
        Poker cartaPoker3 = new Poker(new Trebol() ,new Siete());
        Poker cartaPoker4 = new Poker(new Pica() ,new Dos());
        Poker cartaPoker5 = new Poker(new Corazon() ,new Jota());
        int valorEsperado = 60;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test03LaManoThreeOfAKindSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker cartaPoker1 = new Poker(new Corazon() ,new Ocho());
        Poker cartaPoker2 = new Poker(new Pica() ,new Ocho());
        Poker cartaPoker3 = new Poker(new Trebol() ,new Ocho());
        Poker cartaPoker4 = new Poker(new Trebol() ,new Dos());
        Poker cartaPoker5 = new Poker(new Diamante() ,new Diez());
        int valorEsperado = 162;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test04LaManoHighCardSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker cartaPoker1 = new Poker(new Diamante() ,new Reina());
        Poker cartaPoker2 = new Poker(new Pica() ,new Siete());
        Poker cartaPoker3 = new Poker(new Corazon() ,new Cinco());
        Poker cartaPoker4 = new Poker(new Trebol() ,new Tres());
        Poker cartaPoker5 = new Poker(new Pica() ,new Diez());
        int valorEsperado = 15;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test05LaManoStraightSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker cartaPoker1 = new CartaPoker(new Diamante() ,new Tres());
        CartaPoker cartaPoker2 = new CartaPoker(new Trebol() ,new Cuatro());
        CartaPoker cartaPoker3 = new CartaPoker(new Diamante() ,new Cinco());
        CartaPoker cartaPoker4 = new CartaPoker(new Pica() ,new Seis());
        CartaPoker cartaPoker5 = new CartaPoker(new Corazon() ,new Siete());
        int valorEsperado = 220;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test06LaManoFlushSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Trebol() ,new Siete());
        CartaPoker cartaPoker2 = new CartaPoker(new Trebol() ,new Cuatro());
        CartaPoker cartaPoker3 = new CartaPoker(new Trebol() ,new Reina());
        CartaPoker cartaPoker4 = new CartaPoker(new Trebol() ,new As());
        CartaPoker cartaPoker5 = new CartaPoker(new Trebol() ,new Dos());
        int valorEsperado = 276;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

//    @Test
//    public void test07LaManoFullHouseSeCalculaCorrectamente(){
//        // Arrange
//        Mano mano = new Mano();
//        Jugador jugador = new Jugador(mano);
//        Tablero tablero = new Tablero();
//        CartaPoker cartaPoker1 = new CartaPoker(new Corazon() ,new As());
//        CartaPoker cartaPoker2 = new CartaPoker(new Pica() ,new As());
//        CartaPoker cartaPoker3 = new CartaPoker(new Diamante() ,new As());
//        CartaPoker cartaPoker4 = new CartaPoker(new Diamante() ,new Rey());
//        CartaPoker cartaPoker5 = new CartaPoker(new Pica() ,new Rey());
//        int valorEsperado = 372;
//
//        jugador.seleccionarCarta(cartaPoker1);
//        jugador.seleccionarCarta(cartaPoker2);
//        jugador.seleccionarCarta(cartaPoker3);
//        jugador.seleccionarCarta(cartaPoker4);
//        jugador.seleccionarCarta(cartaPoker5);
//        jugador.jugar(tablero);
//
//        // Act
//        int valorObtenido = jugador.getPuntaje();
//
//        // Assert
//        assertEquals(valorEsperado,valorObtenido);
//    }

    @Test
    public void test08LaManoFourOfAKindSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Diamante() ,new Seis());
        CartaPoker cartaPoker2 = new CartaPoker(new Pica() ,new Seis());
        CartaPoker cartaPoker3 = new CartaPoker(new Corazon() ,new Seis());
        CartaPoker cartaPoker4 = new CartaPoker(new Trebol() ,new Seis());
        CartaPoker cartaPoker5 = new CartaPoker(new Diamante() ,new Tres());
        int valorEsperado = 588;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test09LaManoStraightFlushSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Pica() ,new Reina());
        CartaPoker cartaPoker2 = new CartaPoker(new Pica() ,new Jota());
        CartaPoker cartaPoker3 = new CartaPoker(new Pica() ,new Diez());
        CartaPoker cartaPoker4 = new CartaPoker(new Pica() ,new Nueve());
        CartaPoker cartaPoker5 = new CartaPoker(new Pica() ,new Ocho());
        int valorEsperado = 1176;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

//    @Test
//    public void test10LaManoRoyalFLushSeCalculaCorrectamente(){
//        // Arrange
//        Mano mano = new Mano();
//        Jugador jugador = new Jugador(mano);
//        Tablero tablero = new Tablero();
//        CartaPoker cartaPoker1 = new CartaPoker(new Pica() ,new As());
//        CartaPoker cartaPoker2 = new CartaPoker(new Pica() ,new Rey());
//        CartaPoker cartaPoker3 = new CartaPoker(new Pica() ,new Reina());
//        CartaPoker cartaPoker4 = new CartaPoker(new Pica() ,new Jota());
//        CartaPoker cartaPoker5 = new CartaPoker(new Pica() ,new Diez());
//        int valorEsperado = 1208;
//
//        jugador.seleccionarCarta(cartaPoker1);
//        jugador.seleccionarCarta(cartaPoker2);
//        jugador.seleccionarCarta(cartaPoker3);
//        jugador.seleccionarCarta(cartaPoker4);
//        jugador.seleccionarCarta(cartaPoker5);
//        jugador.jugar(tablero);
//
//        // Act
//        int valorObtenido = jugador.getPuntaje();
//
//        // Assert
//        assertEquals(valorEsperado,valorObtenido);
//    }

}
