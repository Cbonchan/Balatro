package Modelo.SistemaCartas.Activables.Tarot;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.CambiarChips;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.CambiarMult;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.EfectoEnCarta;
import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

public class MejoraCarta extends TarotEnCarta{

    public MejoraCarta(String nombre, String descripcion, int puntaje, Multiplicador multiplicador, EfectoEnCarta efecto){
        super(nombre,descripcion,puntaje, multiplicador, efecto);

    }

    @Override
    public void activar(Carta carta, String contexto) {
        this.efecto.activar(incrementador, multiplicador, carta);

    }


}
