package Modelo.Unitarios;

// Importaciones
import Modelo.Juego.*;
import Modelo.Jugador.*;
import Modelo.SistemaCartas.Jugadas.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.CartaPoker;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

public class TestJugada {

    @Test
    public void test01LaManoTwoPairSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Diamante() ,new Reina());
        CartaPoker cartaPoker2 = new CartaPoker(new Pica() ,new Reina());
        CartaPoker cartaPoker3 = new CartaPoker(new Corazon() ,new Cinco());
        CartaPoker cartaPoker4 = new CartaPoker(new Pica() ,new Cinco());
        CartaPoker cartaPoker5 = new CartaPoker(new Trebol() ,new Dos());
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
        CartaPoker cartaPoker1 = new CartaPoker(new Diamante() ,new Rey());
        CartaPoker cartaPoker2 = new CartaPoker(new Trebol() ,new Rey());
        CartaPoker cartaPoker3 = new CartaPoker(new Trebol() ,new Siete());
        CartaPoker cartaPoker4 = new CartaPoker(new Pica() ,new Dos());
        CartaPoker cartaPoker5 = new CartaPoker(new Corazon() ,new Jota());
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
        CartaPoker cartaPoker1 = new CartaPoker(new Corazon() ,new Ocho());
        CartaPoker cartaPoker2 = new CartaPoker(new Pica() ,new Ocho());
        CartaPoker cartaPoker3 = new CartaPoker(new Trebol() ,new Ocho());
        CartaPoker cartaPoker4 = new CartaPoker(new Trebol() ,new Dos());
        CartaPoker cartaPoker5 = new CartaPoker(new Diamante() ,new Diez());
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
        CartaPoker cartaPoker1 = new CartaPoker(new Diamante() ,new Reina());
        CartaPoker cartaPoker2 = new CartaPoker(new Pica() ,new Siete());
        CartaPoker cartaPoker3 = new CartaPoker(new Corazon() ,new Cinco());
        CartaPoker cartaPoker4 = new CartaPoker(new Trebol() ,new Tres());
        CartaPoker cartaPoker5 = new CartaPoker(new Pica() ,new Diez());
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
        CartaPoker cartaPoker1 = new CartaPoker(new Diamante() ,new Tres());
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
