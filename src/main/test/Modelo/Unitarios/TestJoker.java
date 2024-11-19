package Modelo.Unitarios;


import Modelo.Juego.Tablero;
import Modelo.Jugador.Mano;
import Modelo.SistemaCartas.Joker.Joker;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.Efecto;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoDescarte;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoJugada;
import Modelo.SistemaCartas.Jugadas.Jugada;
import Modelo.SistemaCartas.Poker.Figura.Dos;
import Modelo.SistemaCartas.Poker.Figura.Jota;
import Modelo.SistemaCartas.Poker.Figura.Rey;
import Modelo.SistemaCartas.Poker.Figura.Siete;
import Modelo.SistemaCartas.Poker.Palo.Corazon;
import Modelo.SistemaCartas.Poker.Palo.Diamante;
import Modelo.SistemaCartas.Poker.Palo.Pica;
import Modelo.SistemaCartas.Poker.Palo.Trebol;
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.SistemaPuntaje.Puntaje;
import org.jetbrains.annotations.TestOnly;
import Modelo.Jugador.Jugador;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJoker {


    @Test
    public void test01ComodinNormalSuma8AlMultiplicadorCorrectamente(){

        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        EfectoJugada efecto = new EfectoJugada();

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


}
