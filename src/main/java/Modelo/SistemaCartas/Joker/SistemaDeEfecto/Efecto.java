package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Jugador.Jugador;
import Modelo.SistemaPuntaje.Multiplicador;
import java.util.Random;

public abstract class Efecto {
    private final String activacion;
    private final String jugadaActivacion;

    public Efecto(String activacion) {
        this.activacion = activacion;
        this.jugadaActivacion = "No Tiene";
    }

    public Efecto(String activacion, String jugadaActivacion) {
        this.activacion = activacion;
        this.jugadaActivacion = jugadaActivacion;
    }

    public Boolean validarEfecto(String Efecto) {
        return activacion.equals(Efecto);
    }

    public Boolean validarEfectoPorJugada(Jugador jugador) {
        return jugador.validarMano(jugadaActivacion);
    }

    public abstract void activar(int puntaje, int multiplicador, Jugador jugador);
    //MUY IMPORTANTE: TODOS LOS EFECTOS REQUIEREN ESTAS DOS VARIABLES, LO
    //QUE HACEN CON ELLAS DEPENDE DEL EFECTO, PERO EL ARCHIVO JSON INDICA
    //QUE SE USAN DE FORMA DINAMICA PARA DETERMINAR EL COMPORTAMIENTO


}
