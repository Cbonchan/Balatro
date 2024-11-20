package Modelo.SistemaCartas.Joker;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.*;
import Modelo.Jugador.Jugador;

import java.util.List;
import java.util.Random;

public class Joker {

    private static final List<String> efectosPosibles = List.of(
           "Mano Jugada", "Descarte", "Automatico"
    );
    /*private static final List<Efecto> efectosCartaPosibles = List.of(
            new EfectoDescarte(), new EfectoAutomatico(), new EfectoPorJugada("No tiene")
    );*/

    private final String nombre;
    private final String descripcion;
    private final int puntaje;
    private final int multiplicador;

    private Efecto efecto;


    public Joker(int puntaje, String nombre, String descripcion, int unMultiplicador, Efecto efecto) {
        this.puntaje = puntaje;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.multiplicador = unMultiplicador;



        for (String efectoCorrectoString: efectosPosibles){
            if (efecto.validarEfecto(efectoCorrectoString)){
                this.efecto = efecto;
                break; // El efecto es valido, no hace falta seguir iterando
            }
        }
        if (this.efecto == null){
            throw new IllegalArgumentException("El efecto proporcionado no es válido para este Joker.");
        }

    }


    public String getNombre() {
        return nombre;
    }
    public String mostrarDescripcion() {
        return descripcion;
    }



//este metodo activa los jokers automaticos, que son los que no requieren ninguna
// condicion previa, las condiciones de mano jugada y descarte se manejan mas abajo
    /*
    public void activar(Jugador jugador){
            if(this.unoEn() == false){
                efecto.activar(puntaje, multiplicador, jugador);
            } else {
                this.roto = true; // Esto esta seteado para verificar en los test
            }
    }
     */


    public void activar(Jugador jugador){
            efecto.activar(puntaje, multiplicador, jugador);

    }

    public void activarPorDescarte(Jugador jugador){

        efecto.activar(puntaje, multiplicador, jugador);


    }

    public void activarPorJugada(Jugador jugador){

        efecto.activar(puntaje, multiplicador, jugador);


    }

}
