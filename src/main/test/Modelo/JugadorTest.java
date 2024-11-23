package Modelo;

import Modelo.Juego.Tablero;
import Modelo.Usuario.Jugador;
import Modelo.Usuario.Mano;
import Modelo.Usuario.Mazo;
import Modelo.SistemaCartas.Poker.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Tarot.Tarot;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

// Testear comportamiento no implementacion (rehacer)

public class JugadorTest {

    @Test
    public void test01CantidadDeCartasCorrectas(){
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
    public void test02CartasSuficientesEnMazo(){
        // Arrange
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 52;

        // Act y Assert
        assertEquals(cantidadDeCartasEsperadas, mazo.getCartasDisponibles(), "El mazo debe tener 52 cartas una vez inicializado");
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
        int valorObtenido = jugador.getPuntaje();

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
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test05LaManoThreeOfAKindSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test06LaManoHighCardSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test07LaManoStraightSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test08LaManoFlushSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

   @Test
    public void test09LaManoFlushHouseSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test10LaManoFourOfAKindSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test11LaManoStraightFlushSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);

        // Act
        int valorObtenido = jugador.getPuntaje();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test12LaManoRoyalFLushSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
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
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test13SeAplicaTarotX6MultiplicadorYSeCalulaCorrectamenteElPutntaje(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta cartaCarta1 = new Carta(new Pica() ,new As());
        Carta cartaCarta2 = new Carta(new Corazon() ,new As());
        Carta cartaCarta3 = new Carta(new Pica() ,new Reina());
        Carta cartaCarta4 = new Carta(new Pica() ,new Jota());
        Carta cartaCarta5 = new Carta(new Pica() ,new Diez());
        Tarot taroMultiplicadorX6 = new Tarot(0,6);
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

    @Test
    public void test14SeAplicaTarotX10PuntosYSeCalulaCorrectamenteElPutntaje(){

        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta cartaCarta1 = new Carta(new Pica() ,new As());
        Carta cartaCarta2 = new Carta(new Corazon() ,new As());
        Carta cartaCarta3 = new Carta(new Pica() ,new Jota());
        Carta cartaCarta4 = new Carta(new Corazon() ,new Jota());
        Carta cartaCarta5 = new Carta(new Pica() ,new Diez());
        Tarot tarotPuntosX10 = new Tarot(10,0);
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
    public void test15LaManoSeCalculaEnElOrdenCorrecto(){
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

        //? Multiples Asserts -> Preguntar profes si esta bien
        jugador.seleccionarCarta(cartaCarta1);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();
        assertEquals(primerValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta2);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntaje();
        assertEquals(segundoValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta3);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntaje();
        assertEquals(tercerValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta4);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntaje();
        assertEquals(cuartoValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta5);
        jugador.jugar(tablero);
        valorObtenido = jugador.getPuntaje();
        assertEquals(quintoValorEsperado,valorObtenido);
    }

}



