package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestPalo;

import Modelo.SistemaCartas.Cartas.Palo.Corazon;
import Modelo.SistemaCartas.Cartas.Palo.Palo;
import Modelo.SistemaCartas.Cartas.Palo.Diamante;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestDiamante {

    @Test
    public void test01SomosMismoPaloConOtroDiamante() {
        // Arrange
        Palo diamante1 = new Diamante();
        Palo diamante2 = new Diamante();

        // Act
        boolean resultado = diamante1.somosMismoPalo(diamante2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02NoSomosMismoPaloConOtroPalo() {
        // Arrange
        Palo diamante = new Diamante();
        Palo corazon = new Corazon();

        // Act
        boolean resultado = diamante.somosMismoPalo(corazon);

        // Assert
        assertFalse(resultado);
    }
}