package Modelo.SistemaCartas.Joker;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.*;
import Modelo.Jugador.Jugador;

import java.util.List;
import java.util.Random;

public class Joker {

    private static final List<String> efectosPosibles = List.of(
           "Mano Jugada", "Descarte", "Automatico"
    );
    private static final List<Efecto> efectosCartaPosibles = List.of(
            new EfectoDescarte(), new EfectoAutomatico(), new EfectoPorJugada("No tiene")
    );

    private final String nombre;
    private final String descripcion;
    private final int puntaje;
    private final int multiplicador;
    private final int probabilidad;
    private Efecto efecto;

    public Joker(int puntaje, String nombre, String descripcion, int unMultiplicador, Efecto efecto) {
        this.puntaje = puntaje;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.multiplicador = unMultiplicador;
        this.probabilidad = 1;


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
    //segundo constructor, este usa probabilidad en caso de que deba ser asignada para los jokers con "1 en: probabilidad" del JSON
    public Joker(int puntaje, String nombre, String descripcion, int unMultiplicador, Efecto efecto, int probabilidad) {
        this.puntaje = puntaje;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.multiplicador = unMultiplicador;
        this.probabilidad = probabilidad;

        for (String efectoCorrectoString: efectosPosibles){
            if (efecto.validarEfecto(efectoCorrectoString)){
                this.efecto =efecto;
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

    private boolean unoEn() {
        Random random = new Random();
        int numero = random.nextInt(this.probabilidad);
        // 1 entre probabilidad chance de autodestruirse
        return numero == 0;
    }

//este metodo activa los jokers automaticos, que son los que no requieren ninguna
// condicion previa, las condiciones de mano jugada y descarte se manejan mas abajo
    public void activar(Jugador jugador){
            if(this.unoEn() && (efecto.validarEfecto("Automatico"))){
                efecto.activar(puntaje, multiplicador, jugador);
            }
    }

    public void activarPorDescarte(Jugador jugador){
          if (efecto.validarEfecto("Descarte")){
              efecto.activar(puntaje, multiplicador, jugador);
          }
    }

    public void activarPorJugada(Jugador jugador){
            if(efecto.validarEfecto("Mano Jugada")&& efecto.validarEfectoPorJugada(jugador)){
                efecto.activar(puntaje, multiplicador, jugador);
            }
    }

}
