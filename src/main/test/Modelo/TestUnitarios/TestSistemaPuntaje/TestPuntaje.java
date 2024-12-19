package Modelo.TestUnitarios.TestSistemaPuntaje;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.SistemaPuntaje.*;

public class TestPuntaje {

    @Test
    public void test01ConstructorConChip() {
        // Arrange
        Chip chip = new Chip(5);
        Puntaje puntaje = new Puntaje(chip);

        // Act
        float valorChip = puntaje.calcularPuntaje();

        // Assert
        assertEquals(5, valorChip);
    }

    @Test
    public void test02ConstructorConChipYMultiplicador() {
        // Arrange
        Chip chip = new Chip(5);
        Multiplicador multiplicador = new Multiplicador(2);
        Puntaje puntaje = new Puntaje(chip, multiplicador);

        // Act
        float valorPuntaje = puntaje.calcularPuntaje();

        // Assert
        assertEquals(10, valorPuntaje);
    }

    @Test
    public void test03SumarNuevosChips() {
        // Arrange
        Chip chip1 = new Chip(5);
        Chip chip2 = new Chip(3);
        Puntaje puntaje1 = new Puntaje(chip1);
        Puntaje puntaje2 = new Puntaje(chip2);

        // Act
        puntaje1.sumarNuevosChips(puntaje2);
        float valorPuntaje = puntaje1.calcularPuntaje();

        // Assert
        assertEquals(8, valorPuntaje);
    }

    @Test
    public void test04SumarNuevoMultiplicador() {
        // Arrange
        Chip chip = new Chip(5);
        Multiplicador multiplicador1 = new Multiplicador(2);
        Multiplicador multiplicador2 = new Multiplicador(3);
        Puntaje puntaje1 = new Puntaje(chip, multiplicador1);
        Puntaje puntaje2 = new Puntaje(chip, multiplicador2);

        // Act
        puntaje1.sumarNuevoMultiplicador(puntaje2);
        float valorPuntaje = puntaje1.calcularPuntaje();

        // Assert
        assertEquals(30, valorPuntaje);
    }

    @Test
    public void test05CalcularPuntajeConMultiplicador() {
        // Arrange
        Chip chip = new Chip(5);
        Multiplicador multiplicador = new Multiplicador(4);
        Puntaje puntaje = new Puntaje(chip, multiplicador);

        // Act
        float valorPuntaje = puntaje.calcularPuntaje();

        // Assert
        assertEquals(20, valorPuntaje);
    }
}