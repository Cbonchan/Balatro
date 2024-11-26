package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.SumaPuntaje;

public class Sumador extends Joker {

    public Sumador(String nombre, String descripcion, int puntaje, int multiplicador) {
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto = new SumaPuntaje();// Multiplicador predeterminado.
    }

}
