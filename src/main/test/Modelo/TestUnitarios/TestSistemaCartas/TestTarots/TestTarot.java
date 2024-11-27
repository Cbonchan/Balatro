package Modelo.TestUnitarios.TestSistemaCartas.TestTarots;

import Modelo.Juego.Tablero;
import Modelo.SistemaCartas.Activables.Tarot.MejoraCarta;
import Modelo.SistemaCartas.Activables.Tarot.MejoraJugada;
import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Figura.Rey;
import Modelo.SistemaCartas.Poker.Palo.Diamante;
import Modelo.Usuario.Jugador;
import Modelo.Usuario.Mano;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTarot {
    @Test
    public void test01tarotCambiaLosPuntosDeUnaCartaA50() {

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta carta1 = new Carta(new Diamante() ,new Rey());
        MejoraCarta cartaPiedra = new MejoraCarta("carta piedra", "el puntaje pasa a ser 50", 50, 1);

        tablero.agregarTarot(cartaPiedra);

        tablero.seleccionarTarot(cartaPiedra);
        jugador.seleccionarCarta(carta1);
        tablero.jugarTarot();

        int valorEsperado = 50;
        int valorObtenido = carta1.getValorNumChips();

        assertEquals(valorObtenido,valorEsperado);
    }

    @Test
    public void test02tarotCambiaElMultiplicadorDeUnaCartaA2() {

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta carta1 = new Carta(new Diamante() ,new Rey());
        MejoraCarta cartaVidrio = new MejoraCarta("carta vidrio", "el multiplicador pasa a ser 2", 1, 2);

        tablero.agregarTarot(cartaVidrio);

        tablero.seleccionarTarot(cartaVidrio);
        jugador.seleccionarCarta(carta1);

        tablero.jugarTarot();
        jugador.jugar(tablero);

        int valorEsperado = 30;
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorObtenido,valorEsperado);
    }

    @Test
    public void test03tarotMejoraLaManoHighCardSegunLosParametrosDados() {

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta carta1 = new Carta(new Diamante() ,new Rey());
        MejoraJugada ElTonto = new MejoraJugada("el tonto", "mejora la mano HighCard", 10, 2, "carta alta");

        tablero.agregarTarot(ElTonto);

        tablero.seleccionarTarot(ElTonto);
        jugador.seleccionarCarta(carta1);

        tablero.jugarTarot();
        jugador.jugar(tablero);

        int valorEsperado = 75;
        int valorObtenido = jugador.getPuntaje();

        assertEquals(valorObtenido,valorEsperado);
    }
}
