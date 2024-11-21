package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Nueve extends  Figura {

    // Atributos
    private  final  int puntaje = 9;

    // Cnstructores
    public Nueve() {super("9");}

    // Métodos
    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Ocho);
    }





    @Override
    public int orden() {
        return 9;
    }


    @Override
    public int devolverPuntaje() {
        return 9;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Ocho;
    }
}

