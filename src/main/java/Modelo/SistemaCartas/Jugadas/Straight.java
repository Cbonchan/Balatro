package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.CartaPoker;

import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class Straight  extends  Jugada{

    // Atributos
    // Chips = 30  y Multip[lificador  = 4

    // Constructor
    public Straight() {
        super(30, 4);
    }

    // Métodos
    @Override
    public  boolean esJugadaValida(List<CartaPoker> cartaPokers) {
        if (cartaPokers.size() != 5){
            return false;
        }

        List<Figura> figurasEsperados = List.of(
                new As(), new Rey(), new Reina(), new Jota(), new Diez());

        int cartaVecesEncontrada = 0;

        for (int i = 0; i < cartaPokers.size(); i++){
            CartaPoker cartaActual = cartaPokers.get(i);
            for (int j = 0; j < figurasEsperados.size(); j++) {
                if ( cartaActual.esFiguraIgualA(figurasEsperados.get(j)) ){
                    cartaVecesEncontrada++;
                }
            }
        }

        if(cartaVecesEncontrada == 5){
            return true;
        }

        //TODO: hay que ordenar por esMayorA u alguna otra implementacion

        cartaPokers.sort((c1, c2) -> Integer.compare(c2.getFigura().orden(), c1.getFigura().orden()));

        for (int i = 1; i < cartaPokers.size(); i++) {
            int valorActual = cartaPokers.get(i-1).getFigura().orden();
            int valorSiguiente = cartaPokers.get(i).getFigura().orden();

            // Verificamos que la carta siguiente tenga un valor consecutivo al anterior
            if (valorSiguiente != valorActual - 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }

}
