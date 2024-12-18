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

    // Privados

    // Post: aumenta el valor del puntaje según la cantidad de chips que se le otorguen
    private Chip aumentarValorChip(Chip otroChip){
        return (this.chip.sumar(otroChip) );
    }

    // Post: aumenta el valor del multiplicador según la cantidad de multiplicadores que se le otorguen
    private Multiplicador aumentarValorMultiplicador(Multiplicador otroMultiplicador ){
        return  (this.multiplicador.multiplicarCon(otroMultiplicador) );
    }


    // Públicos

    // Post: Cambia el valor de los chips y los multiplicadores
    public void cambiarPuntaje(int incrementador, Multiplicador multiplicador) {
        this.chip.cambiarChip(incrementador);
        this.multiplicador.cambiarMultiplicador(multiplicador);
    }

    // Post: Suma el valor de los chips y multiplica el valor de los multiplicadores
    public void aumentarPuntaje(int incrementador, Multiplicador multiplicador){
        this.chip = this.chip.sumar(new Chip(incrementador));
        this.multiplicador= this.multiplicador.sumarMultiplicador(multiplicador);
    }

    //Post: Calcula en valor final del puntaje
    public  int calcularPuntaje( ){
        return  this.multiplicador.multiplicarCon(this.chip);
    }

    // Relación con Chip

    // Post: Cambia los chips por otros, usado en Tarot
    public void cambiarChip(int  nuevoValorDeChip){
        this.chip = new Chip(nuevoValorDeChip);
    }

    // Post: aumenta el valor de chips según la cantidad de chips que se le otorguen
    public void sumarChipCon(Chip otroChip){
        this.chip = this.chip.sumar(otroChip);
    }

    // Post: suma el valor de los chips
    public void sumarNuevosChips( Puntaje otroPuntaje){
        // This == puntaje final
        this.chip = otroPuntaje.aumentarValorChip(this.chip);
    }


    public int obtenerChips(){
        return (chip.valorNumerico());
    }



    // Relación con Multiplicador

    // Arreglado

    // Post: Cambia el multiplicador por otro, usado en tarot
    public void cambiarMultiplicador(Multiplicador nuevoMultiplicador){
        this.multiplicador= nuevoMultiplicador;
    }

    // Post: aumenta el valor del multiplicador
    public void sumarMultiplicador(Multiplicador incrementoMult){
        this.multiplicador = multiplicador.sumarMultiplicador(incrementoMult);
    }

    // Post: multiplica el multiplicador por otro multiplicador
    public void multiplicarMultiplicadorPor(Multiplicador incremento){
        this.multiplicador = multiplicador.multiplicarCon(incremento);
    }

    // Post: suma el valor de los multiplicadores
    public void sumarNuevoMultiplicador( Puntaje otroPuntaje){
        // This == puntaje final
        this.multiplicador = otroPuntaje.aumentarValorMultiplicador(this.multiplicador);
    }


    //! Rompe encapsulamiento
    public int obtenerMultiplicador(){
        return (multiplicador.valorNumerico());
    }


}

