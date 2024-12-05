package Modelo.TestUnitarios.TestUsuario;

import Modelo.Juego.Tienda;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.ActivableEnCarta;
import Modelo.SistemaCartas.Activables.Joker.Descarte;
import Modelo.SistemaCartas.Activables.Joker.PorJugada;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.*;
import Modelo.SistemaCartas.Activables.Tarot.MejoraCarta;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.SistemaCartas.Cartas.*;
import Modelo.SistemaCartas.Cartas.Palo.*;
import Modelo.SistemaCartas.Cartas.Figura.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestTienda {

    @Test
    public void test01CreoTiendaYLosElementosSonCinco(){
        // Crear instancias reales de las clases necesarias para la prueba
        List<Activable> activablesEnMano = List.of(
                new PorJugada("Test", "Test", 100, new Multiplicador(1), "par", new SumarPuntaje()),
                new Descarte("Test", "Test", 100, new Multiplicador(1), new SumarPuntaje())
        );
        List<ActivableEnCarta> activablesEnCarta = List.of(
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta()),
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta())
        );

        Carta cartaNueva = new Carta(new Corazon(), new As());

        // Crear tienda
        Tienda tienda = new Tienda(activablesEnMano, cartaNueva, activablesEnCarta);

        // Verificar que la cantidad de elementos disponibles es la correcta
        assertEquals(5, tienda.cantidadDeElementosDisponibles());
    }

    @Test
    public void test02creoTiendaConElementosYComproCarta() {
        // Crear instancias reales de las clases necesarias para la prueba
        List<Activable> activablesEnMano = List.of(
                new PorJugada("Test", "Test", 100, new Multiplicador(1), "par", new SumarPuntaje()),
                new Descarte("Test", "Test", 100, new Multiplicador(1), new SumarPuntaje())
        );
        List<ActivableEnCarta> activablesEnCarta = List.of(
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta()),
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta())
        );


        Carta cartaNueva = new Carta(new Corazon(), new As());

        // Crear tienda
        Tienda tienda = new Tienda(activablesEnMano, cartaNueva, activablesEnCarta);

        // Comprar la carta
        Carta cartaComprada = tienda.comprarCarta();

        // Verificar que la carta comprada es la correcta
        assertEquals(cartaNueva, cartaComprada);
        assertEquals(4, tienda.cantidadDeElementosDisponibles() );
    }

    @Test
    public void test03creoTiendaConElementosYComproTarotActivableEnCarta() {
        // Crear instancias reales de las clases necesarias para la prueba
        List<Activable> activablesEnMano = List.of(
                new PorJugada("Test", "Test", 100, new Multiplicador(1), "par", new SumarPuntaje()),
                new Descarte("Test", "Test", 100, new Multiplicador(1), new SumarPuntaje())
        );
        List<ActivableEnCarta> activablesEnCarta = List.of(
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta()),
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta())
        );


        Carta cartaNueva = new Carta(new Corazon(), new As());

        // Crear tienda
        Tienda tienda = new Tienda(activablesEnMano, cartaNueva, activablesEnCarta);

        // Comprar el tarot
        ActivableEnCarta tarotComprado = tienda.comprarTarotEnCarta(activablesEnCarta.get(0));

        // Verificar que el tarot comprado es el correcto
        assertEquals(activablesEnCarta.get(0), tarotComprado);
        assertEquals(4, tienda.cantidadDeElementosDisponibles());
    }

    @Test
    public void test04creoTiendaConElementosYComproTarotActivableEnMano() {
        // Crear instancias reales de las clases necesarias para la prueba
        List<Activable> activablesEnMano = List.of(
                new PorJugada("Test", "Test", 100, new Multiplicador(1), "par", new SumarPuntaje()),
                new Descarte("Test", "Test", 100, new Multiplicador(1), new SumarPuntaje())
        );
        List<ActivableEnCarta> activablesEnCarta = List.of(
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta()),
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta())
        );

        Carta cartaNueva = new Carta(new Corazon(), new As());

        // Crear tienda
        Tienda tienda = new Tienda(activablesEnMano, cartaNueva, activablesEnCarta);

        // Comprar el tarot
        Activable tarotComprado = tienda.comprarActivableEnMano(activablesEnMano.get(0));

        // Verificar que el tarot comprado es el correcto
        assertEquals(activablesEnMano.get(0), tarotComprado);
        assertEquals(4, tienda.cantidadDeElementosDisponibles());
    }

    @Test
    public void test05ComproTodosLosElementosYLaTiendaSeVacia(){
        // Crear instancias reales de las clases necesarias para la prueba
        List<Activable> activablesEnMano = List.of(
                new PorJugada("Test", "Test", 100, new Multiplicador(1), "par", new SumarPuntaje()),
                new Descarte("Test", "Test", 100, new Multiplicador(1), new SumarPuntaje())
        );
        List<ActivableEnCarta> activablesEnCarta = List.of(
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta()),
                new MejoraCarta("Test", "Test", 100, new Multiplicador(1), new MejorarCarta())
        );

        Carta cartaNueva = new Carta(new Corazon(), new As());

        // Crear tienda
        Tienda tienda = new Tienda(activablesEnMano, cartaNueva, activablesEnCarta);

        // Comprar todos los elementos
        Carta cartaComprada = tienda.comprarCarta();
        ActivableEnCarta tarotComprado = tienda.comprarTarotEnCarta(activablesEnCarta.get(0));
        Activable tarotComprado2 = tienda.comprarActivableEnMano(activablesEnMano.get(0));
        Activable tarotComprado3 = tienda.comprarActivableEnMano(activablesEnMano.get(1));
        ActivableEnCarta tarotComprado4 = tienda.comprarTarotEnCarta(activablesEnCarta.get(1));

        // Verificar que la tienda se vació
        assertEquals(0, tienda.cantidadDeElementosDisponibles());
    }


}
