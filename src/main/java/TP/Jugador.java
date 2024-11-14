package TP;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int puntaje;
    private List<CartaPoker> cartas;
    private Mano mano;

    public Jugador(Mano mano)
    {
        this.puntaje = 0;
        this.cartas = new ArrayList<>();
        this.mano = mano;
    }
    //si se selecciona una mano pero te arrepentis, con este metodo la mano se vacia
    //solucion momentanea a tener que deseleccionar cartas una por una
    public void deshacerEleccion(){
        mano.vaciarMano();
    }

    public void seleccionarCarta(CartaPoker cartaPoker)
    {
        mano.agregarCarta(cartaPoker);
    }

    public void jugar(Tablero tablero)
    {
        int valor = tablero.jugarMano(mano);
        asignarPuntaje(valor);
    }

    public void agregarCartas(List<CartaPoker> cartasNuevas) {
        cartas.addAll(cartasNuevas);
    }

    private void asignarPuntaje(int puntajeEntrante)
    {
        puntaje += puntajeEntrante;
    }

    public int getCantidadCartas()
    {
        return cartas.size();
    }

    public int getPuntaje(){
        return puntaje;
    }

}
