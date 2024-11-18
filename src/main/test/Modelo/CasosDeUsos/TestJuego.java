 package Modelo.CasosDeUsos;

// Importaciones
import Modelo.Juego.*;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.Jugador.Mazo;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Tarot.*;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;


//! NO ENTIENDO DIFERENCIA ENTRE TEST 3 Y 4 (Ver enunciado)
// Coloco dos test  distinto, pero no entiendo


public class TestJuego {

    @Test
    public void test01JugadorPoseeCartasSuficienteParaEmpezarJuego(){
        // Arrange
        // En un futuro debe ser con Jugador, No mazo (Creo yo)
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 52;

        // Act y Assert
        assertEquals(cantidadDeCartasEsperadas, mazo.getCartasDisponibles(), "El mazo debe tener 52 cartas una vez inicializado");
    }

    @Test
    public void test02JugadorTiene8CartasEnLaManoDeSuMazo(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 8;

        // Act
        mazo.repartirCartas(jugador);

        // Assert
        assertEquals(cantidadDeCartasEsperadas, jugador.getCantidadCartas(), "El jugador debe tener 8 cartas después de repartir.");
    }

    @Test
    public void test03LaManoTwoPairSeCalculaCorrectamente(){
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
    public void test04LaManoPairSeCalculaCorrectamente(){
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
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void test05LaManoSeCalculaEnElOrdenCorrecto(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker cartaPoker1 = new Poker(new Pica() ,new Reina());
        Poker cartaPoker2 = new Poker(new Pica() ,new Jota());
        Poker cartaPoker3 = new Poker(new Pica() ,new Diez());
        Poker cartaPoker4 = new Poker(new Pica() ,new Nueve());
        Poker cartaPoker5 = new Poker(new Pica() ,new Ocho());
        int primerValorEsperado = 15;
        int segundoValorEsperado = 30;
        int tercerValorEsperado = 45;
        int cuartoValorEsperado = 60;
        int quintoValorEsperado = 1236;

        // Act y Assert
        //!!Multiples Assert -> Preguntar profes si esta bien
        jugador.seleccionarCarta(cartaPoker1);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();
        assertEquals(primerValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaPoker2);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntaje();
        assertEquals(segundoValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaPoker3);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntaje();
        assertEquals(tercerValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaPoker4);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntaje();
        assertEquals(cuartoValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntaje();
        assertEquals(quintoValorEsperado,valorObtenido);
    }

    @Test
    public void test06SeAplicaTarotX10PuntosYSeCalulaCorrectamenteElPutntaje(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker cartaPoker1 = new Poker(new Pica() ,new As());
        Poker cartaPoker2 = new Poker(new Corazon() ,new As());
        Poker cartaPoker3 = new Poker(new Pica() ,new Jota());
        Poker cartaPoker4 = new Poker(new Corazon() ,new Jota());
        Poker cartaPoker5 = new Poker(new Pica() ,new Diez());
        Tarot tarotPuntosX10 = new Tarot(10, 0);
        int valorEsperado = 122;

        tarotPuntosX10.cambiarPuntaje(cartaPoker1);
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
    public void test07SeAplicaTarotX6MultiplicadorYSeCalulaCorrectamenteElPutntaje(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker cartaPoker1 = new Poker(new Pica() ,new As());
        Poker cartaPoker2 = new Poker(new Corazon() ,new As());
        Poker cartaPoker3 = new Poker(new Pica() ,new Reina());
        Poker cartaPoker4 = new Poker(new Pica() ,new Jota());
        Poker cartaPoker5 = new Poker(new Pica() ,new Diez());
        Tarot taroMultiplicadorX6 = new Tarot(0, 6);
        int valorEsperado = 256;

        taroMultiplicadorX6.cambiarMultiplicador(cartaPoker1);
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


}
