package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.Test;


import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Jugadas.Straight;

import static org.junit.jupiter.api.Assertions.*;

public class TestStraight {

    @Test
    public void test01JugadaValidaConCartasNoConsecutivas() {
        // Arrange
        Straight straight = new Straight();
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new Cinco()),
                new Carta(new Pica(), new Dos()),
                new Carta(new Corazon(), new Tres()),
                new Carta(new Trebol(), new Cuatro()),
                new Carta(new Diamante(), new Seis())
        );

        // Act
        boolean esValida = straight.esJugadaValida(cartas);

        // Assert
        assertTrue(esValida);
    }

    @Test
    public void test02CartaDeMayorOrdenEsAsConEscaleraReal() {
        // Arrange
        Straight straight = new Straight();
        Carta carta1 = new Carta(new Diamante(), new Diez() );
        Carta carta2 = new Carta(new Pica(), new Jota() );
        Carta carta3 = new Carta(new Corazon(), new Reina() );
        Carta carta4 = new Carta(new Trebol(), new Rey() );
        Carta carta5 = new Carta(new Diamante(), new As() );
        List<Carta> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
        Carta cartaDeMayorOrden = straight.cartasJugadas(cartas).get(0);

        // Assert
        assertEquals(carta5, cartaDeMayorOrden);
    }

    @Test
    public void test03CartaDeMayorOrdenEs5ConEscaleraDeAsA5() {
        // Arrange
        Straight straight = new Straight();
        Carta carta1 = new Carta(new Diamante(), new As());
        Carta carta2 = new Carta(new Pica(), new Dos());
        Carta carta3 = new Carta(new Corazon(), new Cuatro());
        Carta carta4 = new Carta(new Trebol(), new Cinco());
        Carta carta5 = new Carta(new Diamante(), new Tres());
        List<Carta> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
         Carta cartaDeMayorOrden = straight.cartasJugadas(cartas).get(0);

        // Assert
        assertEquals(carta4, cartaDeMayorOrden);
    }

    @Test
    public void test04JugadaNoValidaConCuatroCartas() {
        // Arrange
        Straight straight = new Straight();
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new As()),
                new Carta(new Pica(), new Dos()),
                new Carta(new Corazon(), new Tres()),
                new Carta(new Trebol(), new Cuatro())
        );

        // Act
        boolean esValida = straight.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
    public void test05JugadaNoValidaConCartasNoConsecutivas() {
        // Arrange
        Straight straight = new Straight();
        List<Carta> cartas = List.of(
                new Carta(new Diamante(), new As()),
                new Carta(new Pica(), new Dos()),
                new Carta(new Corazon(), new Tres()),
                new Carta(new Trebol(), new Cuatro()),
                new Carta(new Diamante(), new Seis())
        );

        // Act
        boolean esValida = straight.esJugadaValida(cartas);

        // Assert
        assertFalse(esValida);
    }

    @Test
public void test06JugadaValidaConCartasConsecutivasDeDistintosPalos() {
    // Arrange
    Straight straight = new Straight();
    List<Carta> cartas = List.of(
            new Carta(new Diamante(), new Seis()),
            new Carta(new Pica(), new Siete()),
            new Carta(new Corazon(), new Ocho()),
            new Carta(new Trebol(), new Nueve()),
            new Carta(new Diamante(), new Diez())
    );

    // Act
    boolean esValida = straight.esJugadaValida(cartas);

    // Assert
    assertTrue(esValida);
}

}
