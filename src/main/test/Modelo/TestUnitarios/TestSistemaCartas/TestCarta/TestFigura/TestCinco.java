package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Figura;
import Modelo.SistemaCartas.Cartas.Figura.Cinco;
import Modelo.SistemaCartas.Cartas.Figura.Cuatro;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCinco {

    @Test
    public void test01EsIgualAConOtroCinco() {
        // Arrange
        Figura cinco1 = new Cinco();
        Figura cinco2 = new Cinco();

        // Act
        boolean resultado = cinco1.esIgualA(cinco2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02NoEsIgualAConOtraFigura() {
        // Arrange
        Figura cinco = new Cinco();
        Figura otraFigura = new Cuatro();

        // Act
        boolean resultado = cinco.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeCincoEs5() {
        // Arrange
        Figura cinco = new Cinco();

        // Act
        int orden = cinco.orden();

        // Assert
        assertEquals(5, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor5YMultiplicador1() {
        // Arrange
        Figura cinco = new Cinco();
        int valorEsperado = 5;

        // Act
        Puntaje puntaje = cinco.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsCuatro() {
        // Arrange
        Figura cinco = new Cinco();
        Figura cuatro = new Cuatro();

        // Act
        boolean resultado = cinco.miSiguienteFiguraEs(cuatro);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura cinco = new Cinco();
        Figura otraFigura = new Cinco();

        // Act
        boolean resultado = cinco.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}