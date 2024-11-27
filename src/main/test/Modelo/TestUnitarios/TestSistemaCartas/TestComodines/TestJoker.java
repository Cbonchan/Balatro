package Modelo.TestUnitarios.TestSistemaCartas.TestComodines;

import Modelo.Juego.Tablero;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.Usuario.Jugador;
import Modelo.Usuario.Mano;
import Modelo.deprecated.ActivacionAleatoria;
import  org.junit.Test;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Activables.Joker.*;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestJoker {


    @Test
    public void test01CrearJokerQueSumaCienDevuelve100() {


        SumadorPuntaje joker = new SumadorPuntaje("Prueba", "+100", 100, 1);

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);

        Carta carta1 = new Carta(new Diamante() ,new Rey());
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        joker.activar(jugador);

        int esperado = 100;
        int obtenido = jugador.getPuntaje();

        assertEquals(esperado,obtenido);

    }

    @Test
    public void test02CrearJokerQueSuma7Devuelve7() {


        SumadorPuntaje joker = new SumadorPuntaje("Prueba", "+100", 7, 1);

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);

        Carta carta1 = new Carta(new Diamante() ,new Rey());
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        joker.activar(jugador);

        int esperado = 7;
        int obtenido = jugador.getPuntaje();

        assertEquals(esperado,obtenido);

    }

    @Test
    public void test03ComodinAleatorioSuma100PuntosALosChipsCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Carta carta1 = new Carta(new Diamante() ,new Rey());
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(3)).thenReturn(0);


        unoEn joker = new unoEn("loco", "Joker Aleatorio", 100,
                1, 3, mockRandom);


        joker.activar(jugador);
        jugador.jugar(tablero);
        int respuestaEsperada = 260;
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
        Carta carta1 = new Carta(new Diamante() ,new Rey());
        Carta carta2 = new Carta(new Trebol() ,new Rey());

        Descarte jokerDescarte = new Descarte("Test", "Descarte", 10, 1);

        tablero.agregarJoker(jokerDescarte);

        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        tablero.descarteMano(mano);

        // Act
        int valorEsperado = 10;
        int valorObtenido = jugador.getPuntaje();

        // Assert

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test05ComodinPorJugadaParSuma100ALosChipsCorrectamente(){

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        PorJugada joker = new PorJugada("Test", "Test",100, 1, "par");

        Carta carta1 = new Carta(new Diamante() ,new Rey());
        Carta carta2 = new Carta(new Trebol() ,new Rey());

        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

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
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(3)).thenReturn(0);

        PorJugada jokerJugada = new PorJugada("Test", "Test",100, 1, "par");
        SumadorPuntaje jokerSumadorPuntaje = new SumadorPuntaje("Prueba", "+100", 100, 1);
        unoEn jokerAleatorio = new unoEn("Prueba", "+100", 100, 1,3, mockRandom);

        ArrayList<Activable> listaJokers = new ArrayList<Activable>();
        listaJokers.add(jokerJugada);
        listaJokers.add(jokerAleatorio);
        listaJokers.add(jokerSumadorPuntaje);

        Combinacion jokerMultiple = new Combinacion("test", "es una comb", listaJokers);

        Carta carta1 = new Carta(new Diamante() ,new Rey());
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        jokerMultiple.activar(jugador);
        jugador.jugar(tablero);

        int esperado = 560;
        int obtenido = jugador.getPuntaje();

        assertEquals(esperado,obtenido);

    }


}
