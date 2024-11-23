package Modelo.TestUnitarios.TestSistemaPuntaje;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaPuntaje.Chip;

public class TestChip {

    @Test
    public void test01ConstructorConValorPositivo() {
        // Arrange
        Chip chip = new Chip(5);

        // Act
        int valor = chip.valorNumerico();

        // Assert
        assertEquals(5, valor);
    }

    @Test
    public void test02SumarDosChips() {
        // Arrange
        Chip chip1 = new Chip(3);
        Chip chip2 = new Chip(4);

        // Act
        Chip resultado = chip1.sumar(chip2);

        // Assert
        assertEquals(7, resultado.valorNumerico());
    }

    @Test
    public void test03MultiplicarChipPorNumero() {
        // Arrange
        Chip chip = new Chip(5);

        // Act
        int resultado = chip.multiplicarCon(3);

        // Assert
        assertEquals(15, resultado);
    }

    @Test
    public void test04SumarChipConValorNegativo() {
        // Arrange
        Chip chip1 = new Chip(5);
        Chip chip2 = new Chip(-3);

        // Act
        Chip resultado = chip1.sumar(chip2);

        // Assert
        assertEquals(2, resultado.valorNumerico());
    }

    @Test
    public void test05MultiplicarChipPorCero() {
        // Arrange
        Chip chip = new Chip(5);

        // Act
        int resultado = chip.multiplicarCon(0);

        // Assert
        assertEquals(0, resultado);
    }
}