package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Seis extends Figura {

    // Atributos
    private final int puntaje = 6;

    // Constructores
    public Seis() {
        super("6");
    }

    // Métodos
    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Cinco);
    }




    @Override
    public int orden() {
        return 6;
    }

    @Override
    public int devolverPuntaje() {
        return 6;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Cinco;
    }
}