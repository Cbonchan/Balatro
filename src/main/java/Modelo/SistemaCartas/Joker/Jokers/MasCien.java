package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoSuma;

public class MasCien extends JokerGenerico {

    public MasCien(String nombre, String descripcion, int puntaje, int multiplicador) {
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto = new EfectoSuma();// Multiplicador predeterminado.
    }

}
