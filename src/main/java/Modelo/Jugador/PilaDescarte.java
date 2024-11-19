package Modelo.Jugador;

import Modelo.SistemaCartas.Poker.*;

import java.util.ArrayList;
import java.util.List;

public class PilaDescarte {
    List<Mano> manosDescartadas;

    public PilaDescarte(){
        manosDescartadas = new ArrayList<>();
    }

    public int cantidadManosDescartadas(){
        return manosDescartadas.size();
    }

    public void descartarMano(Mano mano){
        manosDescartadas.add(mano);
        //TODO: momentaneamente ambas funciones hacen lo mismo, pero diferenciar
        //TODO: para el funcionamiento de jokers de descarte ETC.
    }

    //? Es realmente necesario?
    public void descartarManoJugada(Mano mano){
        manosDescartadas.add(mano);
        //TODO: momentaneamente ambas funciones hacen lo mismo, pero diferenciar
        //TODO: para el funcionamiento de jokers de descarte ETC.
    }

    public void reinsertarEnMazo(Mazo mazo){
        List<Poker> cartas = new ArrayList<>();
        for (Mano mano : manosDescartadas) {
            cartas = mano.cartasAcumuladas(cartas);
        }
        mazo.reinsertarCartas(cartas);
        manosDescartadas.clear();
    }


}
