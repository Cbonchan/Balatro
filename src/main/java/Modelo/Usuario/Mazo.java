package Modelo.Usuario;

// Importaciones
import Modelo.SistemaCartas.Cartas.*;
import Modelo.SistemaCartas.Cartas.Figura.*;
import Modelo.SistemaCartas.Cartas.Palo.*;

import Modelo.SistemaCartas.Cartas.Figura.Figura;
import Modelo.SistemaCartas.Cartas.Palo.Palo;

import java.util.ArrayList;
import java.util.List;

public class Mazo {

    // Atributos
    private final ArrayList<Carta> Cartas;

    // Constructor
    public Mazo() {
        Cartas = new ArrayList<>();

        Palo[] palos = {
                new Corazon(), new Diamante(), new Trebol(), new Pica()};

        Figura[] valores ={
                new As(), new Dos(), new Tres(), new Cuatro(),
                new Cinco(), new Seis(), new Siete(), new Ocho(),
                new Nueve(), new Diez(), new Jota(), new Reina(),
                new Rey()};
        

        for (Palo palo : palos) {
            for (Figura valor : valores ) {
                Cartas.add(new Carta(palo, valor));
            }
        }
    }

    // Constructor para el Parser
    public Mazo( ArrayList<Carta> cartas) {
        this.Cartas = cartas;
    }

    // Getters y Setters
    public int getCartasDisponibles(){
        return Cartas.size();
    }

    // Métodos
    
    // Privados
    private Carta cartaAleatoria() {
        int indice = (int) (Math.random() * Cartas.size());
        Carta cartaCarta = Cartas.get(indice);
        Cartas.remove(indice);
        return cartaCarta;
    }

    // Públicos

    // Post: Reparte cartas hasta que tenga 8 cartas
    public void  repartirCartas(List<Carta> cartasACompletar) {
        while ( cartasACompletar.size() != 8 ){
            cartasACompletar.add(cartaAleatoria());
        }
    }

    // Post: Se ingresan las cartas al mazo
    public void reinsertarCartas(List<Carta> cartas) {
        Cartas.addAll(cartas);
    }


    //  Para el parser
    public String obtenerPaloDeCarta(int indiceDeCarta) {
        Carta carta = Cartas.get(indiceDeCarta-1);
        return carta.getPalo().getNombre();
    }

    public String obtenerFiguraDeCarta(int indiceDeCarta){
        Carta carta = Cartas.get(indiceDeCarta-1);
        return carta.getFigura().getNombre();
    }

    public void agregarCarta(Carta carta) {
        Cartas.add(carta);
    }

}
