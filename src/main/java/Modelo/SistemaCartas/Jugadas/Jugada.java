package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.*;
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaPuntaje.Puntaje;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugada {

    // Atributos
    protected Puntaje puntaje;

    // Constructor
    public Jugada(Chip chips, Multiplicador mult) {
        this.puntaje = new Puntaje(chips, mult);
    }

    // Métodos
    // Abstractos
    public abstract List<Poker> cartasJugada(List<Poker> cartaPokers);

    // Post : Devuelve true si la jugada corresponde a una de las hijas
    public abstract boolean esJugadaValida(@NotNull List<Poker> cartaPokers);
    // Post: Devuelve true si el nombre de una jugada pasado por parametro es el nombre de esa instancia de jugada
    public abstract boolean validarNombreJugada(String manoAValidar);

    // Públicos

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
    public  List<Poker> cartasJugadas(@NotNull List<Poker> cartas){
        cartas.sort((c1, c2) -> Integer.compare(c2.getFigura().orden(), c1.getFigura().orden()));
        return  new ArrayList<>(cartas);
    }

    public  int calcularPuntaje(Puntaje puntajeList){

        puntaje.sumarNuevosChips(puntajeList);
        puntaje.sumarNuevoMultiplicador(puntajeList);
        return puntaje.calcularPuntaje();
    }

}

//las jugadas agregan al multiplicador y agregan
//sus puntos al marcador cuando se realizan
//NO EXISTE MANO QUE NO LLEVE A UNA JUGA