package Modelo.Unitarios;

import Modelo.Juego.Tablero;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.SistemaCartas.Joker.Jokers.*;
import Modelo.SistemaCartas.Joker.Jokers.Descarte;
import Modelo.SistemaCartas.Joker.Jokers.PorJugada;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.ActivacionAleatoria;
import  org.junit.Test;
import Modelo.SistemaCartas.Joker.Jokers.Sumador;
import Modelo.SistemaCartas.Poker.Figura.Rey;
import Modelo.SistemaCartas.Poker.Palo.Diamante;
import Modelo.SistemaCartas.Poker.Palo.Trebol;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestJoker {


    @Test
    public void test01CrearJokerQueSumaCienDevuelve100() {


        Sumador joker = new Sumador("Prueba", "+100", 100, 1);

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);

        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Rey());
        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);

        joker.activar(jugador);

        int esperado = 100;
        int obtenido = jugador.getPuntaje();

        assertEquals(esperado,obtenido);

    }

    @Test
    public void test02CrearJokerQueSuma7Devuelve7() {


        Sumador joker = new Sumador("Prueba", "+100", 7, 1);

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);

        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Rey());
        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);

        joker.activar(jugador);

        int esperado = 7;
        int obtenido = jugador.getPuntaje();

        assertEquals(esperado,obtenido);

    }

    @Test
    public void test03ComodinAleatorioSuma100PuntosALosChipsCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(3)).thenReturn(0);

        ActivacionAleatoria efecto = new ActivacionAleatoria(1, mockRandom);



        unoEn joker = new unoEn("loco", "Joker Aleatorio", 100,
                1, 3, mockRandom);


        joker.activar(jugador);
        int respuestaEsperada = 100;
        int respuestaObtenido = jugador.getPuntaje();
        assertEquals(respuestaEsperada,respuestaObtenido);

    }

    @Test
    public void test07ComodinAleatorioNoSuma100PuntosALosChipsCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(3)).thenReturn(1);

        ActivacionAleatoria efecto = new ActivacionAleatoria(1, mockRandom);



        unoEn joker = new unoEn("loco", "Joker Aleatorio", 100,
                1, 3, mockRandom);


        joker.activar(jugador);
        int respuestaEsperada = 0;
        int respuestaObtenido = jugador.getPuntaje();
        assertEquals(respuestaEsperada,respuestaObtenido);

    }


    @Test
    public void test04ComodinDeDescarteSuma10PuntosALosChipsCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Rey());

        Descarte jokerDescarte = new Descarte("Test", "Descarte", 10, 1);

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
    public void test05ComodinPorJugadaParSuma100ALosChipsCorrectamente(){

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        PorJugada joker = new PorJugada("Test", "Test",100, 1, "par");

        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Rey());

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);

        joker.activar(jugador);
        int valorEsperado =  110;
        int valorObtenido = jugador.obtenerChips();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test06ComodinMultipleSeAplicaCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);

        PorJugada jokerJugada = new PorJugada("Test", "Test",100, 1, "par");
        Sumador jokerSumador = new Sumador("Prueba", "+100", 100, 1);
        unoEn jokerAleatorio = new unoEn("Prueba", "+100", 100, 1,1);
        ArrayList<Joker> listaJokers = new ArrayList<Joker>();
        listaJokers.add(jokerAleatorio);
        listaJokers.add(jokerSumador);
        listaJokers.add(jokerJugada);
        Combinacion jokerMultiple = new Combinacion("test", "es una comb", listaJokers);

        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Rey());
        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);

        jokerMultiple.activar(jugador);
        jugador.jugar(tablero);

        int esperado = 460;
        int obtenido = jugador.getPuntaje();

        assertEquals(esperado,obtenido);

    }


}
