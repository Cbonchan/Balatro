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
    public Chip aumentarValorChip(Chip otroChip){
          return (this.chip.sumar(otroChip) );
    }

    public void sumarChip(Chip otroChip){
        this.chip = this.chip.sumar(otroChip);
    }


    //! Rompe encapsulamiento
    public Multiplicador aumentarValorMultiplicador(Multiplicador otroMultiplicador ){
        return  (this.multiplicador.sumar(otroMultiplicador) );
    }

    public void incrementarMultiplicador(Puntaje otroPuntaje){
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



    public  int calcularPuntaje( ){
        return  this.multiplicador.multiplicarCon(this.chip);
    }

}

