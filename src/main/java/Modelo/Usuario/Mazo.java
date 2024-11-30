package Modelo.Usuario;

// Importaciones
import Modelo.SistemaCartas.Poker.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Palo.*;

import Modelo.SistemaCartas.Poker.Figura.Figura;
import Modelo.SistemaCartas.Poker.Palo.Palo;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Mazo {

    // Atributos
    private final ArrayList<Carta> mazoDeCartas;
    private int cartasDisponibles;

    // Constructor
    public Mazo() {
        this.cartasDisponibles = 52;
        mazoDeCartas = new ArrayList<Carta>();

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
        cartasDisponibles--;
        return cartaCarta;
    }
    
    // Públicos
    public boolean mazoCompleto() {
        return cartasDisponibles == 52;
    }

    public void repartirCartas(Jugador jugador) {
        List<Carta> cartasParaMandar = new ArrayList<>();

        for (int i = 0; i < jugador.cartasFaltantes(); i++) {
            cartasParaMandar.add(cartaAleatoria());
        }
        jugador.agregarCartas(cartasParaMandar);
    }

    public void reinsertarCartas(List<Carta> cartas) {
        mazoDeCartas.addAll(cartas);
        cartasDisponibles += cartas.size();
    }
//TODO: este metodo puede simplificar significativamente el como se reparten las cartas, investigar
    public void shuffle() {
        Collections.shuffle(mazoDeCartas);
    }

}
