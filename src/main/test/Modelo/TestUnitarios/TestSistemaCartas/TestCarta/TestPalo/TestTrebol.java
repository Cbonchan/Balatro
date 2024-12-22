package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestPalo;

import Modelo.SistemaCartas.Cartas.Palo.Palo;
import Modelo.SistemaCartas.Cartas.Palo.Trebol;
import Modelo.SistemaCartas.Cartas.Palo.Corazon;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestTrebol {

    @Test
    public void test01SomosMismoPaloConOtroTrebol() {
        // Arrange
        Palo trebol1 = new Trebol();
        Palo trebol2 = new Trebol();

        // Act
        boolean resultado = trebol1.somosMismoPalo(trebol2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02NoSomosMismoPaloConOtroPalo() {
        // Arrange
        Palo trebol = new Trebol();
        Palo corazon = new Corazon();

        // Act
        boolean resultado = trebol.somosMismoPalo(corazon);

        // Assert
        assertFalse(resultado);
    }
}