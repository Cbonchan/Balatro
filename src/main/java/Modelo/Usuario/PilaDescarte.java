package Modelo.Usuario;

import Modelo.SistemaCartas.Poker.*;

import java.util.ArrayList;
import java.util.List;

public class PilaDescarte {
    List<Carta> cartasDescartadas;
    int cantidadManosDescartadas;

    public PilaDescarte(){
        cartasDescartadas = new ArrayList<>();
        cantidadManosDescartadas = 0;
    }
    public int cantidadManosDescartadas(){
        return cantidadManosDescartadas;
    }

    public void descartarMano(Mano mano){
        List<Carta> cartas = new ArrayList<>();
        cartas = mano.cartasAcumuladas(cartas);
        cartasDescartadas.addAll(cartas);
        cantidadManosDescartadas++;

    }

    public void reinsertarEnMazo(Mazo mazo){
        mazo.reinsertarCartas(cartasDescartadas);
        cartasDescartadas.clear();
    }


}
