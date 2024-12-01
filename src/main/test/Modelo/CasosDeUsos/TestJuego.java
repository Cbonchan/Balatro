 package Modelo.CasosDeUsos;

// Importaciones
import Modelo.Juego.*;
import Modelo.Usuario.Jugador;
import Modelo.Usuario.Mano;
import Modelo.Usuario.Mazo;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Carta;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;


//! NO ENTIENDO DIFERENCIA ENTRE TEST 3 Y 4 (Ver enunciado)
// Coloco dos test  distinto, pero no entiendo


public class TestJuego {

    /*

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
        Jugador jugador = new Jugador();
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
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test04LaManoPairSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void test05LaManoSeCalculaEnElOrdenCorrecto(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta cartaCarta1 = new Carta(new Pica() ,new Reina());
        Carta cartaCarta2 = new Carta(new Pica() ,new Jota());
        Carta cartaCarta3 = new Carta(new Pica() ,new Diez());
        Carta cartaCarta4 = new Carta(new Pica() ,new Nueve());
        Carta cartaCarta5 = new Carta(new Pica() ,new Ocho());
        int primerValorEsperado = 15;
        int segundoValorEsperado = 30;
        int tercerValorEsperado = 45;
        int cuartoValorEsperado = 60;
        int quintoValorEsperado = 1236;

        // Act y Assert
        //!!Multiples Assert -> Preguntar profes si esta bien
        jugador.seleccionarCarta(cartaCarta1);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntos();
        assertEquals(primerValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta2);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntos();
        assertEquals(segundoValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta3);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntos();
        assertEquals(tercerValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta4);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntos();
        assertEquals(cuartoValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta5);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntos();
        assertEquals(quintoValorEsperado,valorObtenido);
    }
}
 /*
    @Test
  public void test06SeAplicaTarotX10PuntosYSeCalulaCorrectamenteElPutntaje(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta cartaCarta1 = new Carta(new Pica() ,new As());
        Carta cartaCarta2 = new Carta(new Corazon() ,new As());
        Carta cartaCarta3 = new Carta(new Pica() ,new Jota());
        Carta cartaCarta4 = new Carta(new Corazon() ,new Jota());
        Carta cartaCarta5 = new Carta(new Pica() ,new Diez());
        Tarot tarotPuntosX10 = new Tarot(10, 0);
        int valorEsperado = 122;

        tarotPuntosX10.cambiarPuntaje(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);
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
        Tablero tablero = new Tablero(jugador);
        Carta cartaCarta1 = new Carta(new Pica() ,new As());
        Carta cartaCarta2 = new Carta(new Corazon() ,new As());
        Carta cartaCarta3 = new Carta(new Pica() ,new Reina());
        Carta cartaCarta4 = new Carta(new Pica() ,new Jota());
        Carta cartaCarta5 = new Carta(new Pica() ,new Diez());
        Tarot taroMultiplicadorX6 = new Tarot(0, 6);
        int valorEsperado = 256;

        taroMultiplicadorX6.cambiarMultiplicador(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

*/

}
