package Modelo.TestUnitarios.TestUsuario;

import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.Usuario.Mazo;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class TestMazo {

    @Test
    public void test01SeEntregan8CartasCorrectamente() {
        // Arrange
        Mazo mazo = new Mazo();
        List<Carta> cartasACompletar = new ArrayList<>();

        // Act
        mazo.repartirCartas(cartasACompletar);

        // Assert
        assertEquals(8, cartasACompletar.size());
    }

    @Test
    public void test02CartasDisponiblesEnElMazoDespuesDeRepartir() {
        // Arrange
        Mazo mazo = new Mazo();
        List<Carta> cartasACompletar = new ArrayList<>();
        mazo.repartirCartas(cartasACompletar);

        // Act
        int cartasDisponibles = mazo.getCartasDisponibles();

        // Assert
        assertEquals(44, cartasDisponibles);
    }

    @Test
    public void test03ReinsertarCartasEnElMazo() {
        // Arrange
        Mazo mazo = new Mazo();
        List<Carta> cartasAReinsertar = new ArrayList<>();
        mazo.repartirCartas(cartasAReinsertar);

        // Act
        mazo.reinsertarCartas(cartasAReinsertar);

        // Assert
        assertEquals(52, mazo.getCartasDisponibles());
    }
}