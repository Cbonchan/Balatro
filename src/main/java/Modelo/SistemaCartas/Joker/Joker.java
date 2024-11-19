package Modelo.SistemaCartas.Joker;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.Efecto;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoDescarte;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoJugada;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoUnoEn;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Jugador.Jugador;

import java.util.List;

public class Joker {

    private static final List<String> efectosPosibles = List.of(
           "Mano Jugada", "Descarte", "1 en:"
    );
    private static final List<Efecto> efectosCartaPosibles = List.of(
            new EfectoDescarte(), new EfectoJugada(), new EfectoUnoEn()
    );

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

    public void activar(Jugador jugador){
        this.efecto.activar(puntaje, multiplicador, jugador);
    }

    public void activarPorDescarte(Jugador jugador){
      if (this.efecto.validarEfecto("Descarte")){
          this.efecto.activar(puntaje, multiplicador, jugador);
        }

    }

    public void activarPorJugada(Jugador jugador){
        if (this.efecto.validarEfecto("Mano Jugada")){
            this.efecto.activar(puntaje, multiplicador, jugador);
        }
    }

    public void activarPorUnoEn(Jugador jugador){
        if (this.efecto.validarEfecto("1 en")){
         this.efecto.activar(puntaje, multiplicador, jugador);
        }
    }
}
