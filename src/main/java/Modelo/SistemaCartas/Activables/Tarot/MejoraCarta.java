package Modelo.SistemaCartas.Activables.Tarot;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.CambiarChips;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.CambiarMult;
import Modelo.Usuario.Mano;

public class MejoraCarta extends Tarot{

    public MejoraCarta(String nombre, String descripcion, int puntaje, int multiplicador){
        super(nombre,descripcion,puntaje,multiplicador);

        if (this.multiplicador==1){
            this.efecto = new CambiarChips();
        }
        else{
            this.efecto = new CambiarMult();
        }
    }

    @Override
    public void activar(Mano mano, String contexto) {
        // Implementar
    }
}
