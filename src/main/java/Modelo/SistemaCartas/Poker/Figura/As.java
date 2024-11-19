package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class As extends Figura {

    // Atributos
    private  final int puntaje = 11;


    // Constructor
    public As() {
        super("As");
    }

    // Métodos
    @Override
    public int orden() {
        return 1;
    }

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
     public  boolean esIgualA(Figura figura){
        return figura instanceof As;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Rey);
    }

}


/// tarot.usar(cartaPoker)
// cartaPoker.modificarPuntaje