package Modelo.TestUnitarios.Unitarios;

// Importaciones
import Modelo.Usuario.*;
import Modelo.SistemaCartas.Cartas.Palo.*;
import Modelo.SistemaCartas.Cartas.Figura.*;
import Modelo.SistemaCartas.Cartas.Carta;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

public class TestMano {


    @Test
    public void test01ManoEsJugadaValida() {
        Mano mano = new Mano();
        Carta cartaCarta1 = new Carta(new Diamante() ,new Reina());
        Carta cartaCarta2 = new Carta(new Pica() ,new Reina());
        int valorEsperado = 60;
        mano.agregarCarta(cartaCarta1);
        mano.agregarCarta(cartaCarta2);
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
        Carta cartaCarta1 = new Carta(new Diamante() ,new Reina());
        Carta cartaCarta2 = new Carta(new Pica() ,new Reina());
        int valorEsperado1 = 15;
        int valorEsperado2 = 0;

        mano1.agregarCarta(cartaCarta1);
        mano2.agregarCarta(cartaCarta2);

        mano2.vaciarMano();

        assertEquals(valorEsperado1, mano1.calcularPuntaje());
        assertEquals(valorEsperado2, mano2.calcularPuntaje());
    }

    @Test
    public void test04ManoEsJugadaParValida(){
        Mano mano = new Mano();
        Carta cartaCarta1 = new Carta(new Diamante() ,new Reina());
        Carta cartaCarta2 = new Carta(new Pica() ,new Rey());
        Carta cartaCarta3 = new Carta(new Pica() ,new Reina());
        int valorEsperado = 60;

        mano.agregarCarta(cartaCarta1);
        mano.agregarCarta(cartaCarta2);
        mano.agregarCarta(cartaCarta3);

        assertEquals(valorEsperado, mano.calcularPuntaje());
    }
}

