package Modelo.Factories;

import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.*;
import Modelo.SistemaCartas.Cartas.Palo.*;

public class CartaFactory {

    public static Carta crearCarta(String paloIngresado, String figuraIngresada){
        Palo palo;
        Figura figura;

        if (paloIngresado.equals("Trebol")){
             palo = new Trebol();
        } else if (paloIngresado.equals("Corazones")){
             palo = new Corazon();
        } else if (paloIngresado.equals("Picas")){
             palo = new Pica();
        } else if (paloIngresado.equals("Diamantes")){
             palo = new Diamante();
        } else {
            throw new IllegalArgumentException("Palo inválido: " + paloIngresado);
        }

        if (figuraIngresada.equals("As")){
            figura = new As();
        } else if (figuraIngresada.equals("2")){
            figura = new Dos();
        } else if (figuraIngresada.equals("3")){
            figura = new Tres();
        } else if(figuraIngresada.equals("4")){
            figura = new Cuatro();
        } else if (figuraIngresada.equals("5")){
            figura = new Cinco();
        } else if (figuraIngresada.equals("6")){
            figura = new Seis();
        } else if (figuraIngresada.equals("7")){
            figura = new Siete();
        } else if (figuraIngresada.equals("8")){
            figura = new Ocho();
        } else if (figuraIngresada.equals("9")){
            figura = new Nueve();
        } else if (figuraIngresada.equals("10")){
            figura = new Diez();
        } else if (figuraIngresada.equals("Reina")){
            figura = new Reina();
        } else if (figuraIngresada.equals("Rey")){
            figura = new Rey();
        } else if (figuraIngresada.equals("Jota")){
            figura = new Jota();
        } else {
            throw new IllegalArgumentException("Figura inválida: " + figuraIngresada);
        }
        return new Carta(palo, figura);

    }

}
