package Modelo.Unitarios;

import Modelo.Juego.Tablero;
import Modelo.Jugador.*;
import Modelo.SistemaCartas.Poker.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;

import  org.junit.Test;

import java.util.List;

import  static  org.junit.jupiter.api.Assertions.*;

public class TestDescarte {

    @Test
    public void test01descartoCartasYelJugadorTieneMenos() {
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);
        Poker carta1 = new Poker(new Corazon(), new As());
        Poker carta2 = new Poker(new Corazon(), new Dos());
        Poker carta3 = new Poker(new Corazon(), new Tres());
        Poker carta4 = new Poker(new Corazon(), new Cuatro());
        Poker carta5 = new Poker(new Corazon(), new Cinco());
        Poker carta6 = new Poker(new Corazon(), new Seis());
        Poker carta7 = new Poker(new Corazon(), new Siete());
        Poker carta8 = new Poker(new Corazon(), new Ocho());

        List<Poker> cartasAgregar = List.of(carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8);
        jugador.agregarCartas(cartasAgregar);
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        jugador.descartarMano(tablero);
        assertEquals(6, jugador.getCantidadCartas());
    }

    @Test
    public void test02pilaDeDescarteAumentaTamañoAlDescartar() {
        Mano mano = new Mano();
        Poker carta1 = new Poker(new Corazon(), new As());
        Poker carta2 = new Poker(new Corazon(), new Dos());
        PilaDescarte pilaDescarte = new PilaDescarte();

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        pilaDescarte.descartarMano(mano);

        assertEquals(1, pilaDescarte.cantidadManosDescartadas());
    }

    @Test
    public void test03reinsertarEnMazoAumentaElTamaño(){
        Mazo mazo = new Mazo();

        Mano mano = new Mano();
        Poker carta1 = new Poker(new Corazon(), new As());
        Poker carta2 = new Poker(new Corazon(), new Dos());
        PilaDescarte pilaDescarte = new PilaDescarte();

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        pilaDescarte.descartarMano(mano);
        pilaDescarte.reinsertarEnMazo(mazo);
        assertEquals(54, mazo.getCartasDisponibles());

    }

    @Test
    public void test04descartoAlJugarDescartaLasCartasJugadas(){
        Mano mano = new Mano();
        Poker carta1 = new Poker(new Corazon(), new As());
        Poker carta2 = new Poker(new Corazon(), new Dos());

        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero(jugador);

        jugador.agregarCartas(List.of(carta1, carta2));

        mano.agregarCarta(carta1);
        mano.agregarCarta(carta2);

        jugador.jugar(tablero);

        assertEquals(8, jugador.cartasFaltantes());

    }

    @Test
    public void test05seleccionarCartasDisminuyeLasDisponibles(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker carta1 = new Poker(new Corazon(), new As());
        Poker carta2 = new Poker(new Corazon(), new Dos());
        Poker carta3 = new Poker(new Corazon(), new Tres());
        Poker carta4 = new Poker(new Corazon(), new Cuatro());
        Poker carta5 = new Poker(new Corazon(), new Cinco());
        Poker carta6 = new Poker(new Corazon(), new Seis());
        Poker carta7 = new Poker(new Corazon(), new Siete());
        Poker carta8 = new Poker(new Corazon(), new Ocho());

        List<Poker> cartasAgregar = List.of(carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8);
        jugador.agregarCartas(cartasAgregar);
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        assertEquals(2, jugador.cartasFaltantes());
    }

    @Test
    public void test06deshacerEleccionAumentaLasDisponibles(){
        Mano mano = new Mano();
        Jugador jugador = new Jugador(mano);
        Tablero tablero = new Tablero();
        Poker carta1 = new Poker(new Corazon(), new As());
        Poker carta2 = new Poker(new Corazon(), new Dos());
        Poker carta3 = new Poker(new Corazon(), new Tres());
        Poker carta4 = new Poker(new Corazon(), new Cuatro());
        Poker carta5 = new Poker(new Corazon(), new Cinco());
        Poker carta6 = new Poker(new Corazon(), new Seis());
        Poker carta7 = new Poker(new Corazon(), new Siete());
        Poker carta8 = new Poker(new Corazon(), new Ocho());

        List<Poker> cartasAgregar = List.of(carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8);
        jugador.agregarCartas(cartasAgregar);
        jugador.seleccionarCarta(carta1);
        jugador.seleccionarCarta(carta2);

        jugador.deshacerEleccion();

        assertEquals(0, jugador.cartasFaltantes());
    }
}