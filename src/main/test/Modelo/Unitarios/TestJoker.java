package Modelo.Unitarios;


import Modelo.SistemaCartas.Joker.Joker;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.Efecto;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoJugada;
import Modelo.SistemaPuntaje.Multiplicador;
import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJoker {

    @Test
    public void test01ComodinNormalSuma8AlMultiplicadorCorrectamente(){
        Multiplicador multiplicador = new Multiplicador(1);

        EfectoJugada efecto = new EfectoJugada();

        Joker joker = new Joker(1, "Joker multiplicador",
                "Suma 8 al multiplicador",8, efecto);

        joker.activar(multiplicador);
        int valorEsperado =  9;
        int valorObtenido = multiplicador.valorNumerico();

        assertEquals(valorEsperado,valorObtenido);
    }


}
