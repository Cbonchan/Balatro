package Modelo.Juego;


import Modelo.Parser.JSONReader;
import Modelo.Usuario.Jugador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class Juego {

    // Atributos
    private static Juego instancia;

    Jugador jugador;
    int nroRonda;
    Ronda rondaActual;
    List<Ronda> rondas;

     public Juego() throws FileNotFoundException {
        this.jugador = new Jugador();
        //aca deberia estar la lectura de los json, creo, sobretodo porque conviene almacenar la info de las rondas en inicializacion en lugar de
        //obtenerla en tiempo de ejecucion
         Reader archivo =new FileReader("src/main/resources/JsonFiles/balatro.json");
         this.rondas = JSONReader.obtenerRondas(archivo);
         this.rondaActual = rondas.get(0);
         this.nroRonda = rondaActual.getNro();
     }

    // Método estático que devuelve la única instancia de la clase
    public static Juego getInstance() throws FileNotFoundException {
        if (instancia == null) {
            instancia = new Juego(); // Inicializa la instancia si no existe
        }
        return instancia; // Devuelve la instancia existente
    }
//!mucho de esto se hace de forma nativa en FX, aca tenemos que inicializar los componentes
    //y facilitar funciones para avanzar, no nos encargamos del loop porque para eso es el controlador

//post: cambia la ronda del juego, de esta forma es mas facil actualizar los datos ya sea desde el FX o desde aca
    public void avanzarRonda() {
        this.rondaActual=rondas.get(nroRonda);
        nroRonda++;
    }

//JavaFX getter

    public Jugador getJugador() {return jugador;}

    public Ronda getRondaActual() {
         return rondaActual;
    }

    public int getNroRonda() {return nroRonda;}
}









