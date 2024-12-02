package Modelo.TestUnitarios.TestUsuario;

import Modelo.Juego.Tablero;
import Modelo.Juego.Tienda;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.Joker.Descarte;
import Modelo.SistemaCartas.Activables.Joker.Joker;
import Modelo.SistemaCartas.Activables.Joker.PorJugada;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.*;
import Modelo.SistemaCartas.Activables.Tarot.MejoraCarta;
import Modelo.SistemaCartas.Activables.Tarot.MejoraJugada;
import Modelo.SistemaCartas.Activables.Tarot.Tarot;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.*;
import Modelo.Juego.Tienda.*;
import Modelo.SistemaCartas.Poker.*;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;

import  org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import  static  org.junit.jupiter.api.Assertions.*;



public class TestTienda {

        @Test
        public void test01creoTiendaConElementosYComproCarta() {
            List<Activable> tarots = List.of(new PorJugada("Test", "Test", 100, new Multiplicador(1), "par", new SumarPuntaje()));
            Carta cartaNueva = new Carta(new Corazon(), new As());
            Tienda tienda = new Tienda(tarots, cartaNueva);

            Carta cartaComprada = tienda.comprarCarta();

            assertEquals(cartaNueva, cartaComprada);
        }

        @Test
        public void test02creoTiendaConElementosYComproTarot() {
            List<Joker> jokers = new ArrayList<>();
            List<Activable> tarots = List.of(
                    new MejoraJugada("Test", "Test", 100, new Multiplicador(1), "par",new CambiarChips()),
                    new MejoraJugada("Test2", "Test2", 100, new Multiplicador(1), "par",new CambiarChips()));
            Carta cartaNueva = new Carta(new Corazon(), new As());
            Tienda tienda = new Tienda(tarots, cartaNueva);

            tienda.seleccionarActivable(tarots.get(0));
            Activable tarotComprado = tienda.comprarActibable();

            assertEquals(tarots.get(0), tarotComprado);

        }



        @Test
        public void test03creoTiendaConElementosYComproJoker() {
            Carta cartaNueva = new Carta(new Corazon(), new As());
            List<Activable> activables = List.of(new PorJugada("Test", "Test", 100, new Multiplicador(1), "par", new SumarPuntaje()), new Descarte("Test", "Test", 100, new Multiplicador(1), new AumentarChips()));
            Tienda tienda = new Tienda(activables, cartaNueva);

            tienda.seleccionarActivable(activables.get(0));
            Activable jokerComprado = tienda.comprarActibable();

            assertEquals(activables.get(0), jokerComprado);

        }
}

