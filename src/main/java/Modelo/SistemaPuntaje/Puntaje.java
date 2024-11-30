package Modelo.SistemaPuntaje;

public class Puntaje {

    // Atributos
    private Chip chip;
    private Multiplicador multiplicador;

    // Constructores
    public Puntaje(Chip chip) {
        this(chip, new Multiplicador(1));
    }

    public Puntaje(Chip chip, Multiplicador multiplicador) {
        this.chip = chip;
        this.multiplicador = multiplicador;
    }

    // Métodos
//TODO: Poner post condiciones a estos metodos por favor, son un bardo

    // Privados
    public Chip aumentarValorChip(Chip otroChip){
          return (this.chip.sumar(otroChip) );
    }
    //Post: aumenta el valor de chips segun la cantidad de chips que se le otorguen
    public void sumarChip(Chip otroChip){
        this.chip = this.chip.sumar(otroChip);
    }
    //Post: aumenta el valor del multiplicador
    public void incrementarMult(int incrementoMult){
        this.multiplicador.incrementar(incrementoMult);
    }


    //! Rompe encapsulamiento
    public Multiplicador aumentarValorMultiplicador(Multiplicador otroMultiplicador ){
        return  (this.multiplicador.sumar(otroMultiplicador) );
    }

    public void aumentarMultiplicador(Puntaje otroPuntaje){
        this.multiplicador = otroPuntaje.sumarDeVerdadElMultiplicador(this.multiplicador);
    }

    public Multiplicador sumarDeVerdadElMultiplicador(Multiplicador otroMultiplicador){
        return (this.multiplicador.sumarDeVerdad(otroMultiplicador));
    }

    // Públicos
    public int obtenerMultiplicador(){
        return (multiplicador.valorNumerico());
    }

    public int obtenerChips(){
        return (chip.valorNumerico());
    }

    public void sumarNuevosChips( Puntaje otroPuntaje){
        // This == puntaje final
        this.chip = otroPuntaje.aumentarValorChip(this.chip);
    }

    public void sumarNuevoMultiplicador( Puntaje otroPuntaje){
        // This == puntaje final
        this.multiplicador = otroPuntaje.aumentarValorMultiplicador(this.multiplicador);
    }
    //Post: Cambia el multiplicador por otro, usado en tarot
    public void cambiarMultiplicador(int nuevoMultiplicador){
        this.multiplicador= new Multiplicador(nuevoMultiplicador);
    }
    //Post: Cambia los chips por otros, usado en Tarot
    public void cambiarChip(int nuevoChip){
        this.chip = new Chip(nuevoChip);
    }
    //Post: Calcula en valor final del puntaje
    public  int calcularPuntaje( ){
        return  this.multiplicador.multiplicarCon(this.chip);
    }

}

