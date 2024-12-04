package Modelo.Juego;

// Importaciones

public class Tablero {
/*
    // Atributos
    private List<Joker> jokers;
    private List<Tarot> tarots;
    //Experimetal
    private Tarot tarotAJugar;
    private Jugador jugador;
    private PilaDescarte pilaDescarte;

    // Constructor

    public Tablero(Jugador jugador) {
        this.pilaDescarte = new PilaDescarte();
        this.jugador = jugador;
        this.jokers = new ArrayList<>();
        this.tarots = new ArrayList<>();
    }


    //Métodos

    public void agregarJoker(Joker joker) {
        jokers.add(joker);
    }

    public void destruirJoker(Joker joker) {
        jokers.remove(joker);
    }

    public void agregarTarot(Tarot tarot) {
        tarots.add(tarot);
    }

    public void destruirTarot(Tarot tarot) {
        tarots.remove(tarot);
    }

    public int jugarMano(Mano mano) {
        int puntaje = mano.calcularPuntaje();
        this.chequearJokersJugada();
        pilaDescarte.descartarMano(mano);
        return puntaje;
    }

    /*TODO:revisar si estas acciones pueden ser realizadas por el jugador,
       quiza haciendo que jugador conozca al tablero y pidiendole a el que
        haga estos movimientos, por ahora esto funciona*/

   /*
    public void seleccionarTarot(Tarot tarot) {
        tarotAJugar = tarot;
        tarots.remove(tarot);
    }
    public void deseleccionarTarot(Tarot tarot) {
        tarots.add(tarot);
        tarotAJugar= null;
    }
    public void jugarTarot(){
        this.tarotAJugar.activar(this.jugador);
        deseleccionarTarot(this.tarotAJugar);
        destruirTarot(this.tarotAJugar);
    }

    //Post: activa Jokers correspondientes tras realizar una jugada
    private void chequearJokersJugada(){
        for(Joker joker: this.jokers){
            joker.activar(this.jugador);
        }
    }
    //Post: activa Jokers correspondientes al realizar un descarte
    private void chequearJokersDescarte(){
        for(Joker joker: this.jokers){
            joker.activar(this.jugador);
        }
    }


    */
}