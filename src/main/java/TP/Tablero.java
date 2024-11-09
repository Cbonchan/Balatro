package TP;
import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private List<Tarot> tarots;
    private Jugador jugador;
    //private List<jockers> jockers;

    public int jugarMano(Mano mano){
        return mano.calcularPuntaje();
    }

    public int calcularPuntajeFinal(){
        return 0;
    }
}
