package Modelo.TestUnitarios.TestSistemaPuntaje;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Multiplicador;

public class TestMultiplicador {

    @Test
    public void test01ConstructorConValorPositivo() {
        // Arrange
        Multiplicador multiplicador = new Multiplicador(5);

        // Act
        int valor = multiplicador.valorNumerico();

        // Assert
        assertEquals(5, valor);
    }

    @Test
    public void test02SumarDosMultiplicadores() {
        // Arrange
        Multiplicador multiplicador1 = new Multiplicador(3);
        Multiplicador multiplicador2 = new Multiplicador(4);

        // Act
        Multiplicador resultado = multiplicador1.multiplicarCon(multiplicador2);

        // Assert
        assertEquals(12, resultado.valorNumerico());
    }

    @Test
    public void test03MultiplicarMultiplicadorConChip() {
        // Arrange
        Multiplicador multiplicador = new Multiplicador(5);
        Chip chip = new Chip(3);

        // Act
        int resultado = multiplicador.multiplicarCon(chip);

        // Assert
        assertEquals(15, resultado);
    }

    @Test
    public void test04SumarMultiplicadorConValorNegativo() {
        // Arrange
        Multiplicador multiplicador1 = new Multiplicador(5);
        Multiplicador multiplicador2 = new Multiplicador(-3);

        // Act
        Multiplicador resultado = multiplicador1.multiplicarCon(multiplicador2);

        // Assert
        assertEquals(-15, resultado.valorNumerico());
    }

    @Test
    public void test05MultiplicarMultiplicadorConChipCero() {
        // Arrange
        Multiplicador multiplicador = new Multiplicador(5);
        Chip chip = new Chip(0);

        // Act
        int resultado = multiplicador.multiplicarCon(chip);

        // Assert
        assertEquals(0, resultado);
    }
}