package TP;

abstract class Jugada {
    private int puntaje;
    private int multiplicador;
}
//las jugadas agregan al multiplicador y agregan
//sus puntos al marcador cuando se realizan
//NO EXISTE MANO QUE NO LLEVE A UNA JUGADA

class highCard extends Jugada {
    //mult=1 puntaje=5
}

class pair extends Jugada {
    //mult=2 puntaje=10
}

class twoPair extends Jugada {
    //mult=2 puntaje=20
}

class straight extends Jugada {
    //mult=4 puntaje=30
}

class flush extends Jugada {
    //mult=4 puntaje=35
}

class fullHouse extends Jugada {
    //mult=4 puntaje=40
}

class threeOfAKind extends Jugada {
    //mult=3 puntaje=30
}

class fourOfAKind extends Jugada {
    //mult=7 puntaje=60
}

class straightFlush extends Jugada {
    //mult=8 puntaje=100
}

class royalFlush extends Jugada {
    //mult=8 puntaje=100
}