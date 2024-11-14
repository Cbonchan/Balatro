package TP;

import java.util.List;

public class Puntuador {
    int puntaje = 0 ;
    int multiplicador =  0;
    Jugada jugada;

    public Puntuador(Jugada jugada){
        this.jugada = jugada;
    }

    public int calcularSumatoriaChips(List<CartaPoker> cartaPokers){
        puntaje = jugada.puntajeJugada();
        for (CartaPoker cartaPoker : cartaPokers) {
            puntaje = cartaPoker.sumarValorAgregadoPuntuacion(puntaje);
        }
        return puntaje;
    }

    public int calcularSumatoriaMultiplicadores(List<CartaPoker> cartaPokers){
        multiplicador = jugada.multiplicadorJugada();
        for (CartaPoker cartaPoker : cartaPokers) {
            multiplicador = cartaPoker.sumarValorAgregadoMultiplicador(multiplicador);
        }
        return multiplicador;
    }

    public int calcularPuntaje(List<CartaPoker> cartaPokers){
        return (calcularSumatoriaChips(cartaPokers) * calcularSumatoriaMultiplicadores(cartaPokers));
    }
}
