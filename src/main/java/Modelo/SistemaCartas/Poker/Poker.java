package Modelo.SistemaCartas.Poker;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Palo.Palo;
import Modelo.SistemaCartas.Poker.Figura.Figura;

public class Poker {
    // Atributos
    private  String nombre;  // As de Trebol
    private  Palo palo;
    private  Figura figura;
    private Puntaje puntaje;

    // Constructor
    public Poker(Palo palo, Figura figura) {

        this.palo = palo;
        this.figura = figura;
        this.puntaje = figura.asignarPuntaje();

        this.nombre = figura.getNombre() + " de " + palo.getNombre();
    }

    // Getters y Setters
    public Palo getPalo() {
        return this.palo;
    }

    public Figura getFigura(){
        return this.figura;
    }


    // Métodos


    // Privados

    private boolean miAnteriorCartaEs(Figura figuraActualCartaList){
        return figuraActualCartaList.miSiguienteFiguraEs(figura);
    }

    // Públicos

    public boolean laCartaSiguienteEs(Poker siguienteCartaList){
        return siguienteCartaList.miAnteriorCartaEs(figura);

    }





    public boolean esFiguraIgualA(Figura figura){
        return (this.figura.getNombre().equals(figura.getNombre()));
    }


    public void sumarPuntajeCon(Puntaje otroPuntaje){
        otroPuntaje.sumarNuevosChips(this.puntaje);
        otroPuntaje.sumarNuevoMultiplicador(this.puntaje);
    }

}