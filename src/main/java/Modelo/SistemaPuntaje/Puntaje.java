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




    public Chip aumentarValorChip(Chip otroChip){
        return (this.chip.sumar(otroChip) );
    }



    // Públicos

    // Relación con Chip

    // Arreglado

    // Post: Cambia los chips por otros, usado en Tarot
    public void cambiarChip(int  nuevoValorDeChip){
        this.chip = new Chip(nuevoValorDeChip);
    }

    // Post: aumenta el valor de chips según la cantidad de chips que se le otorguen
    public void sumarChipCon(Chip otroChip){
        this.chip = this.chip.sumar(otroChip);
    }


    public void sumarNuevosChips( Puntaje otroPuntaje){
        // This == puntaje final
        this.chip = otroPuntaje.aumentarValorChip(this.chip);
    }

   // Falta:

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




    // Falta:

    //! Rompe encapsulamiento

    public int obtenerMultiplicador(){
        return (multiplicador.valorNumerico());
    }


    public Multiplicador aumentarValorMultiplicador(Multiplicador otroMultiplicador ){
        return  (this.multiplicador.multiplicarCon(otroMultiplicador) );
    }

    public Multiplicador sumarDeVerdadElMultiplicador(Multiplicador otroMultiplicador){
        return (this.multiplicador.sumarMultiplicador(otroMultiplicador));
    }

    public void sumarNuevoMultiplicador( Puntaje otroPuntaje){
        // This == puntaje final
        this.multiplicador = otroPuntaje.aumentarValorMultiplicador(this.multiplicador);
    }






    // Propios




    //Post: Calcula en valor final del puntaje
    public  int calcularPuntaje( ){
        return  this.multiplicador.multiplicarCon(this.chip);
    }

}

