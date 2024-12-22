package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Seis;
import Modelo.SistemaCartas.Cartas.Figura.Siete;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSiete {

    @Test
    public void test01SieteEsIgualAConOtroSiete() {
        // Arrange
        Figura siete1 = new Siete();
        Figura siete2 = new Siete();

        // Act
        boolean resultado = siete1.esIgualA(siete2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02SieteNoEsIgualAConOtraFigura() {
        // Arrange
        Figura siete = new Siete();
        Figura otraFigura = new Seis();

        // Act
        boolean resultado = siete.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeSieteEs7() {
        // Arrange
        Figura siete = new Siete();

        // Act
        int orden = siete.orden();

        // Assert
        assertEquals(7, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor7YMultiplicador1() {
        // Arrange
        Figura siete = new Siete();
        int valorEsperado = 7;

        // Act
        Puntaje puntaje = siete.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsSeis() {
        // Arrange
        Figura siete = new Siete();
        Figura seis = new Seis();

        // Act
        boolean resultado = siete.miSiguienteFiguraEs(seis);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura siete = new Siete();
        Figura otraFigura = new Siete();

        // Act
        boolean resultado = siete.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}