package Modelo.TestUnitarios.TestSistemaCartas.TestActivables.TestTarots;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarCarta;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarJugada;
import Modelo.SistemaCartas.Activables.Tarot.MejoraCarta;
import Modelo.SistemaCartas.Activables.Tarot.MejoraJugada;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.Rey;
import Modelo.SistemaCartas.Cartas.Palo.Diamante;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTarot {



    @Test
    public void test01TarotCambiaLosPuntosDeUnaCartaA50() {

        // Arrange
        Carta carta1 = new Carta(new Diamante(), new Rey());

        MejoraCarta tarot = new MejoraCarta("Test01", "El puntaje pasa a ser 50",50, new Multiplicador(1), new MejorarCarta());

        // Act
        tarot.activar(carta1, "Sin contexto");
        // Assert
        int valorChipsObtenido = carta1.getValorNumChips(); //! TESTEO POR IMPLEMENTACION
        int valorChipsEsperado = 50;

        assertEquals(valorChipsEsperado, valorChipsObtenido);

    }


    @Test
    public void test02TarotCambiaElMultiplicadorDeUnaCartaA2() {

        // Arrange
        Carta carta1 = new Carta(new Diamante(), new Rey());

        MejoraCarta tarot = new MejoraCarta("Test02", "El multiplicador pasa a ser 2",10, new Multiplicador(2), new MejorarCarta());

        // Act
        tarot.activar(carta1, "Sin contexto");

        // Assert
        int valorMultiplicadorObtenido = carta1.getValorNumMultiplicador(); //! TESTEO POR IMPLEMENTACION
        int valorMultiplicadorEsperado = 2;

        assertEquals(valorMultiplicadorEsperado, valorMultiplicadorObtenido);

    }

//TODO: Este test falla porque todavia esa parte de Tarot no esta implementada con el refactor actual.
// Revisar la clase "CambiarPuntaje" de "SistemaDeEfecto" para mas detalles

    @Test
    public void test03tarotMejoraLaManoHighCardA20Puntos() {

        //Arrange
        Carta carta1 = new Carta(new Diamante(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta1);

        MejoraJugada tarot = new MejoraJugada("Test03", "Mejora high card", 20, new Multiplicador(5), new MejorarJugada("carta alta"));

        //Act
        tarot.activar(mano, "Sin contexto");


        //Assert
        assertEquals(20, mano.obtenerChips()); //! TESTEO POR IMPLEMENTACION
    }




}
