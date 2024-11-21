package Modelo.Unitarios;

import Modelo.Juego.Tablero;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.SistemaCartas.Joker.Jokers.Descarte;
import Modelo.SistemaCartas.Joker.Jokers.JokerGenerico;
import Modelo.SistemaCartas.Joker.Jokers.JokerPorJugada;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoDescarte;
import  org.junit.Test;
import Modelo.SistemaCartas.Joker.Jokers.MasCien;
import Modelo.SistemaCartas.Poker.Figura.Rey;
import Modelo.SistemaCartas.Poker.Palo.Diamante;
import Modelo.SistemaCartas.Poker.Palo.Trebol;
import Modelo.SistemaCartas.Poker.Poker;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestJoker {


    @Test
    public void test01CrearJokerQueSumaCienDevuelve100() {


        MasCien joker = new MasCien("Prueba", "+100", 100, 1);

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


        MasCien joker = new MasCien("Prueba", "+100", 7, 1);

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
    public void test04ComodinDeDescarteSuma10PuntosALosChipsCorrectamente(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());

        Descarte jokerDescarte = new Descarte("Test", "Descarte", 10, 1);

        tablero.agregarJoker(jokerDescarte);

        jugador.seleccionarCarta(cartaPoker1);

        tablero.descarteMano(mano);

        // Act
        int valorEsperado = 15;
        int valorObtenido = jugador.obtenerChips();

        // Assert

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test05ComodinPorJugadaParSuma100ALosChipsCorrectamente(){

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        JokerPorJugada joker = new JokerPorJugada("Test", "Test",100, 1, "par");

        Poker cartaPoker1 = new Poker(new Diamante() ,new Rey());
        Poker cartaPoker2 = new Poker(new Trebol() ,new Rey());

        jugador.seleccionarCarta(cartaPoker1);
        jugador.seleccionarCarta(cartaPoker2);

        joker.activar(jugador);
        int valorEsperado =  110;
        int valorObtenido = jugador.obtenerChips();

        assertEquals(valorEsperado,valorObtenido);
    }


}

