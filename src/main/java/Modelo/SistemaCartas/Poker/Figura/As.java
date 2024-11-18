package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class As extends Figura {

    // Atributos
    private  final int puntaje = 11;

    // Constructor
    public As() { super("As");}

    // Métodos
    @Override
    public int orden() {
        return 1;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof  Rey;
    }


    // Esto es lo que esta en duda
    @Override
    public int devolverPuntaje() {
        return 11;
    }


    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }
}


/// tarot.usar(cartaPoker)
// cartaPoker.modificarPuntaje