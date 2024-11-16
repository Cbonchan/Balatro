package Modelo.Unitarios;


import Modelo.Jugador.*;


import  org.junit.Test;
import  static  org.junit.jupiter.api.Assertions.*;

public class TestMazo {

    @Test
    public void test01MazoSeCreaCon52Cartas(){
        Mazo mazo = new Mazo();
        assertEquals(52, mazo.getCartasDisponibles());
    }

    @Test
    public void test02MazoTieneMenosCartasLuegoDeRepartirAJugador(){
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador(new Mano());
        mazo.repartirCartas(jugador);
        assertEquals(44, mazo.getCartasDisponibles());
    }
}
