package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Tres;
import Modelo.SistemaCartas.Cartas.Figura.Cuatro;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCuatro {

    @Test
    public void test01CuatroEsIgualAConOtroCuatro() {
        // Arrange
        Figura cuatro1 = new Cuatro();
        Figura cuatro2 = new Cuatro();

        // Act
        boolean resultado = cuatro1.esIgualA(cuatro2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02CuatroNoEsIgualAConOtraFigura() {
        // Arrange
        Figura cuatro = new Cuatro();
        Figura otraFigura = new Tres();

        // Act
        boolean resultado = cuatro.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeCuatroEs4() {
        // Arrange
        Figura cuatro = new Cuatro();

        // Act
        int orden = cuatro.orden();

        // Assert
        assertEquals(4, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor4YMultiplicador1() {
        // Arrange
        Figura cuatro = new Cuatro();
        int valorEsperado = 4;

        // Act
        Puntaje puntaje = cuatro.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsTres() {
        // Arrange
        Figura cuatro = new Cuatro();
        Figura tres = new Tres();

        // Act
        boolean resultado = cuatro.miSiguienteFiguraEs(tres);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura cuatro = new Cuatro();
        Figura otraFigura = new Cuatro();

        // Act
        boolean resultado = cuatro.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}