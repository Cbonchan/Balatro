package Modelo.TestUnitarios.TestUsuario;

import Modelo.SistemaCartas.Activables.Joker.Joker;
import Modelo.SistemaCartas.Activables.Joker.PorJugada;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.AumentarChips;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarCarta;
import Modelo.SistemaCartas.Activables.Tarot.MejoraCarta;
import Modelo.SistemaCartas.Cartas.Carta;

import Modelo.SistemaCartas.Cartas.Figura.Rey;
import Modelo.SistemaCartas.Cartas.Palo.Diamante;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Jugador;

import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {

    @Test
    public void test01AgregarCartasFaltantesParaSeleccionar() {
        // Arrange
        Jugador jugador = new Jugador();
        int cartasEsperadas = 8;

        // Act
        jugador.agregarCartasFaltantes();

        // Assert
        assertEquals(cartasEsperadas, jugador.getCantidadCartas());
    }

    @Test
    public void test02SeleccionarCartaYSeAgregaALaMano() {
        // Arrange
        Jugador jugador = new Jugador();
        Carta carta = new Carta(new Diamante(), new Rey());
        jugador.agregarCartas(List.of(carta));
        int cartasEsperadas = 0;

        // Act
        jugador.seleccionarCarta(carta);

        // Assert
        assertEquals(cartasEsperadas, jugador.getCantidadCartas());
    }

    @Test
    public void test03SeleccionarCartaEnMano() {
        // Arrange
        Jugador jugador = new Jugador();
        Carta carta = new Carta(new Diamante(), new Rey());
        jugador.agregarCartas(List.of(carta));
        jugador.seleccionarCarta(carta);
        int cartasEnManoEsperadas = 1;

        // Act
        int cartasEnMano = jugador.obtenerMano().obtenerCartas().size();

        // Assert
        assertEquals(cartasEnManoEsperadas, cartasEnMano);
    }

    @Test
    public void test04CancelarEleccion() {
        // Arrange
        Jugador jugador = new Jugador();
        Carta carta = new Carta(new Diamante(), new Rey());
        jugador.agregarCartas(List.of(carta));
        jugador.seleccionarCarta(carta);
        int cartasEsperadas = 1;

        // Act
        jugador.cancelarEleccion();

        // Assert
        assertEquals(cartasEsperadas, jugador.getCantidadCartas());
    }

    @Test
    public void test05CancelarEleccionEnMano() {
        // Arrange
        Jugador jugador = new Jugador();
        Carta carta = new Carta(new Diamante(), new Rey());
        jugador.agregarCartas(List.of(carta));
        jugador.seleccionarCarta(carta);
        jugador.cancelarEleccion();
        int cartasEnManoEsperadas = 0;

        // Act
        int cartasEnMano = jugador.obtenerMano().obtenerCartas().size();

        // Assert
        assertEquals(cartasEnManoEsperadas, cartasEnMano);
    }

    @Test
    public void test06DescartarMano() {
        // Arrange
        Jugador jugador = new Jugador();
        Carta carta = new Carta(new Diamante(), new Rey());
        jugador.agregarCartas(List.of(carta));
        jugador.seleccionarCarta(carta);
        int cartasEnManoEsperadas = 0;

        // Act
        jugador.descartarMano();

        // Assert
        assertEquals(cartasEnManoEsperadas, jugador.obtenerMano().obtenerCartas().size());
    }

    @Test
    public void test07AgregarJoker() {
        // Arrange
        Jugador jugador = new Jugador();
        PorJugada joker = new PorJugada("Test01", "+100", 100, new Multiplicador(1), "par", new AumentarChips() );
        int jokersEsperados = 1;

        // Act
        jugador.agregarJoker(joker);

        // Assert
        assertEquals(jokersEsperados, jugador.obtenerJokers().size());
    }

    @Test
    public void test08EliminarJoker() {
        // Arrange
        Jugador jugador = new Jugador();
        PorJugada joker = new PorJugada("Test01", "+100", 100, new Multiplicador(1), "par", new AumentarChips() );
        jugador.agregarJoker(joker);
        int jokersEsperados = 0;

        // Act
        jugador.eliminarJoker(joker);

        // Assert
        assertEquals(jokersEsperados, jugador.obtenerJokers().size());
    }

    @Test
    public void test09AgregarTarot() {
        // Arrange
        Jugador jugador = new Jugador();
        MejoraCarta tarot = new MejoraCarta("Test01", "El puntaje pasa a ser 50",50, new Multiplicador(1), new MejorarCarta());
        int tarotsEsperados = 1;

        // Act
        jugador.agregarTarot(tarot);

        // Assert
        assertEquals(tarotsEsperados, jugador.obtenerTarots().size());
    }

    @Test
    public void test10EliminarTarot() {
        // Arrange
        Jugador jugador = new Jugador();
        MejoraCarta tarot = new MejoraCarta("Test01", "El puntaje pasa a ser 50",50, new Multiplicador(1), new MejorarCarta());
        jugador.agregarTarot(tarot);
        int tarotsEsperados = 0;

        // Act
        jugador.eliminarTarot(tarot);

        // Assert
        assertEquals(tarotsEsperados, jugador.obtenerTarots().size());
    }

    @Test
    public void test11JugarMano() {
        // Arrange
        Jugador jugador = new Jugador();
        Carta carta = new Carta(new Diamante(), new Rey());
        jugador.agregarCartas(List.of(carta));
        jugador.seleccionarCarta(carta);
        int cartasEnManoEsperadas = 0;

        // Act
        jugador.jugarMano();

        // Assert
        assertEquals(cartasEnManoEsperadas, jugador.obtenerMano().obtenerCartas().size());
    }

    @Test
    public void test12ActualizarCantidadDeManos() {
        // Arrange
        Jugador jugador = new Jugador();
        int manosEsperadas = 5;

        // Act
        jugador.actualizarCantidadDeManosYDescartes(manosEsperadas, 0);

        // Assert
        assertEquals(manosEsperadas, jugador.obtenerCantidadJugadas());
    }

    @Test
    public void test13ActualizarCantidadDeDescartes() {
        // Arrange
        Jugador jugador = new Jugador();
        int descartesEsperados = 3;

        // Act
        jugador.actualizarCantidadDeManosYDescartes(0, descartesEsperados);

        // Assert
        assertEquals(descartesEsperados, jugador.obtenerCantidadDescartes());
    }
}