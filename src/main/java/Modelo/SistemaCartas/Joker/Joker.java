package Modelo.SistemaCartas.Joker;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.Efecto;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoDescarte;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoJugada;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoUnoEn;
import Modelo.SistemaPuntaje.Multiplicador;

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
    private final Multiplicador multiplicador;
    private Efecto efecto;

    public Joker(int puntaje, String nombre, String descripcion, int unMultiplicador, Efecto efecto) {
        this.puntaje = puntaje;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.multiplicador = new Multiplicador(unMultiplicador);

        for(Efecto efectoCorrecto: efectosCartaPosibles) {
            for (String efectoCorrectoString : efectosPosibles) {
                if (efectoCorrecto.validarEfecto(efectoCorrectoString)) {
                    this.efecto = efectoCorrecto;
                }
            }
        }
    }

    public String getNombre() {
        return nombre;
    }
    public String mostrarDescripcion() {
        return descripcion;
    }

    public void activarPorDescarte(){
      if (this.efecto.validarEfecto("Descarte")){
          this.efecto.activar(puntaje,multiplicador);
        }
    }

    public void activarPorJugada(){
        if (this.efecto.validarEfecto("Mano Jugada")){
            this.efecto.activar(puntaje,multiplicador);
        }
    }

    public void activarPorUnoEn(){
        if (this.efecto.validarEfecto("1 en")){
         this.efecto.activar(puntaje,multiplicador);
        }
    }
}
