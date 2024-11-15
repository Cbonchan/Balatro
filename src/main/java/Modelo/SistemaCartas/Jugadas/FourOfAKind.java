package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.CartaPoker;
import Modelo.SistemaCartas.Poker.Figura.Figura;

import java.util.List;
import java.util.ArrayList;

public class FourOfAKind extends  Jugada {

    // Atributos
    // Chips = 60 y Multiplicador = 7

    // Constructor
    public FourOfAKind() {
        super(60, 7);
    }

    // Métodos
    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers){
        if (cartaPokers.size() < 4){
            return false;
        }
        List<Figura> figurasConFourOfAKind = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            int cartaVecesEncontrada = 0;
            CartaPoker cartaActual = cartaPokers.get(i);

            for (int j = i + 1; j < cartaPokers.size(); j++) {
                if(cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())){
                    cartaVecesEncontrada++;
                }
            }

            if (cartaVecesEncontrada ==3){
                figurasConFourOfAKind.add(cartaActual.getFigura());
                break;
            }
        }
        return figurasConFourOfAKind.size() == 1;
    }

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers) {
        List<CartaPoker> cartasCuatroIguales = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            CartaPoker cartaActual = cartaPokers.get(i);
            int cuenta = 0;

            for (int j = 0; j < cartaPokers.size(); j++) {
                if (cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartasCuatroIguales.add(cartaPokers.get(j));
                    cuenta++;
                }
                if (cuenta == 4) break;
            }

            if (cuenta == 4) return cartasCuatroIguales;
            else cartasCuatroIguales.clear(); // Limpiamos si no se completó el grupo de 4
        }

        return cartasCuatroIguales;
    }
}

