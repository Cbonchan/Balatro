package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.SumaPuntaje;

public class Sumador extends JokerGenerico {

    public Sumador(String nombre, String descripcion, int puntaje, int multiplicador) {
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto = new SumaPuntaje();// Multiplicador predeterminado.
    }

}
