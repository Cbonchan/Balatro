package Modelo.Unitarios;


import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaCartas.Poker.Figura.Reina;
import Modelo.SistemaCartas.Poker.Palo.Diamante;
import org.junit.jupiter.api.Test;

public class TestCartaPoker {
    //!rehacer

    /*@Test
    public void test01PokerCalculaPuntuacionAgregado() {
        Poker cartaPoker = new Poker(new Diamante() ,new Reina());
        Poker cartaPoker2 = new Poker(new Diamante() ,new As());
        int valorAgregado = 0;
        int valorEsperado = 21;
        valorAgregado = cartaPoker.sumarValorAgregadoPuntuacion(valorAgregado);
        valorAgregado = cartaPoker2.sumarValorAgregadoPuntuacion(valorAgregado);

        assertEquals(valorEsperado, valorAgregado);

    }
    @Test
    public void test02PokerCalculaMultiplicadorAgregado() {
        Poker cartaPoker = new Poker(new Diamante(), new Reina());
        Poker cartaPoker2 = new Poker(new Diamante(), new As());
        int valorAgregado = 0;
        int valorEsperado = 0;
        valorAgregado = cartaPoker.sumarValorAgregadoMultiplicador(valorAgregado);
        valorAgregado = cartaPoker2.sumarValorAgregadoMultiplicador(valorAgregado);

        assertEquals(valorEsperado, valorAgregado);
    }*/

    @Test
    public void test02PokerCalculaMultiplicadorAgregado() {
        Carta cartaPoker = new Carta(new Diamante(), new Reina());
        System.out.println("src/main/resources/Modelo/images/"+cartaPoker.getFigura().getNombre()+"_of_"+cartaPoker.getPalo().getNombre()+".png");
    }
}
