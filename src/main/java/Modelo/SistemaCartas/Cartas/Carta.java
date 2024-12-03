package Modelo.SistemaCartas.Cartas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Cartas.Palo.Palo;
import Modelo.SistemaCartas.Cartas.Figura.Figura;
import javafx.scene.image.Image;

import java.util.Objects;

public class Carta {
    // Atributos
    private  String nombre;
    private  Palo palo;
    private  Figura figura;
    private Puntaje puntaje;

    // Constructor
    public Carta(Palo palo, Figura figura) {

        this.palo = palo;
        this.figura = figura;
        this.puntaje = figura.asignarPuntaje();
        this.nombre = figura.getNombre() + " de " + palo.getNombre();
    }

    public Figura getFigura(){
        return this.figura;
    }


    // Métodos

    // Getters

    public int getValorNumChips(){
        return this.puntaje.obtenerChips();
    }

    public int getValorNumMultiplicador(){ return this.puntaje.obtenerMultiplicador();}


    // Privados

    // Post: Verifica si la carta anterior es la anterior en la secuencia
    private boolean miAnteriorCartaEs(Figura figuraActualCartaList){
        return figuraActualCartaList.miSiguienteFiguraEs(figura);
    }

    // Post: Verifica si la figura de la carta actual es igual a la figura de la carta siguiente
    private boolean esMismaFiguraQue(Figura figuraActualCartaList){
        return figuraActualCartaList.esIgualA(figura);
    }

    // Post: Verifica si el palo de la carta actual es igual al palo de la carta siguiente
    private  boolean miPaloEs(Palo paloActualCartaList){
        return  paloActualCartaList.somosMismoPalo(palo);
    }


    // Públicos

    //! Relacionados con la Figura

    // Post: Devuelve el nombre de la carta
    public  int obtenerOrden(){
        return figura.orden();
    }

    // Post: Verifica si la carta siguiente es la siguiente en la secuencia
    public boolean laCartaSiguienteEs(Carta siguienteCartaList){
        return siguienteCartaList.miAnteriorCartaEs(figura);
    }

    // Post: compara su figura con la figura de la carta siguiente
    public boolean tieneMismaFiguraQue(Carta siguienteCartaList){
        return siguienteCartaList.esMismaFiguraQue(figura);
    }

    // Post: compara su figura con  una figura
    public boolean esFiguraIgualA(Figura figura){
        return esMismaFiguraQue(figura);
    }


    //! Relacionados con el Palo

    // Post: compara su palo con el palo de la carta siguiente
    public  boolean laCartaSiguienteMismoPalo(Carta siguienteCartaList){
        return  siguienteCartaList.miPaloEs(palo);
    }


    //! Relacionados con el Puntaje

    // Post: suma  los puntos y el multiplicador del puntaje
    public void sumarPuntajeCon(Puntaje otroPuntaje){
        otroPuntaje.sumarNuevosChips(this.puntaje);
        otroPuntaje.sumarNuevoMultiplicador(this.puntaje);
    }

    // Post: cambia el puntaje
    public void cambiarPuntaje(int incremento, Multiplicador multiplicador){
        puntaje.cambiarPuntaje(incremento, multiplicador);
    }

    // Post: cambia el valor de los chips
    public void cambiarChip(int nuevoValorDeChip){
        puntaje.cambiarChip(nuevoValorDeChip);
    }

    // Post: cambia el valor del multiplicador
    public void cambiarMultiplicador(Multiplicador nuevoMultiplicador){
        this.puntaje.cambiarMultiplicador(nuevoMultiplicador);
    }



    //! Métodos JavaFX
    //post: devuelve una imagen correspondiente dependiendo de el estado de la carta
    public Image getImage(){
        String pathname = "images/"+this.figura.getNombre()+"_of_"+this.palo.getNombre()+".png";
        return new Image(Objects.requireNonNull(Carta.class.getResourceAsStream(pathname)));
    }

}