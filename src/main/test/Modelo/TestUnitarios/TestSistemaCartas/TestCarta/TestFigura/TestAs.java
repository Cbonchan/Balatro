package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.As;
import Modelo.SistemaCartas.Cartas.Figura.Rey;
import Modelo.SistemaCartas.Cartas.Figura.Figura;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAs {

    @Test
    public void test01AsEsIgualAConOtroAs() {
        // Arrange
        Figura as1 = new As();
        Figura as2 = new As();

        // Act
        boolean resultado = as1.esIgualA(as2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02AsNoEsIgualAConOtraFigura() {
        // Arrange
        Figura as = new As();
        Figura otraFigura = new Rey();

        // Act
        boolean resultado = as.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeAsEs1() {
        // Arrange
        Figura as = new As();

        // Act
        int orden = as.orden();

        // Assert
        assertEquals(1, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor11YMultiplicador1() {
        // Arrange
        Figura as = new As();
        int valorEsperado = 11;

        // Act
        Puntaje puntaje = as.asignarPuntaje();


        // Assert
        assertEquals( valorEsperado, puntaje.calcularPuntaje() );
    }

    @Test
    public void test05MiSiguienteFiguraEsRey() {
        // Arrange
        Figura as = new As();
        Figura rey = new Rey();

        // Act
        boolean resultado = as.miSiguienteFiguraEs(rey);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura as = new As();
        Figura otraFigura = new As();

        // Act
        boolean resultado = as.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}