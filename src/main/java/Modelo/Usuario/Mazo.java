package Modelo.Usuario;

// Importaciones
import Modelo.SistemaCartas.Cartas.*;
import Modelo.SistemaCartas.Cartas.Figura.*;
import Modelo.SistemaCartas.Cartas.Palo.*;

import Modelo.SistemaCartas.Cartas.Figura.Figura;
import Modelo.SistemaCartas.Cartas.Palo.Palo;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Mazo {

    // Atributos
    private int cartasDisponibles;
    private final ArrayList<Carta> mazoDeCartas; //TODO: Cambiar "mazoDeCartas" a "cartas" (Camilo)

    // Constructor
    public Mazo() {
        this.cartasDisponibles = 52;
        mazoDeCartas = new ArrayList<>();

        Palo[] palos = {
                new Corazon(), new Diamante(), new Trebol(), new Pica()};

        Figura[] valores ={
                new As(), new Dos(), new Tres(), new Cuatro(),
                new Cinco(), new Seis(), new Siete(), new Ocho(),
                new Nueve(), new Diez(), new Jota(), new Reina(),
                new Rey()};
        

        for (Palo palo : palos) {
            for (Figura valor : valores ) {
                mazoDeCartas.add(new Carta(palo, valor));
            }
        }
    }

    // Constructor para el Parser
    public Mazo(int cartasDisponibles, ArrayList<Carta> cartas) {
        this.cartasDisponibles = cartasDisponibles;
        this.mazoDeCartas = cartas;
    }

    // Getters y Setters
    public int getCartasDisponibles(){
        return cartasDisponibles;
    }

    // Métodos
    
    // Privados
    private Carta cartaAleatoria() {
        int indice = (int) (Math.random() * cartasDisponibles);
        Carta cartaCarta = mazoDeCartas.get(indice);
        mazoDeCartas.remove(indice);
        return cartaCarta;
    }

    // Públicos

    // Post: Reparte cartas hasta que tenga 8 cartas
    public void  repartirCartas(List<Carta> cartasACompletar) {
        while ( cartasACompletar.size() != 8 ){
            cartasACompletar.add(cartaAleatoria());
            cartasDisponibles--;
        }
    }

    // Post: Se ingresan las cartas al mazo
    public void reinsertarCartas(List<Carta> cartas) {
        mazoDeCartas.addAll(cartas);
        cartasDisponibles += cartas.size();
    }


    //  Para el parser
    public String obtenerPaloDeCarta(int indiceDeCarta) {
        Carta carta = mazoDeCartas.get(indiceDeCarta-1);
        return carta.getPalo().getNombre();
    }

    public String obtenerFiguraDeCarta(int indiceDeCarta){
        Carta carta = mazoDeCartas.get(indiceDeCarta-1);
        return carta.getFigura().getNombre();
    }

    public void agregarCarta(Carta carta) {
        mazoDeCartas.add(carta);
    }

}
