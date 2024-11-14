package TP;

abstract class Figura {

    private final String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    abstract public int devolverPuntaje();
    abstract public boolean esMayorA(Figura figura);

    public String getNombre() {
        return nombre;
    }
}

class As extends Figura {
    public As() {
        super("As");
    }
    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof K;
    }

    @Override
    public int devolverPuntaje() {
        return 11;
    }
}

class Dos extends Figura {
    public Dos() {
        super("2");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof As;
    }
    @Override
    public int devolverPuntaje() {
        return 2;
    }
}

class Tres extends Figura {
    public Tres() {
        super("3");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof Dos;
    }
    @Override
    public int devolverPuntaje() {
        return 3;
    }
}

class Cuatro extends Figura {
    public Cuatro() {
        super("4");
    }
    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof Tres;
    }
    @Override
    public int devolverPuntaje() {
        return 4;
    }
}

class Cinco extends Figura {
    public Cinco() {
        super("5");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof Cuatro;
    }

    @Override
    public int devolverPuntaje() {
        return 5;
    }
}

class Seis extends Figura {
    public Seis() {
        super("6");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof Cinco;
    }
    @Override
    public int devolverPuntaje() {
        return 6;
    }
}

class Siete extends Figura {
    public Siete() {
        super("7");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof Seis;
    }
    @Override
    public int devolverPuntaje() {
        return 7;
    }
}

class Ocho extends Figura {
    public Ocho() {
        super("8");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof Siete;
    }

    @Override
    public int devolverPuntaje() {
        return 8;
    }
}

class Nueve extends Figura {
    public Nueve() {
        super("9");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof Ocho;
    }

    @Override
    public int devolverPuntaje() {
        return 9;
    }
}

class Diez extends Figura {
    public Diez() {
        super("10");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof Nueve;
    }
    @Override
    public int devolverPuntaje() {
        return 10;
    }
}

class J extends Figura {
    public J() {
        super("J");
    }
    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof  Diez;
    }
    @Override
    public int devolverPuntaje() {
        return 10;
    }
}

class Q extends Figura {
    public Q() {
        super("Q");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof J;
    }
    @Override
    public int devolverPuntaje() {
        return 10;
    }
}

class K extends Figura {
    public K() {
        super("K");
    }

    @Override
    public boolean esMayorA(Figura figura) {
        return figura instanceof Q;
    }

    @Override
    public int devolverPuntaje() {
        return 10;
    }
}