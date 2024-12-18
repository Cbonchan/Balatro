package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Cartas.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugada {

    // Atributos
    protected Puntaje puntaje;
    private final String nombre;
    // Constructor
    public Jugada(String nombre, Chip chips, Multiplicador multiplicador) {
        this.nombre = nombre;
        this.puntaje = new Puntaje(chips, multiplicador);
    }

    public Jugada(Chip chips, Multiplicador multiplicador) {
        this.nombre = "Vacio";
        this.puntaje = new Puntaje(chips, multiplicador);
    }


    // Métodos
    // Abstractos

    // Post: Devuelve true si la jugada corresponde a una de las hijas
    public abstract boolean esJugadaValida(@NotNull List<Carta> cartas);

    // Post: Regresa la lista de cartas ordenadas de mayor a menor
    public abstract List<Carta> cartasJugadas(@NotNull List<Carta> cartas);

    // Protected

    // Post: Devuelve la lista de cartas ordenadas de mayor a menor
    protected List<Carta> ordenarCartas(List<Carta> cartas) {
        List<Carta> cartasMutable = new ArrayList<>(cartas);
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

    // Listos:

    // Post: Devuelve true si la jugada corresponde a una de las hijas
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals(nombre);
    }

    public void aumentarChips(Chip incremento){
        puntaje.sumarChipCon(incremento);
    }

    public void sumarMultiplicador(Multiplicador incremento){
        puntaje.sumarMultiplicador(incremento);
    }

    public void multiplicarMultiplicador(Multiplicador incremento){
        puntaje.multiplicarMultiplicadorPor(incremento);
    }

    public void mejorar(int incrementador, Multiplicador multiplicador){
        this.puntaje.aumentarPuntaje(incrementador, multiplicador);
    }

    public String getNombre() {
        return nombre;
    }

    // Falta

    // Post: Devuelve true si la jugada corresponde a una de las hijas

    public float obtenerMultiplicador(){
        return (puntaje.obtenerMultiplicador());
    }

    public int obtenerChips(){
        return (puntaje.obtenerChips());
    }

    // Post: Devuelve el puntaje de la jugada
    public float calcularPuntaje(Puntaje puntajeList){

        puntajeList.sumarNuevosChips(puntaje);
        puntajeList.sumarNuevoMultiplicador(puntaje);
        //puntaje.sumarNuevosChips(puntajeList);
        //puntaje.sumarNuevoMultiplicador(puntajeList);
        return puntajeList.calcularPuntaje();
    }

}