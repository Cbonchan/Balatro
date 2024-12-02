package Modelo.TestUnitarios.TestSistemaCartas.TestComodines;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MultiplicacionMult;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.SumarPuntaje;
import Modelo.Usuario.Mano;
import Modelo.Usuario.Jugador;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.AumentarChips;

import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;

import Modelo.SistemaCartas.Activables.Joker.*;
import Modelo.SistemaCartas.Activables.Activable;

import  org.junit.Test;
import java.util.Random;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestJoker {


    @Test
    public void test01JokerPorJugadaQueSumaCienALosChipsDeLaJugada() {
        // Arrange
        int puntos = 0;
        Mano mano = new Mano();
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        Carta carta1 = new Carta(new Diamante() ,new Rey());

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        PorJugada joker = new PorJugada("Test01", "+100", 100, new Multiplicador(1), "par", new AumentarChips() );
        int esperado = 260;

        // Act
        joker.activar(mano, "Mano Jugada");

        // Assert
        int resultado = mano.calcularPuntaje();
        assertEquals(esperado,resultado);

    }



    @Test
    public void test02JokerPorJugadaQueMultiplicaMultiplicadorCorrectamente() {

        // Arrange
        int puntos = 0;
        Mano mano = new Mano();
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        Carta carta1 = new Carta(new Diamante() ,new Rey());

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        PorJugada joker = new PorJugada("Test02", "x4", 100, new Multiplicador(4), "par", new MultiplicacionMult() );
        int esperado = 240;

        // Act
        joker.activar(mano, "Mano Jugada");

        //Assert
        int resultado = mano.calcularPuntaje();
        assertEquals(esperado,resultado);

    }


    @Test
    public void test03JokerUnoEnSuma100PuntosALosChipsCorrectamente(){
        // Arrange
        int puntos = 0;
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(1)).thenReturn(0);

        Mano mano = new Mano();
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        Carta carta1 = new Carta(new Diamante() ,new Rey());

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        unoEn joker = new unoEn("Test03", "+100 chips", 100, new Multiplicador(1),
                1, new AumentarChips(), mockRandom);
        int esperado = 260;

        // Act
        joker.activar(mano, "1 En");

        //Assert
        int resultado = mano.calcularPuntaje();
        assertEquals(esperado,resultado);
    }

    @Test
    public void test04JokerUnoEnSuma100PuntosAlPuntajeCorrectamente(){
        // Arrange

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(1)).thenReturn(0);

        Mano mano = new Mano();
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        Carta carta1 = new Carta(new Diamante() ,new Rey());

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        unoEn joker = new unoEn("Test03", "+100 al puntaje", 100, new Multiplicador(1),
                1, new SumarPuntaje(), mockRandom);
        int esperado = 160;

        // Act
        joker.activar(mano, "1 En");
        //Assert
        int resultado = mano.calcularPuntaje();


        assertEquals(esperado,resultado);
    }



    @Test
    public void test05ComodinDeDescarteSuma10PuntosALosChipsCorrectamente(){

        // Arrange
        int incrementador = 10;
        Mano mano = new Mano();
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        Carta carta1 = new Carta(new Diamante() ,new Rey());

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        Descarte joker = new Descarte("Test05", "+10 fichas", incrementador,
                new Multiplicador(1), new AumentarChips());


        int esperado = 80;

        // Act
        joker.activar(mano, "Descarte");
        //Assert
        int resultado = mano.calcularPuntaje();


        assertEquals(esperado,resultado);
    }



    @Test
    public void test06ComodinMultipleSeAplicaCorrectamente() {

        // Arrange
        int esperado = 0;
        Mano mano = new Mano();
        int puntos = 0;
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(1)).thenReturn(0);

        Carta carta2 = new Carta(new Trebol() ,new Rey());
        Carta carta1 = new Carta(new Diamante() ,new Rey());

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        unoEn jokerUnoEn = new unoEn("Test03", "+100 al puntaje", 100, new Multiplicador(1),
                1, new SumarPuntaje(), mockRandom);

        PorJugada jokerPorJugada = new PorJugada("Test02", "x4", 100, new Multiplicador(4),
                "par", new MultiplicacionMult() );

        ArrayList<Activable> subcomodines = new ArrayList<>();
        subcomodines.add(jokerPorJugada);
        subcomodines.add(jokerUnoEn);

        Combinacion joker = new Combinacion("Test06", "+10 fichas", subcomodines);

        // Act
        joker.activar(mano, "Combinacion");

        int resultado = mano.calcularPuntaje();

        //Assert
        assertEquals(esperado, resultado);

        /*


        PorJugada jokerJugada = new PorJugada("Test", "Test", 100, 1, "par");
        SumadorPuntaje jokerSumadorPuntaje = new SumadorPuntaje("Prueba", "+100", 100, 1);
        unoEn jokerAleatorio = new unoEn("Prueba", "+100", 100, 1, 3, mockRandom);

        ArrayList<Activable> listaJokers = new ArrayList<Activable>();
        listaJokers.add(jokerJugada);
        listaJokers.add(jokerAleatorio);
        listaJokers.add(jokerSumadorPuntaje);

        Combinacion jokerMultiple = new Combinacion("test", "es una comb", listaJokers);

        Carta carta1 = new Carta(new Diamante(), new Rey());
        Carta carta2 = new Carta(new Trebol(), new Rey());
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        jokerMultiple.activar(mano, puntos, "Jugada");
        //jugador.jugar(tablero);

        int esperado = 560;
        int obtenido = jugador.getPuntos();

        assertEquals(esperado, obtenido);
         */


    }
    /*
    @Test
    public void test06ComodinPorJugadaParSuma100ALosChipsCorrectamente(){

        Mano mano = new Mano();
        Jugador jugador = new Jugador();
        int puntos = 0;
        PorJugada joker = new PorJugada("Test", "Test",100, 1, "par");

        Carta carta1 = new Carta(new Diamante() ,new Rey());
        Carta carta2 = new Carta(new Trebol() ,new Rey());

        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        joker.activar(mano, puntos, "Jugada");
        int valorEsperado =  110;
        int valorObtenido = jugador.obtenerChips();

        assertEquals(valorEsperado,valorObtenido);
    }

    }

*/
}
