package Modelo.TestUnitarios.TestSistemaCartas.TestComodines;

import Modelo.Parser.JSONReader;
import Modelo.SistemaCartas.Activables.Activable;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class TestJSONParser {

    @Test
    public void test01SeParseaJokerYSeObtieneDescripcionCorrectamente() throws FileNotFoundException {

        Reader archivo = new FileReader("src/main/test/Modelo/TestUnitarios/TestSistemaCartas/TestComodines/example/comodines.json");

        ArrayList<Activable> jokers = JSONReader.obtenerJokers(archivo);
        Activable joker = jokers.get(0);

        String esperado = "x4";
        String obtenido = joker.getDescripcion();

        assertEquals(esperado, obtenido);


    }
}
