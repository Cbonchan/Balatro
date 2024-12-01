package Modelo.SistemaCartas.Jugadas;

// Importaciones

import Modelo.SistemaCartas.Poker.Carta;

import java.util.ArrayList;
import java.util.List;

import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Multiplicador;
import org.jetbrains.annotations.NotNull;

//! Acá debería ser como StraightFlush, que verifique que solo tenga
// 2 pares
public class TwoPair extends  Jugada {

    // Atributos
    // Chips = 20 y Multiplicador = 2
    Pair primerPar = new Pair();
    Pair segundoPar = new Pair();


    // Constructores
    public TwoPair() {
        super( "Doble Par",new Chip(20), new Multiplicador( 2));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("doble par");
    }

    @Override
    public boolean esJugadaValida(@NotNull List<Carta> cartas){
        if (cartas.size() < 4) {
            return false;
        }

        // Verificar el primer par
        if (!primerPar.esJugadaValida(cartas)) {
            return false;
        }

        // Remover las cartas del primer par
        List<Carta> cartasRestantes = new ArrayList<>(cartas);
        cartasRestantes.removeAll(primerPar.cartasJugadas(cartas));

        // Verificar el segundo par
        return segundoPar.esJugadaValida(cartasRestantes) ;
    }


    @Override
    public  List<Carta> cartasJugadas(@NotNull List<Carta> cartas){

        // Obtener el primer par
        List<Carta> primerParCartas = primerPar.cartasJugadas(cartas);

        List<Carta> cartasDeDosPares = new ArrayList<>(primerParCartas);

        // Remover las cartas del primer par
        List<Carta> cartasRestantes = new ArrayList<>(cartas);
        cartasRestantes.removeAll(primerParCartas);

        // Obtener el segundo par
        List<Carta> segundoParCartas = segundoPar.cartasJugadas(cartasRestantes);
        cartasDeDosPares.addAll(segundoParCartas);

        return cartasDeDosPares;
    }

}
