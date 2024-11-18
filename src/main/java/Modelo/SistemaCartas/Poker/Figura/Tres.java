package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Tres extends  Figura{

    // Atributos
    private  final  int puntaje = 3;

    // Constructor
    public Tres() {super("3");}

    // Métodos
    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Dos);
    }





    @Override
    public int orden() {
        return 3;
    }

    @Override
    public int devolverPuntaje() {
        return 3;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Dos;
    }

}
