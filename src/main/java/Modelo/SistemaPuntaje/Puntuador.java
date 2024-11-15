package Modelo.SistemaPuntaje;

// Importaciones
import Modelo.SistemaCartas.Jugadas.Jugada;
import Modelo.SistemaCartas.Poker.CartaPoker;

import java.util.List;

public class Puntuador {

    // Atributos
    int puntaje = 0 ;
    int multiplicador =  0;
    Jugada jugada;

    // Constructor
    public Puntuador(Jugada jugada){
        this.jugada = jugada;
    }

    // Métodos
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
