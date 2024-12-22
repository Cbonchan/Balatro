package Modelo.TestUnitarios.TestSistemaCartas.TestCarta.TestPalo;

import Modelo.SistemaCartas.Cartas.Palo.Palo;
import Modelo.SistemaCartas.Cartas.Palo.Pica;
import Modelo.SistemaCartas.Cartas.Palo.Diamante;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestPica {

    @Test
    public void test01SomosMismoPaloConOtraPica() {
        // Arrange
        Palo pica1 = new Pica();
        Palo pica2 = new Pica();

        // Act
        boolean resultado = pica1.somosMismoPalo(pica2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02NoSomosMismoPaloConOtroPalo() {
        // Arrange
        Palo pica = new Pica();
        Palo diamante = new Diamante();

        // Act
        boolean resultado = pica.somosMismoPalo(diamante);

        // Assert
        assertFalse(resultado);
    }
}