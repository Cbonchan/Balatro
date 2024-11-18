package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Ocho extends  Figura{
    // Atributos
    private  final int puntaje = 8;

    // Constructores
    public Ocho() {
        super("8");
    }

    // Métodos
    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Siete);
    }




    @Override
    public int orden() {
        return 8;
    }

    @Override
    public int devolverPuntaje() {
        return 8;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Siete;
    }


}
