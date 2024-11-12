package TP;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<CartaPoker> cartaPokers;
    private Jugada jugada;

    public Mano() {
        this.cartaPokers = new ArrayList<>();
    }

    public void agregarCarta(CartaPoker cartaPoker) {
        if (cartaPokers.size() < 5) {
            cartaPokers.add(cartaPoker);
        } else {
            throw new IllegalStateException("La mano ya tiene 5 cartas.");
        }
        // Se actualiza la jugada en cada agregado de carta
        jugada = Manejador.determinarJugada(cartaPokers);
    }

    public void vaciarMano() {
        cartaPokers.clear();
    }

    // El multiplicador y puntaje ahora lo tendría Jugada, los metodos de abajo no tienen que manejarse aca

    public void aumentarMultiplicador(int multiplicador) {
        this.multiplicador += multiplicador;
    }

    public int calcularPuntaje() {
        for (CartaPoker cartaPoker : cartaPokers) {
            puntaje = cartaPoker.sumarValorAgregadoPuntuacion(puntaje);
        }
        return (puntaje *= multiplicador);
    }


}
