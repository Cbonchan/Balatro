package Modelo.Unitarios;

import Modelo.Juego.*;
import Modelo.Jugador.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.CartaPoker;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

public class TestTablero {

    @Test
    public void test01JugarManoDevuelvePuntajeCorrecto() {
        Mano mano = new Mano();
        Tablero tablero = new Tablero();
        CartaPoker cartaPoker1 = new CartaPoker(new Diamante() ,new Reina());
        CartaPoker cartaPoker2 = new CartaPoker(new Pica() ,new Reina());

        int puntajeEsperado = 60;
        mano.agregarCarta(cartaPoker1);
        mano.agregarCarta(cartaPoker2);

        int puntaje = tablero.jugarMano(mano);
        assertEquals(puntajeEsperado, puntaje);

    }
}
