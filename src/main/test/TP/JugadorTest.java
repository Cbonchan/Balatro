package TP;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

// Testear comportamiento no implementacion (rehacer)

public class JugadorTest {
    @Test
    public void test01CantidadDeCartasCorrectas(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Mazo mazo = new Mazo();

        mazo.repartirCartas(jugador);

        int cantidadDeCartasEsperadas = 8;
        assertEquals(cantidadDeCartasEsperadas, jugador.getCantidadCartas(), "El jugador debe tener 8 cartas después de repartir.");
    }

    @Test
    public void test02CartasSuficientesEnMazo(){
        Mazo mazo = new Mazo();
        int cantidadDeCartasEsperadas = 52;

        assertEquals(cantidadDeCartasEsperadas, mazo.getCantidadCartas(), "El mazo debe tener 52 cartas una vez inicializado");


    }

    @Test
    public void test03LaManoTwoPairSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Diamantes() ,new Q());
        CartaPoker cartaPoker2 = new CartaPoker(new Picas() ,new Q());
        CartaPoker cartaPoker3 = new CartaPoker(new Corazones() ,new Cinco());
        CartaPoker cartaPoker4 = new CartaPoker(new Picas() ,new Cinco());
        CartaPoker cartaPoker5 = new CartaPoker(new Treboles() ,new Dos());
        int valorEsperado = 100;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test04LaManoPairSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Diamantes() ,new K());
        CartaPoker cartaPoker2 = new CartaPoker(new Treboles() ,new K());
        CartaPoker cartaPoker3 = new CartaPoker(new Treboles() ,new Siete());
        CartaPoker cartaPoker4 = new CartaPoker(new Picas() ,new Dos());
        CartaPoker cartaPoker5 = new CartaPoker(new Corazones() ,new J());
        int valorEsperado = 60;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test05LaManoThreeOfAKindSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Corazones() ,new Ocho());
        CartaPoker cartaPoker2 = new CartaPoker(new Picas() ,new Ocho());
        CartaPoker cartaPoker3 = new CartaPoker(new Treboles() ,new Ocho());
        CartaPoker cartaPoker4 = new CartaPoker(new Treboles() ,new Dos());
        CartaPoker cartaPoker5 = new CartaPoker(new Diamantes() ,new Diez());
        int valorEsperado = 162;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test06LaManoHighCardSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Diamantes() ,new Q());
        CartaPoker cartaPoker2 = new CartaPoker(new Picas() ,new Siete());
        CartaPoker cartaPoker3 = new CartaPoker(new Corazones() ,new Cinco());
        CartaPoker cartaPoker4 = new CartaPoker(new Treboles() ,new Tres());
        CartaPoker cartaPoker5 = new CartaPoker(new Picas() ,new Diez());
        int valorEsperado = 15;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test07LaManoStraightSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Diamantes() ,new Tres());
        CartaPoker cartaPoker2 = new CartaPoker(new Treboles() ,new Cuatro());
        CartaPoker cartaPoker3 = new CartaPoker(new Diamantes() ,new Cinco());
        CartaPoker cartaPoker4 = new CartaPoker(new Picas() ,new Seis());
        CartaPoker cartaPoker5 = new CartaPoker(new Corazones() ,new Siete());
        int valorEsperado = 220;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test08LaManoFlushSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Treboles() ,new Siete());
        CartaPoker cartaPoker2 = new CartaPoker(new Treboles() ,new Cuatro());
        CartaPoker cartaPoker3 = new CartaPoker(new Treboles() ,new Q());
        CartaPoker cartaPoker4 = new CartaPoker(new Treboles() ,new As());
        CartaPoker cartaPoker5 = new CartaPoker(new Treboles() ,new Dos());
        int valorEsperado = 276;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

   /* @Test
    public void test09LaManoFlushHouseSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Corazones() ,new As());
        CartaPoker cartaPoker2 = new CartaPoker(new Picas() ,new As());
        CartaPoker cartaPoker3 = new CartaPoker(new Diamantes() ,new As());
        CartaPoker cartaPoker4 = new CartaPoker(new Diamantes() ,new K());
        CartaPoker cartaPoker5 = new CartaPoker(new Picas() ,new K());
        int valorEsperado = 372;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }
*/
    @Test
    public void test10LaManoFourOfAKindSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Diamantes() ,new Seis());
        CartaPoker cartaPoker2 = new CartaPoker(new Picas() ,new Seis());
        CartaPoker cartaPoker3 = new CartaPoker(new Corazones() ,new Seis());
        CartaPoker cartaPoker4 = new CartaPoker(new Treboles() ,new Seis());
        CartaPoker cartaPoker5 = new CartaPoker(new Diamantes() ,new Tres());
        int valorEsperado = 588;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test11LaManoStraightFlushSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Picas() ,new Q());
        CartaPoker cartaPoker2 = new CartaPoker(new Picas() ,new J());
        CartaPoker cartaPoker3 = new CartaPoker(new Picas() ,new Diez());
        CartaPoker cartaPoker4 = new CartaPoker(new Picas() ,new Nueve());
        CartaPoker cartaPoker5 = new CartaPoker(new Picas() ,new Ocho());
        int valorEsperado = 1176;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

 /*   @Test
    public void test12LaManoRoyalFLushSeCalculaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Picas() ,new As());
        CartaPoker cartaPoker2 = new CartaPoker(new Picas() ,new K());
        CartaPoker cartaPoker3 = new CartaPoker(new Picas() ,new Q());
        CartaPoker cartaPoker4 = new CartaPoker(new Picas() ,new J());
        CartaPoker cartaPoker5 = new CartaPoker(new Picas() ,new Diez());
        int valorEsperado = 1208;

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }*/

    @Test
    public void test13SeAplicaTarotX6MultiplicadorYSeCalulaCorrectamenteElPutntaje(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Picas() ,new As());
        CartaPoker cartaPoker2 = new CartaPoker(new Corazones() ,new As());
        CartaPoker cartaPoker3 = new CartaPoker(new Picas() ,new Q());
        CartaPoker cartaPoker4 = new CartaPoker(new Picas() ,new J());
        CartaPoker cartaPoker5 = new CartaPoker(new Picas() ,new Diez());
        Tarot taroMultiplicadorX6 = new TaroMultiplicadorX6();
        int valorEsperado = 256;

        taroMultiplicadorX6.usar(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test14SeAplicaTarotX10PuntosYSeCalulaCorrectamenteElPutntaje(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Picas() ,new As());
        CartaPoker cartaPoker2 = new CartaPoker(new Corazones() ,new As());
        CartaPoker cartaPoker3 = new CartaPoker(new Picas() ,new J());
        CartaPoker cartaPoker4 = new CartaPoker(new Corazones() ,new J());
        CartaPoker cartaPoker5 = new CartaPoker(new Picas() ,new Diez());
        Tarot tarotPuntosX10 = new TarotPuntosX10();
        int valorEsperado = 122;

        tarotPuntosX10.usar(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);
        jugador.jugar(tablero);
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorEsperado,valorObtenido);
    }


    @Test
    public void test15LaManoSeCalculaEnElOrdenCorrecto(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Picas() ,new Q());
        CartaPoker cartaPoker2 = new CartaPoker(new Picas() ,new J());
        CartaPoker cartaPoker3 = new CartaPoker(new Picas() ,new Diez());
        CartaPoker cartaPoker4 = new CartaPoker(new Picas() ,new Nueve());
        CartaPoker cartaPoker5 = new CartaPoker(new Picas() ,new Ocho());
        int primerValorEsperado = 15;
        int segundoValorEsperado = 30;
        int tercerValorEsperado = 45;
        int cuartoValorEsperado = 60;
        int quintoValorEsperado = 1236;

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
}



