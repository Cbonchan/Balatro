package Modelo.Unitarios;

import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.CartaPoker;

import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;



public class TestCartaPoker {

    @Test
    public void test01CartaPokerCalculaPuntuacionAgregado() {
        CartaPoker cartaPoker = new CartaPoker(new Diamante() ,new Reina());
        CartaPoker cartaPoker2 = new CartaPoker(new Diamante() ,new As());
        int valorAgregado = 0;
        int valorEsperado = 21;
        valorAgregado = cartaPoker.sumarValorAgregadoPuntuacion(valorAgregado);
        valorAgregado = cartaPoker2.sumarValorAgregadoPuntuacion(valorAgregado);

        assertEquals(valorEsperado, valorAgregado);

    }
    @Test
    public void test02CartaPokerCalculaMultiplicadorAgregado() {
        CartaPoker cartaPoker = new CartaPoker(new Diamante(), new Reina());
        CartaPoker cartaPoker2 = new CartaPoker(new Diamante(), new As());
        int valorAgregado = 0;
        int valorEsperado = 0;
        valorAgregado = cartaPoker.sumarValorAgregadoMultiplicador(valorAgregado);
        valorAgregado = cartaPoker2.sumarValorAgregadoMultiplicador(valorAgregado);

        assertEquals(valorEsperado, valorAgregado);
    }
}
