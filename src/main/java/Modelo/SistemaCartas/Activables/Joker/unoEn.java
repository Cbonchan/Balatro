package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.*;
import Modelo.Usuario.Jugador;

import java.util.Random;

public class unoEn extends Joker {

    private final Random random;
    private final int probabilidad;

    public unoEn(String nombre, String descripcion, int puntaje, int multiplicador, int probabilidad){
        super(nombre, descripcion, puntaje, multiplicador);

        this.probabilidad = probabilidad;
        random = new Random();

        if (puntaje == 1){
            this.efecto = new MultiplicacionMult();
        }
        else{
            this.efecto = new SumaPuntaje();
        }
    }

    //TESTING, CONSTRUCTOR SOLO USADO PARA TESTS
    public unoEn(String nombre, String descripcion, int puntaje, int multiplicador, int probabilidad, Random FProbabilidad) {
        super(nombre, descripcion, puntaje, multiplicador);

        this.probabilidad = probabilidad;
        random = FProbabilidad;

        if (puntaje == 1) {
            this.efecto = new SumarMult();
        } else {
            this.efecto = new AumentarChips();
        }
    }

    private boolean seActivo(){
        return random.nextInt(this.probabilidad) == 0;
    }
    /*
    public boolean FueActivado(){
        return this.efecto.seActivo();
    }*/

    @Override
    public void activar(Jugador jugador){
        if (seActivo()) {
            this.efecto.activar(this.puntaje, this.multiplicador, jugador);
        }
    }
}
