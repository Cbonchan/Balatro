package Modelo.Unitarios;

import Modelo.Juego.*;
import Modelo.Jugador.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Poker;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

public class TestTablero {

    @Test
    public void test01JugarManoDevuelvePuntajeCorrecto() {
        Mano mano = new Mano();
        Tablero tablero = new Tablero(new Jugador(mano));
        Poker cartaPoker1 = new Poker(new Diamante() ,new Reina());
        Poker cartaPoker2 = new Poker(new Pica() ,new Reina());

        int puntajeEsperado = 60;
        mano.agregarCarta(cartaPoker1);
        mano.agregarCarta(cartaPoker2);

        int puntaje = tablero.jugarMano(mano);
        assertEquals(puntajeEsperado, puntaje);

    }
}
