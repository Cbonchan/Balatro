package Modelo.TestUnitarios.TestParser;

import Modelo.Parser.JSONReader;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.ActivableEnCarta;
import Modelo.Usuario.Mazo;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class TestJSONParser {

    @Test
    public void test01SeParseaJokerYSeObtieneDescripcionCorrectamente() throws FileNotFoundException {
        // Arrange
        Reader archivo = new FileReader("src/main/resources/JsonFiles/comodines.json");

        //Act
        ArrayList<Activable> jokers = JSONReader.obtenerJokers(archivo);
        Activable joker = jokers.get(0);

        String esperado = "x4";
        String obtenido = joker.getDescripcion();

        //Assert
        assertEquals(esperado, obtenido);


    }

    @Test
    public void test02SeParseaTarotsEnJugadaYSeObtieneDescripcionCorrectamente() throws FileNotFoundException {
        // Arrange
        Reader archivo = new FileReader("src/main/resources/JsonFiles/tarots.json");

        //Act
        ArrayList<Activable> tarotsEnJugada = JSONReader.obtenerTarotsEnJugada(archivo);
        Activable tarot = tarotsEnJugada.get(0);

        String esperado = "Mejora la mano par";
        String obtenido = tarot.getDescripcion();

        //Assert
        assertEquals(esperado, obtenido);


    }

    @Test
    public void test03SeParseaTarotsEnCartaYSeObtieneDescripcionCorrectamente() throws FileNotFoundException {
        // Arrange
        Reader archivo = new FileReader("src/main/resources/JsonFiles/tarots.json");

        //Act
        ArrayList<ActivableEnCarta> tarotsEnJugada = JSONReader.obtenerTarotsEnCarta(archivo);
        ActivableEnCarta tarot = tarotsEnJugada.get(0);

        String esperado = "Mejora la mano carta mas alta";
        String obtenido = tarot.getDescripcion();

        //Assert
        assertEquals(esperado, obtenido);


    }
    @Test
    public void test04SeParseaMazoySeObtieneCantidadDeCartasCorrecta() throws FileNotFoundException{
        // Arrange
        Reader archivo = new FileReader("src/main/resources/JsonFiles/balatro.json");

        //Act
        Mazo mazo = JSONReader.obtenerMazo(archivo);
        int obtenido = mazo.getCartasDisponibles();
        int esperado = 52;

        //Assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void test05SeParseaMazoySeObtieneNombreDePaloTrebolCorrecto() throws FileNotFoundException{
        // Arrange
        Reader archivo = new FileReader("src/main/resources/JsonFiles/balatro.json");

        //Act
        Mazo mazo = JSONReader.obtenerMazo(archivo);
        String obtenido = mazo.obtenerPaloDeCarta(1);
        String esperado = "Treboles";

        //Assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void test06SeParseaMazoySeObtieneNombreDePaloCorazonesCorrecto() throws FileNotFoundException{
        // Arrange
        Reader archivo = new FileReader("src/main/resources/JsonFiles/balatro.json");

        //Act
        Mazo mazo = JSONReader.obtenerMazo(archivo);
        String obtenido = mazo.obtenerPaloDeCarta(14);
        String esperado = "Corazones";

        //Assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void test07SeParseaMazoySeObtieneNombreDePaloPicasCorrecto() throws FileNotFoundException{
        // Arrange
        Reader archivo = new FileReader("src/main/resources/JsonFiles/balatro.json");

        //Act
        Mazo mazo = JSONReader.obtenerMazo(archivo);
        String obtenido = mazo.obtenerPaloDeCarta(27);
        String esperado = "Picas";

        //Assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void test08SeParseaMazoySeObtieneNombreDePaloDiamantesCorrecto() throws FileNotFoundException{
        // Arrange
        Reader archivo = new FileReader("src/main/resources/JsonFiles/balatro.json");

        //Act
        Mazo mazo = JSONReader.obtenerMazo(archivo);
        String obtenido = mazo.obtenerPaloDeCarta(40);
        String esperado = "Diamantes";

        //Assert
        assertEquals(esperado, obtenido);
    }
}
