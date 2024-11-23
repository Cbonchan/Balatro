package Modelo.Unitarios;

// Importaciones
import Modelo.Jugador.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Poker;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

public class TestMano {


    @Test
    public void test01ManoEsJugadaValida() {
        Mano mano = new Mano();
        Poker cartaPoker1 = new Poker(new Diamante() ,new Reina());
        Poker cartaPoker2 = new Poker(new Pica() ,new Reina());
        int valorEsperado = 60;
        mano.agregarCarta(cartaPoker1);
        mano.agregarCarta(cartaPoker2);
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test02calcularPuntajeConManoVacia() {
        Mano mano = new Mano();
        int valorEsperado = 0;
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test03VaciarMano() {
        Mano mano1 = new Mano();
        Mano mano2 = new Mano();
        Poker cartaPoker1 = new Poker(new Diamante() ,new Reina());
        Poker cartaPoker2 = new Poker(new Pica() ,new Reina());
        int valorEsperado1 = 15;
        int valorEsperado2 = 0;

        mano1.agregarCarta(cartaPoker1);
        mano2.agregarCarta(cartaPoker2);

        mano2.vaciarMano();

        assertEquals(valorEsperado1, mano1.calcularPuntaje());
        assertEquals(valorEsperado2, mano2.calcularPuntaje());
    }
}

