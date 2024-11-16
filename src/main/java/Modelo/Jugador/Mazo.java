package Modelo.Jugador;

// Importaciones
import Modelo.SistemaCartas.Poker.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Palo.*;

import Modelo.SistemaCartas.Poker.Figura.Figura;
import Modelo.SistemaCartas.Poker.Palo.Palo;

import java.util.ArrayList;
import java.util.List;


public class Mazo {

    // Atributos
    private final ArrayList<CartaPoker> mazoDeCartas;

    // Constructor
    public Mazo() {
        mazoDeCartas = new ArrayList<CartaPoker>();


        Figura[] valores ={
                new As(), new Dos(), new Tres(), new Cuatro(),
                new Cinco(), new Seis(), new Siete(), new Ocho(),
                new Nueve(), new Diez(), new Jota(), new Reina(),
                new Rey()};
        
        Palo[] palos = {
                new Corazon(), new Diamante(), new Trebol(), new Pica()};

        for (Palo palo : palos) {
            for (Figura valor : valores ) {
                mazoDeCartas.add(new CartaPoker(palo, valor));
            }
        }
    }

    // Getters y Setters
    public int getCartasDisponibles(){
        return mazoDeCartas.size();
    }

    // Métodos
    
    // Privados
    private CartaPoker cartaAleatoria() {
        int indice = (int) (Math.random() * mazoDeCartas.size());
        CartaPoker cartaPoker = mazoDeCartas.get(indice);
        mazoDeCartas.remove(indice);
        return cartaPoker;
    }
    
    // Públicos
    public boolean mazoCompleto() {
        return mazoDeCartas.size() == 52;
    }

    public void repartirCartas(Jugador jugador) {
        List<CartaPoker> cartasParaMandar = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            cartasParaMandar.add(cartaAleatoria());
        }
        jugador.agregarCartas(cartasParaMandar);
    }

  

}
