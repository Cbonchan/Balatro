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

        /*TODO: METODOS PARA COMPRAR LAS CARTAS, NO CREO QUE HAYA QUE IMPLEMENTAR DINERO
           PORQUE NO APARECE EN NINGUN LUGAR DE LA DOCUMENTACION, PERO CUIDADO.
        */

    // al manejar comprables utilizamos polimorfismo
    /*public void seleccionarActivable(Activable comprable) {
        //testear si el comprable esta en la lista de tarots o tarotsEnCarta
        if (!activableEnMano.contains(comprable) || !tarotsEnCarta.contains(comprable)) {
            this.deseleccionarActivable();
            return;
        }
        this.aComprar = comprable;
    }*/


    public Activable comprarActivableEnMano(Activable comprable) {
        if (!tarot.contains(comprable)) {
            return null;
        }
        Activable aux = this.tarot.get(this.tarot.indexOf(comprable)); ;
        this.tarot.remove(comprable);
        return aux;
    }

    public ActivableEnCarta comprarTarotEnCarta(ActivableEnCarta comprable) {
        if (!tarotsEnCarta.contains(comprable)) {
            return null;
        }
        ActivableEnCarta aux = this.tarotsEnCarta.get(this.tarotsEnCarta.indexOf(comprable));
        this.tarotsEnCarta.remove(comprable);
        return aux;
    }

    //debido a que cartas no es activable, no se me ocurre como se podría comprar de la misma forma
    public Carta comprarCarta(){
        Carta aux = this.carta;
        this.carta = null;
        return aux;
    }

    public void venderCarta(){
        this.carta = null;
    }

    public int cantidadDeElementosDisponibles(){
        return this.tarot.size() + this.tarotsEnCarta.size() + (this.carta == null ? 0 : 1);
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





