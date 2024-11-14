package TP;

import javafx.scene.control.ListCell;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public abstract class Jugada {
    private int puntaje;
    private int multiplicador;

    public Jugada(int puntaje, int multiplicador) {
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;
    }
    public abstract List<CartaPoker> cartasJugada(List<CartaPoker> cartaPokers);

    public int puntajeJugada() {
        return puntaje;
    }

    public int multiplicadorJugada() {
        return multiplicador;
    }
}
//las jugadas agregan al multiplicador y agregan
//sus puntos al marcador cuando se realizan
//NO EXISTE MANO QUE NO LLEVE A UNA JUGADA

class Pair extends Jugada {
    //mult=2 puntaje=10
    public Pair() {
        super(10, 2);
    }

    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers){
        if (cartaPokers.size() < 2){
            return false;
        }
        for (int i = 0; i < cartaPokers.size(); i++) {
            for (int j = i + 1; j < cartaPokers.size(); j++) {
                Figura otraFigura = cartaPokers.get(j).getFigura();

                if (cartaPokers.get(i).esFiguraIgualA(otraFigura)) {
                    return true;
                }
            }
        }
        return false;
    }

    public  List <CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers){
        List<CartaPoker> cartasDelPar = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            for (int j = i + 1; j < cartaPokers.size(); j++) {
                if (cartaPokers.get(i).esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartasDelPar.add(cartaPokers.get(i));
                    cartasDelPar.add(cartaPokers.get(j));
                    return cartasDelPar; // Primer par encontrado
                }
            }
        }

        return cartasDelPar; // Vacío en caso de que no se haya encontrado par
    }
}

class TwoPair extends Jugada {
    //mult=2 puntaje=20

    public TwoPair() {
        super(20, 2);
    }

    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers){
        if (cartaPokers.size() < 4){
            return false;
        }
        List<Figura> figurasConPares = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            for (int j = i + 1; j < cartaPokers.size(); j++) {
                Figura figuraActual = cartaPokers.get(i).getFigura();
                Figura figuraAComparar = cartaPokers.get(j).getFigura();

                if (cartaPokers.get(i).esFiguraIgualA(figuraAComparar) && !figurasConPares.contains(figuraActual)) {
                    figurasConPares.add(figuraActual);
                    break;
                }
            }
        }

        return figurasConPares.size() == 2; // Devuelve true si son dos pares distintos
    }

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers){
        List<CartaPoker> cartasDeDosPares = new ArrayList<>();
        List<Figura> figurasConPares = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            for (int j = i + 1; j < cartaPokers.size(); j++) {
                Figura figuraActual = cartaPokers.get(i).getFigura();
                if (cartaPokers.get(i).esFiguraIgualA(cartaPokers.get(j).getFigura())
                        && !figurasConPares.contains(figuraActual)) {
                    figurasConPares.add(figuraActual);
                    cartasDeDosPares.add(cartaPokers.get(i));
                    cartasDeDosPares.add(cartaPokers.get(j));
                    break;
                }
            }
        }
        return cartasDeDosPares;
    }
}

class ThreeOfAKind extends Jugada {
    //mult=3 puntaje=30

    public ThreeOfAKind() {
        super(30, 3);
    }

    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers){
        if (cartaPokers.size() < 3){
            return false;
        }
        List <Figura> figurasConThreeOfAKind = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            int cartaVecesEncontrada = 0;
            CartaPoker cartaActual = cartaPokers.get(i);

            for (int j = i + 1; j < cartaPokers.size(); j++) {

                if (cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartaVecesEncontrada++;
                }
            }

            if (cartaVecesEncontrada == 2){
                figurasConThreeOfAKind.add(cartaActual.getFigura());
                break;
            }
        }
        return figurasConThreeOfAKind.size() == 1;
    }

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers){
        List<CartaPoker> cartasTresIguales = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            CartaPoker cartaActual = cartaPokers.get(i);
            int cuenta = 0;

            for (int j = 0; j < cartaPokers.size(); j++) {
                if (cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartasTresIguales.add(cartaPokers.get(j));
                    cuenta++;
                }
                if (cuenta == 3) break;
            }

            if (cuenta == 3) return cartasTresIguales;
        }

        return cartasTresIguales;
    }

}

class HighCard extends Jugada {
    public HighCard() {
        super(5, 1);
    }

    public static boolean esJugadaValida(List<CartaPoker> cartaPokers){
        return !cartaPokers.isEmpty();
    }

