package Modelo.TestUnitarios.TestSistemaCartas.TestJokers;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MultiplicacionMult;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.SumarPuntaje;
import Modelo.Usuario.Mano;
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
    public void test01PorJugadaQueSumaCienALosChipsDeLaJugada() {
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
    public void test02PorJugadaQueMultiplicaMultiplicadorCorrectamente() {

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
    public void test03UnoEnSuma100PuntosALosChipsCorrectamente(){
        // Arrange
        int puntos = 0;
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(1)).thenReturn(0);

        Mano mano = new Mano();
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        Carta carta1 = new Carta(new Diamante() ,new Rey());

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        UnoEn joker = new UnoEn("Test03", "+100 chips", 100, new Multiplicador(1),
                1, new AumentarChips(), mockRandom);
        int esperado = 260;

        // Act
        joker.activar(mano, "1 En");

        //Assert
        int resultado = mano.calcularPuntaje();



        assertEquals(esperado,resultado);
    }

    @Test
    public void test04UnoEnSuma100PuntosAlPuntajeCorrectamente(){
        // Arrange

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(1)).thenReturn(0);

        Mano mano = new Mano();
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        Carta carta1 = new Carta(new Diamante() ,new Rey());

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        UnoEn joker = new UnoEn("Test03", "+100 al puntaje", 100, new Multiplicador(1),
                1, new SumarPuntaje(), mockRandom);
        int esperado = 160;

        // Act
        joker.activar(mano, "1 En");
        //Assert
        int resultado = mano.calcularPuntaje();



        assertEquals(esperado,resultado);
    }



    @Test
    public void test05DescarteSuma10PuntosALosChipsCorrectamente(){

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
    public void test06CombinacionSeAplicaCorrectamente() {

        // Arrange

        Mano mano = new Mano();
        int puntos = 0;
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(1)).thenReturn(0);


        Carta carta1 = new Carta(new Diamante() ,new Diez()); // Chips 5 Mult. 1

        mano.agregarCarta(carta1);


        UnoEn jokerUnoEn = new UnoEn("Test03", "+100 al puntaje", 100, new Multiplicador(1),
                1, new SumarPuntaje(), mockRandom);

        PorJugada jokerPorJugada = new PorJugada("Test02", "x4", 1, new Multiplicador(4),
                "carta alta", new MultiplicacionMult() );

        ArrayList<Activable> subcomodines = new ArrayList<>();
        subcomodines.add(jokerPorJugada);
        subcomodines.add(jokerUnoEn);

        Combinacion joker = new Combinacion("Test06", "+10 fichas", subcomodines);
        int esperado = 160;
        // Act
        joker.activar(mano, "Mano Jugada"); // 100 pts | Chips 5 y Mult 1
        joker.activar(mano, "1 En"); // 100 pts | Chips 5 y Mult 4

        int resultado = mano.calcularPuntaje(); // 100 | Chips 15 y Mult 4 -> 60 + 100

        //Assert


        assertEquals(esperado, resultado);




    }

    @Test
    public void test07AlPuntajeSumaAlPuntajeCorrectamente(){

        // Arrange
        int incrementador = 10;
        Mano mano = new Mano();
        Carta carta2 = new Carta(new Trebol() ,new Rey());
        Carta carta1 = new Carta(new Diamante() ,new Rey());
        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);


        AlPuntaje joker = new AlPuntaje("Test05", "+10 fichas", incrementador,
                new Multiplicador(1), "par", new SumarPuntaje());


        int esperado = 70;

        // Act
        joker.activar(mano, "Sin contexto");
        //Assert
        int resultado = mano.calcularPuntaje();



        assertEquals(esperado,resultado);
    }

}
