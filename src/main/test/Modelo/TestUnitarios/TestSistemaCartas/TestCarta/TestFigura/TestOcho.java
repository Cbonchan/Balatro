package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Siete;
import Modelo.SistemaCartas.Cartas.Figura.Ocho;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOcho {

    @Test
    public void test01OchoEsIgualAConOtroOcho() {
        // Arrange
        Figura ocho1 = new Ocho();
        Figura ocho2 = new Ocho();

        // Act
        boolean resultado = ocho1.esIgualA(ocho2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02OchoNoEsIgualAConOtraFigura() {
        // Arrange
        Figura ocho = new Ocho();
        Figura otraFigura = new Siete();

        // Act
        boolean resultado = ocho.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeOchoEs8() {
        // Arrange
        Figura ocho = new Ocho();

        // Act
        int orden = ocho.orden();

        // Assert
        assertEquals(8, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor8YMultiplicador1() {
        // Arrange
        Figura ocho = new Ocho();
        int valorEsperado = 8;

        // Act
        Puntaje puntaje = ocho.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsSiete() {
        // Arrange
        Figura ocho = new Ocho();
        Figura siete = new Siete();

        // Act
        boolean resultado = ocho.miSiguienteFiguraEs(siete);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura ocho = new Ocho();
        Figura otraFigura = new Ocho();

        // Act
        boolean resultado = ocho.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}