package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoDescarte;

public class Descarte extends JokerGenerico {
    public Descarte(String nombre, String descripcion, int puntaje, int multiplicador){
        super(nombre,descripcion,puntaje,multiplicador);
        this.efecto = new EfectoDescarte();
    }


}