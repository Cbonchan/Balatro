package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Figura.Figura;

import java.util.List;
import java.util.ArrayList;

import Modelo.SistemaPuntaje.*;
import Modelo.SistemaPuntaje.Puntaje;
import org.jetbrains.annotations.NotNull;

public class FourOfAKind extends  Jugada {

    // Atributos
    // Chips = 60 y Multiplicador = 7

    // Constructor
    public FourOfAKind() {
        super( new Chip(60), new Multiplicador( 7));
    }

    // Métodos

    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartaPokers){
        if ( cartaPokers.size() < 4 ){ return false; }

        List<Figura> figurasConFourOfAKind = new ArrayList<>();

        for ( int i = 0; i < cartaPokers.size(); i++ ) {
            int cartaVecesEncontrada = 0;
            Poker cartaActual = cartaPokers.get(i);

            for ( int j = i + 1; j < cartaPokers.size(); j++ ) {
                if( cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura()) ){
                    cartaVecesEncontrada++;
                }
            }

            if ( cartaVecesEncontrada ==3 ){
                figurasConFourOfAKind.add(cartaActual.getFigura());
                break;
            }
        }
        return figurasConFourOfAKind.size() == 1;
    }

    @Override
    public List<Poker> cartasJugada(@NotNull List<Poker> cartaPokers) {
        List<Poker> cartasCuatroIguales = new ArrayList<>();

        //! No esta bueno crear variables dentro del ciclo
        for ( int i = 0;  i < cartaPokers.size(); i++ ) {
            Poker cartaActual = cartaPokers.get(i);
            int cuenta = 0;

            for ( int j = 0;  j < cartaPokers.size();  j++ ) {
                if ( cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura()) ) {
                    cartasCuatroIguales.add(cartaPokers.get(j));
                    cuenta++;
                }
                if ( cuenta == 4 ) break;
            }

            if ( cuenta == 4 ) return cartasCuatroIguales;
            cartasCuatroIguales.clear(); // Limpiamos si no se completó el grupo de 4
        }
        return cartasCuatroIguales;
    }
}

