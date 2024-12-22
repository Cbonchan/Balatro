package Modelo.TestUnitarios.TestUsuario;

import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.*;
import Modelo.SistemaCartas.Cartas.Palo.*;

import Modelo.SistemaCartas.Jugadas.*;

import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Multiplicador;

import Modelo.Usuario.Mano;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMano {

    // Relacionados con Jugador

    @Test
    public void test01AgregarUnaCartaALaMano() {
        // Arrange
        Mano mano = new Mano();
        Carta carta = new Carta(new Corazon(), new Reina());
        int cartasEnMano = 1;

        // Act
        mano.agregarCarta(carta);

        // Assert
        assertEquals(cartasEnMano, mano.obtenerCartas().size());
    }

    @Test
    public void test02SeLasVacíaLasCartasQueEstabanEnLaMano() {
        // Arrange
        Mano mano = new Mano();
        Carta carta = new Carta(new Corazon(), new Reina());
        mano.agregarCarta(carta);
        int cartasEnMano = 0;

        // Act
        mano.vaciarMano();

        // Assert
        assertEquals(cartasEnMano, mano.obtenerCartas().size());
    }

    @Test
    public void test03CalcularPuntajeDeUnaJugadaHighCardConReina() {
        // Arrange
        Mano mano = new Mano();
        Carta carta = new Carta(new Corazon(), new Reina());
        mano.agregarCarta(carta);
        int puntajeEsperado = 15;

        // Act
        float puntaje = mano.calcularPuntaje();

        // Assert
        assertEquals(puntajeEsperado, puntaje);
    }

    // Relacionados con Chip

    @Test
    public void test04AumentarChipsEn5ConJugadaHighCardConReina() {
        // Arrange
        Mano mano = new Mano();
        Chip incremento = new Chip(5);
        Carta carta = new Carta(new Corazon(), new Reina());
        mano.agregarCarta(carta);
        int puntajeEsperado = 20;

        // Act
        mano.aumentarChips(incremento);

        // Assert
        assertEquals(puntajeEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test05CambiarChipDeLaPrimeraCartaSeleccionada() {
        // Arrange
        Mano mano = new Mano();
        Carta carta = new Carta(new Corazon(), new Reina());
        mano.agregarCarta(carta);
        int puntajeEsperado = 6;

        // Act
        mano.cambiarChipPor(1);

        // Assert
        assertEquals(puntajeEsperado, mano.calcularPuntaje());
    }

    // Relacionados con Multiplicador

    @Test
    public void test06SumarMultiplicadorDeLaJugadaConOtroMultiplicador() {
        // Arrange
        Mano mano = new Mano();
        Carta carta = new Carta(new Corazon(), new Reina());
        Multiplicador incremento = new Multiplicador(2);
        mano.agregarCarta(carta);
        int puntajeEsperado = 45;

        // Act
        mano.sumarMultiplicador(incremento);

        // Assert
        assertEquals(puntajeEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test07MultiplicarMultiplicadorDeLaJugadaConOtroMultiplicador() {
        // Arrange
        Mano mano = new Mano();
        Carta carta = new Carta(new Corazon(), new Reina());
        Multiplicador incremento = new Multiplicador(3);
        mano.agregarCarta(carta);
        int puntajeEsperado = 45;

        // Act
        mano.multiplicarMultiplicador(incremento);

        // Assert
        assertEquals(puntajeEsperado, mano.calcularPuntaje());
    }

    @Test
    public void test08CambiarMultiplicadorDeLaPrimeraCartaEnLaManoPorElEntregadoPorParámetro() {
        // Arrange
        Mano mano = new Mano();
        Carta carta = new Carta(new Corazon(), new Reina());
        Multiplicador nuevoMultiplicador = new Multiplicador(4);
        mano.agregarCarta(carta);
        int puntajeEsperado = 60;

        // Act
        mano.cambiarMultiplicadorPor(nuevoMultiplicador);

        // Assert
        assertEquals(puntajeEsperado, mano.calcularPuntaje());
    }

    // Relacionados a determinarJugada

    @Test
    public void test09DeterminarCorrectamenteQueLaJugadaEsRoyalFlush() {
        // Arrange
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(new Corazon(), new Rey()));
        mano.agregarCarta(new Carta(new Corazon(), new Reina()));
        mano.agregarCarta(new Carta(new Corazon(), new Jota()));
        mano.agregarCarta(new Carta(new Corazon(), new Diez()));
        mano.agregarCarta(new Carta(new Corazon(), new As()));

        // Act
        Jugada jugada = mano.obtenerJugada();

        // Assert
        assertTrue(jugada instanceof RoyalFlush);
    }

    @Test
    public void test10DeterminarCorrectamenteQueLaJugadaEsFourOfAKind() {
        // Arrange
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(new Corazon(), new Rey()));
        mano.agregarCarta(new Carta(new Diamante(), new Rey()));
        mano.agregarCarta(new Carta(new Trebol(), new Rey()));
        mano.agregarCarta(new Carta(new Pica(), new Rey()));
        mano.agregarCarta(new Carta(new Corazon(), new Reina()));

        // Act
        Jugada jugada = mano.obtenerJugada();

        // Assert
        assertTrue(jugada instanceof FourOfAKind);
    }

    @Test
    public void test11DeterminarCorrectamenteQueLaJugadaEsFullHouse() {
        // Arrange
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(new Corazon(), new Rey()));
        mano.agregarCarta(new Carta(new Diamante(), new Rey()));
        mano.agregarCarta(new Carta(new Trebol(), new Rey()));
        mano.agregarCarta(new Carta(new Corazon(), new Reina()));
        mano.agregarCarta(new Carta(new Diamante(), new Reina()));

        // Act
        Jugada jugada = mano.obtenerJugada();

        // Assert
        assertTrue(jugada instanceof FullHouse);
    }
}