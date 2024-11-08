package TP;

import java.util.ArrayList;
import java.util.List;

abstract class Palo {
    private final String nombre;

    public Palo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Corazones extends Palo {
    public Corazones() {
        super("Corazones");
    }
}

class Diamantes extends Palo {
    public Diamantes() {
        super("Diamantes");
    }
}

class Treboles extends Palo {
    public Treboles() {
        super("Tréboles");
    }
}

class Picas extends Palo {
    public Picas() {
        super("Picas");
    }
}