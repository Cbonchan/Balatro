package Modelo.CasosDeUsos;

// Importaciones
import Modelo.Juego.*;
import Modelo.Jugador.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.CartaPoker;
import Modelo.SistemaCartas.Jugadas.*;
import Modelo.SistemaCartas.Tarot.*;
import Modelo.SistemaPuntaje.*;

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
    public void test04LaManoPairSeCalculaCorrectamente(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Diamante() ,new Rey());
        CartaPoker cartaPoker2 = new CartaPoker(new Trebol() ,new Reina());
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
    public void test05LaManoSeCalculaEnElOrdenCorrecto(){
        // Arrange
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Pica() ,new Reina());
        CartaPoker cartaPoker2 = new CartaPoker(new Pica() ,new Jota());
        CartaPoker cartaPoker3 = new CartaPoker(new Pica() ,new Diez());
        CartaPoker cartaPoker4 = new CartaPoker(new Pica() ,new Nueve());
        CartaPoker cartaPoker5 = new CartaPoker(new Pica() ,new Ocho());
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
        CartaPoker cartaPoker1 = new CartaPoker(new Pica() ,new As());
        CartaPoker cartaPoker2 = new CartaPoker(new Corazon() ,new As());
        CartaPoker cartaPoker3 = new CartaPoker(new Pica() ,new Jota());
        CartaPoker cartaPoker4 = new CartaPoker(new Corazon() ,new Jota());
        CartaPoker cartaPoker5 = new CartaPoker(new Pica() ,new Diez());
        Tarot tarotPuntosX10 = new Puntosx10();
        int valorEsperado = 122;

        tarotPuntosX10.usar(cartaPoker1);
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
        CartaPoker cartaPoker1 = new CartaPoker(new Pica() ,new As());
        CartaPoker cartaPoker2 = new CartaPoker(new Corazon() ,new As());
        CartaPoker cartaPoker3 = new CartaPoker(new Pica() ,new Reina());
        CartaPoker cartaPoker4 = new CartaPoker(new Pica() ,new Jota());
        CartaPoker cartaPoker5 = new CartaPoker(new Pica() ,new Diez());
        Tarot taroMultiplicadorX6 = new Multiplicadorx6();
        int valorEsperado = 256;

        taroMultiplicadorX6.usar(cartaPoker1);
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
