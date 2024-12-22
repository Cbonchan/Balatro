 package Modelo.CasosDeUso;

// Importaciones


//! NO ENTIENDO DIFERENCIA ENTRE TEST 3 Y 4 (Ver enunciado)
// Coloco dos test  distinto, pero no entiendo


 import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarCarta;
 import Modelo.SistemaCartas.Activables.Tarot.MejoraCarta;
 import Modelo.Usuario.Jugador;
 import Modelo.Usuario.Mano;
 import Modelo.SistemaCartas.Cartas.Carta;
 import Modelo.SistemaCartas.Cartas.Figura.*;
 import Modelo.SistemaCartas.Cartas.Palo.*;
 import Modelo.SistemaPuntaje.Multiplicador;
 import Modelo.SistemaCartas.Activables.SistemaDeEfecto.AumentarChips;
 import Modelo.Usuario.Mazo;
 import org.junit.Assert;
 import org.junit.Test;
 import static org.junit.jupiter.api.Assertions.assertEquals;


 public class TestJuego {

    @Test
    public void test01JugadorPoseeCartasSuficienteParaEmpezarJuego(){
        // Arrange
        Jugador jugador = new Jugador();
        Mazo mazo = jugador.obtenerMazo();
        int cantidadDeCartasEsperadas = 52;

        // Act y Assert
        assertEquals(cantidadDeCartasEsperadas, mazo.getCartasDisponibles(), "El mazo debe tener 52 cartas una vez inicializado");
    }

    @Test
    public void test02JugadorTiene8CartasEnLaManoDeSuMazo(){
        // Arrange
        Jugador jugador = new Jugador();
        int cantidadDeCartasEsperadas = 8;

        // Act
        jugador.agregarCartasFaltantes();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, jugador.getCantidadCartas(), "El jugador debe tener 8 cartas después de repartir.");
    }

    @Test
    public void test03LaManoTwoPairSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Diamante() ,new Reina());
        Carta cartaCarta2 = new Carta(new Pica() ,new Reina());
        Carta cartaCarta3 = new Carta(new Corazon() ,new Cinco());
        Carta cartaCarta4 = new Carta(new Pica() ,new Cinco());
        Carta cartaCarta5 = new Carta(new Trebol() ,new Dos());
        int valorEsperado = 100;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);
        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void test04LaManoPairSeCalculaCorrectamente(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Diamante() ,new Rey());
        Carta cartaCarta2 = new Carta(new Trebol() ,new Rey());
        Carta cartaCarta3 = new Carta(new Trebol() ,new Siete());
        Carta cartaCarta4 = new Carta(new Pica() ,new Dos());
        Carta cartaCarta5 = new Carta(new Corazon() ,new Jota());
        int valorEsperado = 60;

        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);
        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void test05LaManoSeCalculaEnElOrdenCorrecto(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Pica() ,new Reina());
        Carta cartaCarta2 = new Carta(new Pica() ,new Jota());
        Carta cartaCarta3 = new Carta(new Pica() ,new Diez());
        Carta cartaCarta4 = new Carta(new Pica() ,new Nueve());
        Carta cartaCarta5 = new Carta(new Pica() ,new Ocho());
        int primerValorEsperado = 15;
        int segundoValorEsperado = 30;
        int tercerValorEsperado = 45;
        int cuartoValorEsperado = 59;
        int quintoValorEsperado = 72;

        // Act y Assert
        //!!Multiples Assert -> Preguntar profes si esta bien
        jugador.seleccionarCarta(cartaCarta1);
        jugador.jugarMano();
        int valorObtenido = jugador.getPuntos();
        assertEquals(primerValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta2);
        jugador.jugarMano();
        valorObtenido = jugador.getPuntos();
        assertEquals(segundoValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta3);
        jugador.jugarMano();
        valorObtenido = jugador.getPuntos();
        assertEquals(tercerValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta4);
        jugador.jugarMano();
        valorObtenido = jugador.getPuntos();
        assertEquals(cuartoValorEsperado,valorObtenido);

        jugador.seleccionarCarta(cartaCarta5);
        jugador.jugarMano();
        valorObtenido = jugador.getPuntos();
        assertEquals(quintoValorEsperado,valorObtenido);
    }


     @Test
     public void test06TarotCambiaElMultiplicadorDeUnaCartaA10() {

         // Arrange
         Carta carta1 = new Carta(new Diamante(), new Rey());

         MejoraCarta tarot = new MejoraCarta("Test02", "El multiplicador pasa a ser 2",10, new Multiplicador(10), new MejorarCarta());

         // Act
         tarot.activar(carta1, "Sin contexto");

         // Assert
         float valorMultiplicadorObtenido = carta1.getValorNumMultiplicador(); //! TESTEO POR IMPLEMENTACION
         int valorMultiplicadorEsperado = 10;

         Assert.assertEquals(valorMultiplicadorEsperado, valorMultiplicadorObtenido,0);

     }

    @Test
    public void test07SeAplicaTarotX6MultiplicadorYSeCalculaCorrectamenteElPuntaje(){
        // Arrange
        Jugador jugador = new Jugador();
        Carta cartaCarta1 = new Carta(new Pica() ,new As());
        Carta cartaCarta2 = new Carta(new Corazon() ,new As());
        Carta cartaCarta3 = new Carta(new Pica() ,new Reina());
        Carta cartaCarta4 = new Carta(new Pica() ,new Jota());
        Carta cartaCarta5 = new Carta(new Pica() ,new Diez());
        MejoraCarta tarot = new MejoraCarta("Test02", "El multiplicador pasa a ser 2",10, new Multiplicador(6), new MejorarCarta());


        int valorEsperado = 372;
        tarot.activar(cartaCarta1, "Sin contexto");
        jugador.seleccionarCarta(cartaCarta1);
        jugador.seleccionarCarta(cartaCarta2);
        jugador.seleccionarCarta(cartaCarta3);
        jugador.seleccionarCarta(cartaCarta4);
        jugador.seleccionarCarta(cartaCarta5);
        jugador.jugarMano();

        // Act
        int valorObtenido = jugador.getPuntos();

        // Assert
        assertEquals(valorEsperado,valorObtenido);
    }



}
