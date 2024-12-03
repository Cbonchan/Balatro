package Modelo.Juego;

import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    // Atributos
   //Max de 2 jokers
    //Max de 2 Tarots
    //Max 1 carta

    private final ArrayList<Activable> comprables;
    //Estos numeros podrian cambiar en un futuro, asi que los definimos como atributos
    //con un size de la lista se soluciona
    private Activable aComprar;
    private Carta carta;


    // Constructor
    public Tienda(List<Activable> comprables, Carta carta) {
        this.comprables = new ArrayList<>(comprables);
        this.aComprar = null;
        this.carta = carta;
    }

        /*TODO: METODOS PARA COMPRAR LAS CARTAS, NO CREO QUE HAYA QUE IMPLEMENTAR DINERO
           PORQUE NO APARECE EN NINGUN LUGAR DE LA DOCUMENTACION, PERO CUIDADO.
        */

    // al manejar comprables utilizamos polimorfismo
    public void seleccionarActivable(Activable comprable) {
        this.aComprar = comprable;
    }


    public Activable comprarActibable() {
        Activable aux = this.aComprar;
        deseleccionarActivable();
        return aux;
    }
    //debido a que cartas no es activable, no se me ocurre como se podría comprar de la misma forma
    public Carta comprarCarta(){
        Carta aux = this.carta;
        this.carta = null;
        return aux;
    }

    public void deseleccionarActivable() {
        this.aComprar = null;
    }
}



