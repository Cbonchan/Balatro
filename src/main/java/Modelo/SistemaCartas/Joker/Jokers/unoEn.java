package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoAutodestruccion;

import java.util.Random;

public class unoEn extends JokerGenerico {

    public unoEn(String nombre, String descripcion, int puntaje, int multiplicador, int probabilidad){
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto = new EfectoAutodestruccion(probabilidad, new Random());
    }
}
