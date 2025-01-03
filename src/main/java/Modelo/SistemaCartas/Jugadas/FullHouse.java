package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Cartas.Carta;

import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;


public class FullHouse extends  Jugada{

    //Atributos
    //  Chips = 40 y Multiplicador = 4
    Pair par = new Pair();
    ThreeOfAKind trio= new ThreeOfAKind();

    // Constructor
    public FullHouse() {
        super( "full",new Chip(40), new Multiplicador( 4));
    }

    // Métodos
    @Override
    public boolean esJugadaValida(@NotNull List<Carta> cartas) {
        // No existe Full House con menos de 5 cartas
        if ( cartas.size() != 5 ){
            return false;
        }

        // Verificar el Three of a Kind
        if (!trio.esJugadaValida(cartas)) {
            return false;
        }

        // Remover las cartas del Three of a Kind
        List<Carta> cartasRestantes = new ArrayList<>(cartas);
        cartasRestantes.removeAll(trio.cartasJugadas(cartas));

        // Verificar el Pair en las cartas restantes
        return par.esJugadaValida(cartasRestantes);
    }


    @Override
    public   List<Carta> cartasJugadas(@NotNull List<Carta> cartas){
        return  ordenarCartas(cartas);
    }

}