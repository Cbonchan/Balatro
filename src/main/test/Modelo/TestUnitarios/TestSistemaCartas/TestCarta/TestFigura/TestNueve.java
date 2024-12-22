package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Ocho;
import Modelo.SistemaCartas.Cartas.Figura.Nueve;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNueve {

    @Test
    public void test01NueveEsIgualAConOtroNueve() {
        // Arrange
        Figura nueve1 = new Nueve();
        Figura nueve2 = new Nueve();

        // Act
        boolean resultado = nueve1.esIgualA(nueve2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02NueveNoEsIgualAConOtraFigura() {
        // Arrange
        Figura nueve = new Nueve();
        Figura otraFigura = new Ocho();

        // Act
        boolean resultado = nueve.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeNueveEs9() {
        // Arrange
        Figura nueve = new Nueve();

        // Act
        int orden = nueve.orden();

        // Assert
        assertEquals(9, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor9YMultiplicador1() {
        // Arrange
        Figura nueve = new Nueve();
        int valorEsperado = 9;

        // Act
        Puntaje puntaje = nueve.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsOcho() {
        // Arrange
        Figura nueve = new Nueve();
        Figura ocho = new Ocho();

        // Act
        boolean resultado = nueve.miSiguienteFiguraEs(ocho);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura nueve = new Nueve();
        Figura otraFigura = new Nueve();

        // Act
        boolean resultado = nueve.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}