package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Jota;
import Modelo.SistemaCartas.Cartas.Figura.Reina;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReina {

    @Test
    public void test01ReinaEsIgualAConOtraReina() {
        // Arrange
        Figura reina1 = new Reina();
        Figura reina2 = new Reina();

        // Act
        boolean resultado = reina1.esIgualA(reina2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02ReinaNoEsIgualAConOtraFigura() {
        // Arrange
        Figura reina = new Reina();
        Figura otraFigura = new Jota();

        // Act
        boolean resultado = reina.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeReinaEs12() {
        // Arrange
        Figura reina = new Reina();

        // Act
        int orden = reina.orden();

        // Assert
        assertEquals(12, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor10YMultiplicador1() {
        // Arrange
        Figura reina = new Reina();
        int valorEsperado = 10;

        // Act
        Puntaje puntaje = reina.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsJota() {
        // Arrange
        Figura reina = new Reina();
        Figura jota = new Jota();

        // Act
        boolean resultado = reina.miSiguienteFiguraEs(jota);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura reina = new Reina();
        Figura otraFigura = new Reina();

        // Act
        boolean resultado = reina.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}