package Modelo.SistemaCartas.Tarot;

// Importaciones
import Modelo.SistemaCartas.Poker.Poker;

public class Tarot {

    // Atributos
    private final int chips;
    private final int multiplicador;

    // Constructor
    public Tarot(int chips, int multiplicador) {
        this.chips = chips;
        this.multiplicador = multiplicador;
    }

    // Métodos públicos
    public void cambiarPuntaje(Poker carta) {
        if (carta == null) {
            throw new IllegalArgumentException("La carta no puede ser nula.");
        }
       // carta.setPuntaje(chips);
    }

    public void cambiarMultiplicador(Poker carta) {
        //carta.setMultiplicador(multiplicador);
    }

}
