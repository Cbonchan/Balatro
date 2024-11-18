package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class Straight  extends  Jugada{

    // Atributos
    // Chips = 30  y Multip[lificador  = 4

    // Constructor
    public Straight() {
        super( new Chip(30), new Multiplicador( 4));
    }

    // Métodos
    @Override
    public  boolean esJugadaValida(List<Poker> cartas) {

        // Primera condición, no existe escalera con menos de 5 cartas
        if (cartas.size() != 5){
            return false;
        }

        //  Ordenamos de mayor a menor
        // Hay que preguntar
        cartas.sort((c1, c2) -> Integer.compare(c2.getFigura().orden(), c1.getFigura().orden()));

        //  Verificamos que las cartas sean consecutivas

        for ( int i = 0; i < cartas.size() - 1; i++ ) {
            // variables para mayor claridad
            Poker actual = cartas.get(i);
            Poker siguiente = cartas.get(i + 1);

            // Verificar si la carta actual no es consecutiva con la siguiente
            if (!actual.laCartaSiguienteEs(siguiente)) {
                return false;
            }
        }
        return true; // Todas las cartas son consecutivas
    }







        List<Figura> figurasEsperados = List.of(
                new As(), new Rey(), new Reina(), new Jota(), new Diez());

        int cartaVecesEncontrada = 0;

        //! Ver si es posible que no sea doble for
        for (int i = 0; i < cartaPokers.size(); i++){

            Poker cartaActual = cartaPokers.get(i);

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

            /*
            for (int i = 0; i < cartaPokers.size(); i++) {

                cartaActual = cartaPokers.get(i);

                if (cartaActual.laCartaSiguienteEs(cartaActual[1]) ) {
                    return false;
                }0'98'

                if (carta[i].siguienteCarta() !=  carta[i + 1])
                    return  false ;
            }
            */





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
    public  List<Poker> cartasJugada(@NotNull List<Poker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }

}
