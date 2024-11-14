package TP;

abstract class Tarot {
    public abstract void usar(CartaPoker carta);
}

class TaroMultiplicadorX6 extends Tarot {
    private int multiplicador;
    public TaroMultiplicadorX6() {
        this.multiplicador = 6;
    }

    @Override
    public void usar(CartaPoker carta) {
        carta.setMultiplicador(multiplicador);
    }
}

class TarotPuntosX10 extends Tarot{
    private int puntos;
    public TarotPuntosX10(){
        this.puntos = 10;
    }
    @Override
    public void usar(CartaPoker carta) {
        carta.setPuntaje(puntos);
    }
}

