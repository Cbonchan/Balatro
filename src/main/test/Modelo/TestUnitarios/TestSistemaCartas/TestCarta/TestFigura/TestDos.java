package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestFigura;

import Modelo.SistemaPuntaje.Puntaje;

import Modelo.SistemaCartas.Cartas.Figura.As;
import Modelo.SistemaCartas.Cartas.Figura.Dos;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDos {

    @Test
    public void test01DosEsIgualAConOtroDos() {
        // Arrange
        Figura dos1 = new Dos();
        Figura dos2 = new Dos();

        // Act
        boolean resultado = dos1.esIgualA(dos2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02DosNoEsIgualAConOtraFigura() {
        // Arrange
        Figura dos = new Dos();
        Figura otraFigura = new As();

        // Act
        boolean resultado = dos.esIgualA(otraFigura);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void test03ElOrdenDeDosEs2() {
        // Arrange
        Figura dos = new Dos();

        // Act
        int orden = dos.orden();

        // Assert
        assertEquals(2, orden);
    }

    @Test
    public void test04AsignarPuntajeCreaUnPuntajeConValor2YMultiplicador1() {
        // Arrange
        Figura dos = new Dos();
        int valorEsperado = 2;

        // Act
        Puntaje puntaje = dos.asignarPuntaje();

        // Assert
        assertEquals(valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test05MiSiguienteFiguraEsAs() {
        // Arrange
        Figura dos = new Dos();
        Figura as = new As();

        // Act
        boolean resultado = dos.miSiguienteFiguraEs(as);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06MiSiguienteFiguraNoEsOtraFigura() {
        // Arrange
        Figura dos = new Dos();
        Figura otraFigura = new Dos();

        // Act
        boolean resultado = dos.miSiguienteFiguraEs(otraFigura);

        // Assert
        assertFalse(resultado);
    }
}