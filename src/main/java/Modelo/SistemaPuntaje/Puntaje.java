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
    public Puntaje aumentarValorChip(Chip nuevoChip){
        // Suma el valor numérico del nuevo chip con el actual y devuelve un nuevo Puntaje
        Chip nuevoChipTotal = this.chip.sumar(nuevoChip);
        return new Puntaje(nuevoChipTotal, this.multiplicador); // Retorna un nuevo Puntaje con la suma
    }

    public Puntaje sumarMultiplicador(Multiplicador nuevoMultiplicador){

        Multiplicador nuevoMultiplicadorTotal = this.multiplicador.sumar(nuevoMultiplicador);
        return new Puntaje(this.chip, nuevoMultiplicadorTotal);
    }

    public Puntaje sumarChipCon(Puntaje otroPuntaje){
        Chip chipTotal = this.chip.sumar(otroPuntaje.chip);
        return new Puntaje(chipTotal, this.multiplicador); // Mantiene el mismo multiplicador
    }

}
