package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Jugador.Jugador;
import Modelo.SistemaPuntaje.Multiplicador;

public abstract class Efecto {
    private final String activacion;

    public Efecto(String activacion) {
        this.activacion = activacion;
    }

    public Boolean validarEfecto(String Efecto) {
        return activacion.equals(Efecto);
    }

    public abstract void activar(int puntaje, int multiplicador, Jugador jugador);
    //MUY IMPORTANTE: TODOS LOS EFECTOS REQUIEREN ESTAS DOS VARIABLES, LO
    //QUE HACEN CON ELLAS DEPENDE DEL EFECTO, PERO EL ARCHIVO JSON INDICA
    //QUE SE USAN DE FORMA DINAMICA PARA DETERMINAR EL COMPORTAMIENTO


}
