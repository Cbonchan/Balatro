package Modelo.SistemaCartas.Poker.Figura;

// Impotaciones
import  Modelo.SistemaPuntaje.*;

public class Dos  extends Figura{

    // Atributos
    private final int puntaje = 2;

    // Constructor
    public Dos() {
        super("2");
    }

    // Metodos
    @Override
    public int orden() {
        return 2;
    }

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Dos;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof As);
    }


}