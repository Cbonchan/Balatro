package Modelo.TestUnitarios.TestSistemaCartas.TestJugadas;

import java.util.List;
import org.junit.Test;


import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Jugadas.Straight;

import static org.junit.jupiter.api.Assertions.*;

public class TestStraight {

    @Test
    public void test01JugadaValidaConCartasNoConsecutivas() {
        // Arrange
        Straight straight = new Straight();
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new Cinco()),
                new Poker(new Pica(), new Dos()),
                new Poker(new Corazon(), new Tres()),
                new Poker(new Trebol(), new Cuatro()),
                new Poker(new Diamante(), new Seis())
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
        Poker carta1 = new Poker(new Diamante(), new Diez() );
        Poker carta2 = new Poker(new Pica(), new Jota() );
        Poker carta3 = new Poker(new Corazon(), new Reina() );
        Poker carta4 = new Poker(new Trebol(), new Rey() );
        Poker carta5 = new Poker(new Diamante(), new As() );
        List<Poker> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
        Poker cartaDeMayorOrden = straight.cartasJugadas(cartas).get(0);

        // Assert
        assertEquals(carta5, cartaDeMayorOrden);
    }

    @Test
    public void test03CartaDeMayorOrdenEs5ConEscaleraDeAsA5() {
        // Arrange
        Straight straight = new Straight();
        Poker carta1 = new Poker(new Diamante(), new As());
        Poker carta2 = new Poker(new Pica(), new Dos());
        Poker carta3 = new Poker(new Corazon(), new Cuatro());
        Poker carta4 = new Poker(new Trebol(), new Cinco());
        Poker carta5 = new Poker(new Diamante(), new Tres());
        List<Poker> cartas = List.of(carta1, carta2, carta3, carta4, carta5);

        // Act
         Poker cartaDeMayorOrden = straight.cartasJugadas(cartas).get(0);

        // Assert
        assertEquals(carta4, cartaDeMayorOrden);
    }

    @Test
    public void test04JugadaNoValidaConCuatroCartas() {
        // Arrange
        Straight straight = new Straight();
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new As()),
                new Poker(new Pica(), new Dos()),
                new Poker(new Corazon(), new Tres()),
                new Poker(new Trebol(), new Cuatro())
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
        List<Poker> cartas = List.of(
                new Poker(new Diamante(), new As()),
                new Poker(new Pica(), new Dos()),
                new Poker(new Corazon(), new Tres()),
                new Poker(new Trebol(), new Cuatro()),
                new Poker(new Diamante(), new Seis())
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
    List<Poker> cartas = List.of(
            new Poker(new Diamante(), new Seis()),
            new Poker(new Pica(), new Siete()),
            new Poker(new Corazon(), new Ocho()),
            new Poker(new Trebol(), new Nueve()),
            new Poker(new Diamante(), new Diez())
    );

    // Act
    boolean esValida = straight.esJugadaValida(cartas);

    // Assert
    assertTrue(esValida);
}

}
