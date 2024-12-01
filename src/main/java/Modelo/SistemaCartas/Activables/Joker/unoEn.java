package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.*;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

import java.util.Objects;
import java.util.Random;

public class unoEn extends Joker {

    // Atributos
    private final int probabilidad;
    private final Random random;


    // Constructor
    public unoEn(String nombre, String descripcion, int incrementador, Multiplicador multiplicador,  int probabilidad, Efecto efecto) {
        super(nombre, descripcion, incrementador, multiplicador, "1 En", efecto);

        random = new Random();
        this.probabilidad = probabilidad;
    }

    // Viejo Constructor
    public unoEn(String nombre, String descripcion, int puntaje, int multiplicador, int probabilidad){

        super(nombre, descripcion, puntaje, new Multiplicador(multiplicador), "1 En" );
        this.probabilidad = probabilidad;

        random = new Random();
    }

    //TESTING, CONSTRUCTOR SOLO USADO PARA TESTS
    public unoEn(String nombre, String descripcion, int puntaje, int multiplicador, int probabilidad, Random FProbabilidad) {
        super(nombre, descripcion, puntaje, new Multiplicador(multiplicador), "1 En");

        this.probabilidad = probabilidad;
        random = FProbabilidad;
    }

    /*
    public boolean FueActivado(){
        return this.efecto.seActivo();
    }*/

    // Métodos
    private boolean seActivo(){
        return random.nextInt(this.probabilidad) == 0;
    }


    @Override
    public void activar(Mano mano, int puntos, String contexto) {
        if ( activacion.equals(contexto) && seActivo()  ) {
                efecto.activar(this.incrementador, this.multiplicador, mano, puntos);
            }
    }


}
