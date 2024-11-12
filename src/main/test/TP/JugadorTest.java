package TP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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



}



