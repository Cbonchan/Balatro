package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Reina;
import Modelo.SistemaCartas.Cartas.Figura.Rey;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRey {

    @Test
    public void test01ReyEsIgualAConOtroRey() {
        // Arrange
        Figura rey1 = new Rey();
        Figura rey2 = new Rey();

        // Act
        boolean resultado = rey1.esIgualA(rey2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02ReyNoEsIgualAConOtraFigura() {
        // Arrange
        Figura rey = new Rey();
        Figura otraFigura = new Reina();

        // Act
        boolean resultado = rey.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeReyEs13() {
        // Arrange
        Figura rey = new Rey();

        // Act
        int orden = rey.orden();

        // Assert
        assertEquals(13, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor10YMultiplicador1() {
        // Arrange
        Figura rey = new Rey();
        int valorEsperado = 10;

        // Act
        Puntaje puntaje = rey.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsReina() {
        // Arrange
        Figura rey = new Rey();
        Figura reina = new Reina();

        // Act
        boolean resultado = rey.miSiguienteFiguraEs(reina);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura rey = new Rey();
        Figura otraFigura = new Rey();

        // Act
        boolean resultado = rey.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}