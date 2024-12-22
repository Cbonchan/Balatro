package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Cinco;
import Modelo.SistemaCartas.Cartas.Figura.Seis;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSeis {

    @Test
    public void test01SeisEsIgualAConOtroSeis() {
        // Arrange
        Figura seis1 = new Seis();
        Figura seis2 = new Seis();

        // Act
        boolean resultado = seis1.esIgualA(seis2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02SeisNoEsIgualAConOtraFigura() {
        // Arrange
        Figura seis = new Seis();
        Figura otraFigura = new Cinco();

        // Act
        boolean resultado = seis.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeSeisEs6() {
        // Arrange
        Figura seis = new Seis();

        // Act
        int orden = seis.orden();

        // Assert
        assertEquals(6, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor6YMultiplicador1() {
        // Arrange
        Figura seis = new Seis();
        int valorEsperado = 6;

        // Act
        Puntaje puntaje = seis.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsCinco() {
        // Arrange
        Figura seis = new Seis();
        Figura cinco = new Cinco();

        // Act
        boolean resultado = seis.miSiguienteFiguraEs(cinco);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura seis = new Seis();
        Figura otraFigura = new Seis();

        // Act
        boolean resultado = seis.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}