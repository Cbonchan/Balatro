package Modelo.TestUnitarios.TestSistemaCartas.TestActivables.TestEfectos;

import Modelo.Usuario.Mano;

import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.Rey;
import Modelo.SistemaCartas.Cartas.Palo.Corazon;

import Modelo.SistemaPuntaje.Multiplicador;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.AumentarChips;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAumentarChips {

    @Test
    public void test01ActivarAumentaChipsEnMano() {
        // Arrange
        Carta carta = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta);
        // Se ocupa una mano "High Card (5,1)" y 10 chips de Rey = 15 (Base)

        AumentarChips aumentarChips = new AumentarChips();
        Multiplicador multiplicador = new Multiplicador(1);
        int incrementador = 5;
        int valorEsperado = 20;

        // Act
        aumentarChips.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test02ActivarNoAumentaChipsEnManoPorIncrementador0() {
        // Arrange
        Carta carta = new Carta(new Corazon(), new Rey());
        Mano mano = new Mano();
        mano.agregarCarta(carta);
        // Se ocupa una mano "High Card (5,1)" y 10 chips de Rey = 15 (Base)

        AumentarChips aumentarChips = new AumentarChips();
        Multiplicador multiplicador = new Multiplicador(2);
        int incrementador = 0;
        int valorEsperado = 15;

        // Act
        aumentarChips.activar(incrementador, multiplicador, mano);

        // Assert
        assertEquals(valorEsperado, mano.calcularPuntaje());
    }
}