package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestPalo;

import Modelo.SistemaCartas.Cartas.Palo.Palo;
import Modelo.SistemaCartas.Cartas.Palo.Trebol;
import Modelo.SistemaCartas.Cartas.Palo.Corazon;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestCorazon {

    @Test
    public void test01SomosMismoPaloConOtroCorazon() {
        // Arrange
        Palo corazon1 = new Corazon();
        Palo corazon2 = new Corazon();

        // Act
        boolean resultado = corazon1.somosMismoPalo(corazon2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02NoSomosMismoPaloConOtroPalo() {
        // Arrange
        Palo corazon = new Corazon();
        Palo trebol = new Trebol();

        // Act
        boolean resultado = corazon.somosMismoPalo(trebol);

        // Assert
        assertFalse(resultado);
    }
}