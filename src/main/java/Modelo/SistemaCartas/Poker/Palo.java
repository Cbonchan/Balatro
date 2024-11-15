package Modelo.SistemaCartas.Poker;

abstract class Palo {
    private final String nombre;

    public Palo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    abstract public boolean esPalo(String palo);
}

class Corazones extends Palo {
    public Corazones() {
        super("Corazones");
    }

    @Override
    public boolean esPalo(String palo) {
        if(palo==this.getNombre()){
            return true;
        }
        return false;
    }
}

class Diamantes extends Palo {
    public Diamantes() {
        super("Diamantes");
    }
    @Override
    public boolean esPalo(String palo) {
        if(palo==this.getNombre()){
            return true;
        }
        return false;
    }

}

class Treboles extends Palo {
    public Treboles() {
        super("Tréboles");
    }
    @Override
    public boolean esPalo(String palo) {
        if(palo==this.getNombre()){
            return true;
        }
        return false;
    }
}

class Picas extends Palo {
    public Picas() {
        super("Picas");
    }
    @Override
    public boolean esPalo(String palo) {
        if(palo==this.getNombre()){
            return true;
        }
        return false;
    }
}