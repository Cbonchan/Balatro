package Modelo.Usuario;

import Modelo.SistemaCartas.Cartas.*;

import java.util.ArrayList;
import java.util.List;

public class PilaDescarte {
    List<Carta> cartasDescartadas;
    int cantidadManosDescartadas;

    public PilaDescarte(){
        cartasDescartadas = new ArrayList<>();
        cantidadManosDescartadas = 0;
    }

    public int getCantidadManosDescartadas(){
        return cantidadManosDescartadas;
    }

    public void descartarMano(Mano mano){
        List<Carta> cartas = new ArrayList<>();
        cartas = mano.cartasAcumuladas(cartas);
        cartasDescartadas.addAll(cartas);
        mano.vaciarMano();
        cantidadManosDescartadas++;
    }

    public void reinsertarEnMazo(Mazo mazo){
        mazo.reinsertarCartas(cartasDescartadas);
        cartasDescartadas.clear();
    }


}
