package Modelo.TestUnitarios.TestSistemaCartas.TestCarta;


import Modelo.SistemaCartas.Cartas.Palo.Corazon;
import Modelo.SistemaCartas.Cartas.Figura.Rey;
import Modelo.SistemaCartas.Cartas.Figura.Reina;
import Modelo.SistemaCartas.Cartas.Figura.Figura;

import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Puntaje;
import Modelo.SistemaPuntaje.Multiplicador;

import Modelo.SistemaCartas.Cartas.Carta;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCarta {

    // Privados

    @Test
    public void test01LaCartaSiguienteDeReyEsReinaEnEscalaDescendiente() {
        // Arrange
        Corazon corazon = new Corazon();
        Figura reina = new Reina();
        Figura rey = new Rey();
        Carta cartaReina = new Carta(corazon, reina);
        Carta cartaRey = new Carta(corazon, rey);

        // Act
        boolean resultado = cartaRey.laCartaSiguienteEs(cartaReina);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test02ReinaEsMismaFiguraQueReina() {
        // Arrange
        Corazon corazon = new Corazon();
        Figura reina1 = new Reina();
        Figura reina2 = new Reina();
        Carta cartaReina1 = new Carta(corazon, reina1);
        Carta cartaReina2 = new Carta(corazon, reina2);

        // Act
        boolean resultado = cartaReina1.tieneMismaFiguraQue(cartaReina2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test03CartaReconoceAOtraDelMismoPalo() {
        // Arrange
        Rey rey = new Rey();
        Corazon corazon = new Corazon();
        Carta carta1 = new Carta(corazon, rey);
        Carta carta2 = new Carta(corazon, rey);

        // Act
        boolean resultado = carta1.laCartaSiguienteMismoPalo(carta2);

        // Assert
        assertTrue(resultado);
    }

    // Públicos

    // Relacionado a Figura

    @Test
    public void test04ObtenerOrdenDeReinaCorrespondeA12() {
        // Arrange
        Corazon corazon = new Corazon();
        Figura reina = new Reina();
        Carta carta = new Carta(corazon, reina);

        // Act
        int orden = carta.obtenerOrden();

        // Assert
        assertEquals(12, orden);
    }

    @Test
    public void test05CartaReyDeUnPaloSabeDecirSiLaCartaSiguienteEsReina() {
        // Arrange
        Corazon corazon = new Corazon();
        Figura reina = new Reina();
        Figura rey = new Rey();
        Carta cartaReina = new Carta(corazon, reina);
        Carta cartaRey = new Carta(corazon, rey);

        // Act
        boolean resultado = cartaRey.laCartaSiguienteEs(cartaReina);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test06DosCartasReinaDeUnPaloTieneMismaFigura() {
        // Arrange
        Corazon corazon = new Corazon();
        Figura reina1 = new Reina();
        Figura reina2 = new Reina();
        Carta cartaReina1 = new Carta(corazon, reina1);
        Carta cartaReina2 = new Carta(corazon, reina2);

        // Act
        boolean resultado = cartaReina1.tieneMismaFiguraQue(cartaReina2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void test07CartaSabeSiEsSuFiguraIgualAOtraFigura() {
        // Arrange
        Corazon corazon = new Corazon();
        Figura reina = new Reina();
        Carta carta = new Carta(corazon, reina);

        // Act
        boolean resultado = carta.esFiguraIgualA(reina);

        // Assert
        assertTrue(resultado);
    }

    // Relacionado a Palo

    @Test
    public void test08UnaCartaCompruebaSiLaCartaSiguienteEsDelMismoPalo() {
        // Arrange
        Corazon corazon = new Corazon();
        Figura rey = new Rey();
        Carta carta1 = new Carta(corazon, rey);
        Carta carta2 = new Carta(corazon, rey);

        // Act
        boolean resultado = carta1.laCartaSiguienteMismoPalo(carta2);

        // Assert
        assertTrue(resultado);
    }

    // Relacionado a Puntaje

    @Test
    public void test09CartaSumaSuPuntajeAOtroPuntaje() {
        // Arrange
        Figura reina = new Reina();
        Corazon corazon = new Corazon();
        Carta carta = new Carta(corazon, reina);
        Puntaje puntaje = new Puntaje(new Chip(5));
        int valorEsperado = 15;

        // Act
        carta.sumarPuntajeCon(puntaje);

        // Assert
        assertEquals( valorEsperado, puntaje.calcularPuntaje());
    }

    @Test
    public void test10UnaCartaCambiarPuntajePorOtroQueLeMandan() {
        // Arrange
        Figura reina = new Reina();
        Corazon corazon = new Corazon();
        Carta carta = new Carta(corazon, reina);
        Multiplicador multiplicador = new Multiplicador(3);
        // Esto es para evitar get, uso la suma de un Puntaje que no afecta
        Puntaje puntajeCero = new Puntaje(new Chip(0));

        int valorEsperado = 15;

        // Act
        carta.cambiarPuntaje(5, multiplicador);

        // Assert
        carta.sumarPuntajeCon(puntajeCero);
        assertEquals(valorEsperado,  puntajeCero.calcularPuntaje());
    }

    @Test
    public void test11UnaCartaCambiaSuChipPorOtroQueLeMandan() {
        // Arrange
        Figura reina = new Reina();
        Corazon corazon = new Corazon();
        Carta carta = new Carta(corazon, reina);
        Puntaje puntajeCero = new Puntaje(new Chip(0));


        // Act
        carta.cambiarChip(15);

        // Assert
        carta.sumarPuntajeCon(puntajeCero);
        assertEquals(15, puntajeCero.calcularPuntaje());
    }

    @Test
    public void test12UnaCartaCambiaSuMultiplicadorPorOtroQueLeMandan() {
        // Arrange
        Figura reina = new Reina();
        Corazon corazon = new Corazon();
        Carta carta = new Carta(corazon, reina);
        Multiplicador nuevoMultiplicador = new Multiplicador(3);
        Puntaje puntajeCero = new Puntaje(new Chip(0));

        // Act
        carta.cambiarMultiplicador(nuevoMultiplicador);

        // Assert
        carta.sumarPuntajeCon(puntajeCero);
        assertEquals(30, puntajeCero.calcularPuntaje());
    }
}