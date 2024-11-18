package Modelo.SistemaCartas.Poker;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Palo.Palo;
import Modelo.SistemaCartas.Poker.Figura.Figura;

public class Poker {
    // Atributos
    private  String nombre;  // As de Trebol
    private  Palo palo;
    private  Figura figura;
    private Puntaje puntaje;

    // Constructor
    public Poker(Palo palo, Figura figura) {

        this.palo = palo;
        this.figura = figura;
        this.puntaje = figura.asignarPuntaje();

        this.nombre = figura.getNombre() + " de " + palo.getNombre();
    }

    // Getters y Setters
    public Palo getPalo() {
        return this.palo;
    }

    public Figura getFigura(){
        return this.figura;
    }


    // Métodos

    public boolean laCartaSiguienteEs(Poker otraCarta){

        return otraCarta.miSiguienteCartaEs(figura);


        return figura.miSiguienteCartaEs()

        return this.figura.LeSigueA(otraCarta.getFigura());
    }


    carta modifcarTarot (cartaPoker){
        // 3 de trebol y cambia a 10 puntos
        puntaje.modificarPuntaje(// CONDICION DEL TATOR
    }



    public boolean esFiguraIgualA(Figura figura){
        return (this.figura.getNombre().equals(figura.getNombre()));
    }







    public void sumarPuntajeCon(Puntaje otroPuntaje){
        otroPuntaje.sumarNuevosChips(this.puntaje);
        otroPuntaje.sumarNuevoMultiplicador(this.puntaje);
    }


    public  int calcularPuntaje( ){
        return  Figura.calcularPuntaje();
        return  this.puntaje.calcularPuntaje();
    }

}

// Mano(PUNTAJEFINAL)

// PuntajeMano.sumarPuntajeCon(PUNTAJEFINAL) // Puntaje final = otroPuntaje

// PUNTAJEFINAL.sumarnuevochips,(this.chips
