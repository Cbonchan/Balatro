package Modelo.Juego;
import Modelo.SistemaCartas.Activables.Tarot.Tarot;
import Modelo.SistemaCartas.Poker.Carta;
import Modelo.Usuario.Jugador;
import Modelo.Usuario.Mano;
import Modelo.Usuario.PilaDescarte;
import Modelo.SistemaCartas.Activables.Joker.*;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private final List<Joker> jokersALaVenta;//Max de 2 jokers
    private final List<Tarot> tarotsALaVenta;//Max de 2 Tarots
    private final List<Carta> cartasALaVenta;//Max 1 carta
    //Estos numeros podrian cambiar en un futuro, asi que los definimos como atributos
    private final int jokersDisponibles;
    private final int tarotsDisponibles;
    private final int cartasDisponibles;

    private Joker jokerAComprar;
    private Tarot tarotAComprar;
    private Carta cartaAComprar;


    public Tienda(List<Joker> jokers, List<Tarot> tarots, List<Carta> cartas) {
        this.jokersALaVenta = jokers;
        this.tarotsALaVenta = tarots;
        this.cartasALaVenta = cartas;
        this.jokersDisponibles = 2;
        this.tarotsDisponibles = 2;
        this.cartasDisponibles = 1;
    }

        /*TODO: METODOS PARA COMPRAR LAS CARTAS, NO CREO QUE HAYA QUE IMPLEMENTAR DINERO
           PORQUE NO APARECE EN NINGUN LUGAR DE LA DOCUMENTACION, PERO CUIDADO.
    */

    public void seleccionarJoker(Joker joker) {
        jokerAComprar = joker;
        jokersALaVenta.remove(joker);
    }

    public void seleccionarTarot(Tarot tarot) {
        tarotAComprar = tarot;
        tarotsALaVenta.remove(tarot);
    }

    public void seleccionarCarta(Carta carta) {
        cartaAComprar = carta;
        cartasALaVenta.remove(carta);
    }

    public void deseleccionarCartas() {
        if (jokerAComprar != null) {
            jokersALaVenta.add(jokerAComprar);
            jokerAComprar = null;
        }
        if (tarotAComprar != null) {
            tarotsALaVenta.add(tarotAComprar);
            tarotAComprar = null;
        }
        if (cartaAComprar != null) {
            cartasALaVenta.add(cartaAComprar);
            cartaAComprar = null;
        }
    }
}
