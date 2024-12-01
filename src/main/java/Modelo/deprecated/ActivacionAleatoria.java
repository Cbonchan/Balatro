package Modelo.deprecated;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;
import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

import java.util.Random;

public class ActivacionAleatoria implements Efecto {
    // Atributos
    private final Random random;
    private final int probabilidad;

    // Constructor
    public ActivacionAleatoria(int probabilidad, Random random) {
        this.probabilidad = probabilidad;
        this.random = random;

    }

    // Métodos

    // Privados
    private boolean seActiva(){
        return random.nextInt(this.probabilidad) == 0;
    }


    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Mano mano, int puntos) {
            if ( seActiva() ){
                if ( incrementador == 1){
                    mano.multiplicarMultiplicador(multiplicador);
                } else{
                    mano.aumentarChips(new Chip(incrementador));
                }
            }
    }
}


