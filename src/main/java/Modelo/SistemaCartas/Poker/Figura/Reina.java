package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import Modelo.SistemaPuntaje.*;

public class Reina extends Figura {

    // Atributos
    private  final int puntaje = 10;

    // Constructor
    public Reina() {super("Q");}

    // Métodos
    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Jota);
    }




    @Override
    public int orden() {
        return 12;
    }

    @Override
    public int devolverPuntaje() {
        return 10;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Jota;
    }

}