    public  List<CartaPoker> cartasJugada(List<CartaPoker> cartaPokers){
        Collections.sort(cartaPokers, (c1, c2) -> Integer.compare(c2.getFigura().devolverPuntaje(), c1.getFigura().devolverPuntaje()));
        return List.of(cartaPokers.get(0));
    }
}

class Straight extends Jugada {
    //mult=4 puntaje=30

    public Straight() {
        super(30, 4);
    }

    public static boolean esJugadaValida(List<CartaPoker> cartaPokers) {
        if (cartaPokers.size() != 5){
            return false;
        }

        //TODO: hay que ordenar por esMayorA u alguna otra implementacion

        Collections.sort(cartaPokers, (c1, c2) -> c1.getFigura().esMayorA(c2.getFigura()) ? 1 : -1);

        for (int i = 0; i < cartaPokers.size() - 1; i++) {

            if (!cartaPokers.get(i).getFigura().esMayorA(cartaPokers.get(i + 1).getFigura())) {
                return false;
            }
        }
        return true;
    }

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }
}

class Flush extends Jugada {
    //mult=4 puntaje=35

    public Flush() {
        super(35, 4);

    }
    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers) {
        // Verificamos que todas las cartas tengan el mismo palo
        if (cartaPokers.size() != 5){
            return false;
        }
        String palo = cartaPokers.get(0).getPalo(); // Tomamos el palo de la primera carta

        for (CartaPoker carta : cartaPokers) {
            if (!carta.getPalo().equals(palo)) {
                return false; // Si alguna carta tiene un palo diferente, no es un Flush
            }
        }

        return true; // Si todas las cartas tienen el mismo palo, es un Flush
    }

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }
}

class RoyalFLush extends Jugada{

    public RoyalFLush() {
        super(100, 8);
    }

    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers) {
        if (cartaPokers.size() != 5){
            return false;
        }
        // Verificamos que todas las cartas tengan el mismo palo
        String palo = cartaPokers.get(0).getPalo(); // Tomamos el palo de la primera carta

        for (CartaPoker carta : cartaPokers) {
            if (!carta.getPalo().equals(palo)) {
                return false; // Si alguna carta tiene un palo diferente, no es un Flush
            }
        }
        List<Figura> figurasEsperados = List.of(new As(), new K(), new Q(), new J(), new Diez());
        int cartaVecesEncontrada = 0;
        for (int i = 0; i < cartaPokers.size(); i++){
            CartaPoker cartaActual = cartaPokers.get(i);
            for (int j = 0; j < figurasEsperados.size(); j++) {
                if ( cartaActual.esFiguraIgualA(figurasEsperados.get(j)) ){
                    cartaVecesEncontrada++;
                }
            }
        }
        return  cartaVecesEncontrada == 5;
    }


    public List<CartaPoker> cartasJugada(List<CartaPoker> cartaPokers) {
        return cartaPokers;
    }
}

class FullHouse extends Jugada {
    //mult=4 puntaje=40

    public FullHouse() {
        super(40, 4);
    }
    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers) {
        if (cartaPokers.size() != 5){
            return false;
        }
        List<Figura> figurasConThreeOfAKind = new ArrayList<>();
        List<Figura> figurasConPair = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            int cartaVecesEncontrada = 0;
            CartaPoker cartaActual = cartaPokers.get(i);

            // Contar cuántas veces aparece esta figura en el resto de la lista
            for (int j = 0; j < cartaPokers.size(); j++) {
                if (i != j && cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartaVecesEncontrada++;
                }
            }

            // Si encontramos exactamente 2 coincidencias, es un "Three of a Kind"
            if (cartaVecesEncontrada == 2 && !figurasConThreeOfAKind.contains(cartaActual.getFigura())) {
                figurasConThreeOfAKind.add(cartaActual.getFigura());
            }
            // Si encontramos exactamente 1 coincidencia, es un "Pair"
            else if (cartaVecesEncontrada == 1 && !figurasConPair.contains(cartaActual.getFigura())) {
                figurasConPair.add(cartaActual.getFigura());
            }
        }

        // Verificamos si tenemos un "Three of a Kind" y un "Pair" de diferentes figuras
        return figurasConThreeOfAKind.size() == 1 && figurasConPair.size() == 1;
    }

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }
}

class FourOfAKind extends Jugada {
    //mult=7 puntaje=60

    public FourOfAKind() {
        super(60, 7);
    }

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

class StraightFlush extends Jugada {
    //mult=8 puntaje=100

    public StraightFlush() {
        super(100, 8);
    }

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }
}
