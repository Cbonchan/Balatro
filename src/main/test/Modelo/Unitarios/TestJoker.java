package Modelo.Unitarios;


import Modelo.Juego.Tablero;
import Modelo.Jugador.Mano;
import Modelo.SistemaCartas.Joker.Joker;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Palo.Corazon;
import Modelo.SistemaCartas.Poker.Palo.Diamante;
import Modelo.SistemaCartas.Poker.Palo.Pica;
import Modelo.SistemaCartas.Poker.Palo.Trebol;
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.Jugador.Jugador;
import org.junit.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestJoker {


    @Test
    public void test01ComodinNormalSuma8AlMultiplicadorCorrectamente(){

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        EfectoAutomatico efecto = new EfectoAutomatico();

        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Rey());
        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);

        Joker joker = new Joker(1, "Joker multiplicador",
                "Suma 8 al multiplicador",8, efecto);

        joker.activar(jugador);
        int valorEsperado =  10;
        int valorObtenido = jugador.obtenerMultiplicador();

        assertEquals(valorEsperado,valorObtenido);
    }



    @Test
    public void test02ComodinDeDescarteSuma10PuntosALosChipsCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Rey());

        Joker jokerDescarte = new Joker(10, "Descarte", "Te hace el amor", 1, new EfectoDescarte());

        tablero.agregarJoker(jokerDescarte);

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);

        tablero.descarteMano(mano);

        // Act
        int valorEsperado = 10;
        int valorObtenido = jugador.obtenerChips();

        // Assert

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test03ComodinPorJugadaEscaleraAumentaElMultiplicadorCorrectamente(){

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        EfectoPorJugada efecto = new EfectoPorJugada("escalera");

        Poker cartaPoker1 = new Poker(new Diamante() ,new Tres());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Cuatro());
        Poker cartaPoker3 = new Poker(new Diamante() ,new Cinco());
        Poker cartaPoker4 = new Poker(new Pica() ,new Seis());
        Poker cartaPoker5 = new Poker(new Corazon() ,new Siete());

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);
        jugador.seleccionarCarta(cartaPoker3);
        jugador.seleccionarCarta(cartaPoker4);
        jugador.seleccionarCarta(cartaPoker5);

        Joker joker = new Joker(1, "Joker multiplicador Escalera",
                "x3 al multiplicador si hay escalera",3, efecto);

        joker.activarPorJugada(jugador);
        int valorEsperado =  12;
        int valorObtenido = jugador.obtenerMultiplicador();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test04ComodinSeAutodestruyeCorrectamenteDespuesDeActivarse(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(1)).thenReturn(0);

        Efecto efecto = new EfectoAutodestruccion(1, mockRandom);



        Joker joker = new Joker(1, "Joker Autodestructivo", "Se autodestruye automáticamente",
                3, efecto);


        joker.activar(jugador);
        boolean respuestaEsperada = false;
        boolean respuestaObtenido = efecto.fueActivado();
        assertEquals(respuestaEsperada,respuestaObtenido);

    }





}
