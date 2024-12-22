package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Dos;
import Modelo.SistemaCartas.Cartas.Figura.Tres;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTres {

    @Test
    public void test01TresEsIgualAConOtroTres() {
        // Arrange
        Figura tres1 = new Tres();
        Figura tres2 = new Tres();

        // Act
        boolean resultado = tres1.esIgualA(tres2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02TresNoEsIgualAConOtraFigura() {
        // Arrange
        Figura tres = new Tres();
        Figura otraFigura = new Dos();

        // Act
        boolean resultado = tres.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeTresEs3() {
        // Arrange
        Figura tres = new Tres();

        // Act
        int orden = tres.orden();

        // Assert
        assertEquals(3, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor3YMultiplicador1() {
        // Arrange
        Figura tres = new Tres();
        int valorEsperado = 3;

        // Act
        Puntaje puntaje = tres.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsDos() {
        // Arrange
        Figura tres = new Tres();
        Figura dos = new Dos();

        // Act
        boolean resultado = tres.miSiguienteFiguraEs(dos);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura tres = new Tres();
        Figura otraFigura = new Tres();

        // Act
        boolean resultado = tres.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}