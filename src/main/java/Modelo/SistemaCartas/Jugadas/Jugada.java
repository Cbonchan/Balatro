package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugada {

    // Atributos
    protected Puntaje puntaje;

    // Constructor
    public Jugada(Chip chips, Multiplicador multiplicador) {
        this.puntaje = new Puntaje(chips, multiplicador);
    }

    // Métodos
    // Abstractos

    // Públicos
    // Post: Devuelve true si la jugada corresponde a una de las hijas
    public abstract boolean esJugadaValida(@NotNull List<Poker> cartas);

    public int obtenerMultiplicador(){
        return (puntaje.obtenerMultiplicador());
    }

    public void sumarMultiplicador(int incremento){
        Chip chip = new Chip(0);
        Multiplicador multiplicador = new Multiplicador(incremento);
        Puntaje otroPuntaje = new Puntaje(chip, multiplicador);
        puntaje.incrementarMultiplicador(otroPuntaje);
    }

    public void multiplicarMultiplicador(int incremento){
        Chip chip = new Chip(0);
        Multiplicador multiplicador = new Multiplicador(incremento);
        Puntaje otroPuntaje = new Puntaje(chip, multiplicador);
        puntaje.sumarNuevoMultiplicador(otroPuntaje);
    }

    public int obtenerChips(){
        return (puntaje.obtenerChips());
    }

    public void aumentarChips(int puntos, int multiplicador){
        Chip chip = new Chip(puntos);
        puntaje.sumarChip(chip);
    }

    // Post: Regresa la lista de cartas ordenadas de mayor a menor
    public abstract List<Poker> cartasJugadas(@NotNull List<Poker> cartas);


    // Protected

    // Post: Devuelve la lista de cartas ordenadas de mayor a menor
    protected List<Poker> ordenarCartas(List<Poker> cartas) {
        List<Poker> cartasMutable = new ArrayList<>(cartas);
        cartasMutable.sort((carta1, carta2) -> {

            int valor1 = carta1.obtenerOrden();
            int valor2 = carta2.obtenerOrden();

            // Considerar As como 1 o 14
            if (valor1 == 1 && (valor2 >= 10 )) {
                valor1 = 14;
            } else if (valor2 == 1 && (valor1 >= 10 )) {
                valor2 = 14;
            }

            return Integer.compare(valor2, valor1); // Ordenar de mayor a menor
        });
        return cartasMutable;
    }

    // Públicos

    // Post: Devuelve el puntaje de la jugada
    public  int calcularPuntaje(Puntaje puntajeList){

        puntaje.sumarNuevosChips(puntajeList);
        puntaje.sumarNuevoMultiplicador(puntajeList);
        return puntaje.calcularPuntaje();
    }

}