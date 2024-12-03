package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.Diez;
import Modelo.SistemaCartas.Cartas.Figura.Jota;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJota {

    @Test
    public void test01JotaEsIgualAConOtraJota() {
        // Arrange
        Figura jota1 = new Jota();
        Figura jota2 = new Jota();

        // Act
        boolean resultado = jota1.esIgualA(jota2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02JotaNoEsIgualAConOtraFigura() {
        // Arrange
        Figura jota = new Jota();
        Figura otraFigura = new Diez();

        // Act
        boolean resultado = jota.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeJotaEs11() {
        // Arrange
        Figura jota = new Jota();

        // Act
        int orden = jota.orden();

        // Assert
        assertEquals(11, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor10YMultiplicador1() {
        // Arrange
        Figura jota = new Jota();
        int valorEsperado = 10;

        // Act
        Puntaje puntaje = jota.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsDiez() {
        // Arrange
        Figura jota = new Jota();
        Figura diez = new Diez();

        // Act
        boolean resultado = jota.miSiguienteFiguraEs(diez);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura jota = new Jota();
        Figura otraFigura = new Jota();

        // Act
        boolean resultado = jota.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}