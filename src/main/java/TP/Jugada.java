package TP;

abstract class Jugada {
    private int puntaje;
    private int multiplicador;

    public Jugada(int puntaje, int multiplicador) {
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;
    }
}
//las jugadas agregan al multiplicador y agregan
//sus puntos al marcador cuando se realizan
//NO EXISTE MANO QUE NO LLEVE A UNA JUGADA


//NOTA: ADAPTAR EL CODIGO PARA LAS NUEVAS CLASES
class HighCard extends Jugada {
    public HighCard() {
        super(5, 1);
    }
}

class Pair extends Jugada {
    //mult=2 puntaje=10
    public Pair() {
        super(10, 2);
    }
}

class TwoPair extends Jugada {
    //mult=2 puntaje=20

    public TwoPair() {
        super(20, 2);
    }
}

class Straight extends Jugada {
    //mult=4 puntaje=30

    public Straight() {
        super(30, 4);
    }
}

class Flush extends Jugada {
    //mult=4 puntaje=35

    public Flush() {
        super(35, 4);
    }
}

class FullHouse extends Jugada {
    //mult=4 puntaje=40

    public FullHouse() {
        super(40, 4);
    }
}

class ThreeOfAKind extends Jugada {
    //mult=3 puntaje=30

    public ThreeOfAKind() {
        super(30, 3);
    }
}

class FourOfAKind extends Jugada {
    //mult=7 puntaje=60

    public FourOfAKind() {
        super(60, 7);
    }
}

class StraightFlush extends Jugada {
    //mult=8 puntaje=100

    public StraightFlush() {
        super(100, 8);
    }
}

class RoyalFlush extends Jugada {
    //mult=8 puntaje=100

    public RoyalFlush() {
        super(100, 8);
    }
}