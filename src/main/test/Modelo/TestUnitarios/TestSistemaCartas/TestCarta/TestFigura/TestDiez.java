package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaCartas.Cartas.Figura.Diez;
import Modelo.SistemaCartas.Cartas.Figura.Figura;
import Modelo.SistemaCartas.Cartas.Figura.Nueve;
import Modelo.SistemaPuntaje.Puntaje;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiez {

    @Test
    public void test01DiezEsIgualAConOtroDiez() {
        // Arrange
        Figura diez1 = new Diez();
        Figura diez2 = new Diez();

        // Act
        boolean resultado = diez1.esIgualA(diez2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02DiezNoEsIgualAConOtraFigura() {
        // Arrange
        Figura diez = new Diez();
        Figura otraFigura = new Nueve();

        // Act
        boolean resultado = diez.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeDiezEs10() {
        // Arrange
        Figura diez = new Diez();

        // Act
        int orden = diez.orden();

        // Assert
        assertEquals(10, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor10YMultiplicador1() {
        // Arrange
        Figura diez = new Diez();
        int valorEsperado = 10;

        // Act
        Puntaje puntaje = diez.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsNueve() {
        // Arrange
        Figura diez = new Diez();
        Figura nueve = new Nueve();

        // Act
        boolean resultado = diez.miSiguienteFiguraEs(nueve);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura diez = new Diez();
        Figura otraFigura = new Diez();

        // Act
        boolean resultado = diez.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}