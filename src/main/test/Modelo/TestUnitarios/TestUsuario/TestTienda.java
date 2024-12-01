package Modelo.TestUnitarios.TestUsuario;

import Modelo.Juego.Tablero;
import Modelo.Juego.Tienda;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.Joker.Joker;
import Modelo.SistemaCartas.Activables.Tarot.MejoraCarta;
import Modelo.SistemaCartas.Activables.Tarot.MejoraJugada;
import Modelo.SistemaCartas.Activables.Tarot.Tarot;
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
            List<Activable> tarots = List.of(new MejoraJugada("Test", "Test", 100, 1, "par"), new MejoraCarta("Test", "Test", 100, 1));
            Carta cartaNueva = new Carta(new Corazon(), new As());
            Tienda tienda = new Tienda(tarots, cartaNueva);

            Carta cartaComprada = tienda.comprarCarta();

            assertEquals(cartaNueva, cartaComprada);
        }

        @Test
        public void test02creoTiendaConElementosYComproTarot() {
            List<Joker> jokers = new ArrayList<>();
            List<Activable> tarots = List.of(new MejoraJugada("Test", "Test", 100, 1, "par"), new MejoraCarta("Test", "Test", 100, 1));
            Carta cartaNueva = new Carta(new Corazon(), new As());
            Tienda tienda = new Tienda(tarots, cartaNueva);

            tienda.seleccionarActivable(tarots.get(0));
            Activable tarotComprado = tienda.comprarActibable();

            assertEquals(tarots.get(0), tarotComprado);

        }
        //TODO: Implementar el refactor de joker antes de testear
        @Test
        public void test03creoTiendaConElementosYComproJoker() {

        }
}
