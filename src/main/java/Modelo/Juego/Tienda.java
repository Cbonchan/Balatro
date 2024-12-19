package Modelo.Juego;

import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.ActivableEnCarta;
import Modelo.SistemaCartas.Cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    // Atributos
    //Max de 2 jokers
    //Max de 2 Tarots
    //Max 1 carta
    private final ArrayList<Activable> jokers;
    private final ArrayList<Activable> tarot;
    private final ArrayList<ActivableEnCarta> tarotsEnCarta;
    private Carta carta;

    //Estos numeros podrian cambiar en un futuro, asi que los definimos como atributos
    //con un size de la lista se soluciona


    // Constructor
    public Tienda(List<Activable> jokers, List<Activable> activableEnMano, Carta carta, List<ActivableEnCarta> tarotsDeCarta) {
        this.jokers= new ArrayList<>(jokers);
        this.tarot = new ArrayList<>(activableEnMano);
        this.tarotsEnCarta = new ArrayList<>(tarotsDeCarta);
        this.carta = carta;
    }

    public void venderCarta(){
        this.carta = null;
    }

    public Carta getCartaALaVenta(){return carta;}

    public ArrayList<Activable> getJokers() {
        return jokers;
    }

    public ArrayList<Activable> getTarot() {return tarot; }

    public ArrayList<ActivableEnCarta> getTarotsEnCarta() {
        return tarotsEnCarta;
    }
}





