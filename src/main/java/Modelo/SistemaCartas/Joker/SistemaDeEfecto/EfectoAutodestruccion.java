package Modelo.SistemaCartas.Joker.SistemaDeEfecto;

import Modelo.Jugador.Jugador;

public class EfectoAutodestruccion extends Efecto{
    public EfectoAutodestruccion() {
        super("Automatico");
    }
    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
        //todavia no se como hacer este efecto, no se me cae una idea
        //el check de activacion ya esta en
        return;
    }
}
