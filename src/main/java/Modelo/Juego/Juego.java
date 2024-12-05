/*


package Modelo.Juego;


import Modelo.SistemaCartas.Activables.Joker.Descarte;
import Modelo.SistemaCartas.Activables.Joker.PorJugada;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.SumarPuntaje;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Cartas.Figura.As;
import Modelo.SistemaCartas.Cartas.Palo.Diamante;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Jugador;

import java.util.List;

public class Juego {



    // Atributos
    Jugador jugador;
    Ronda ronda;
    //List<Ronda> rondas;

     public Juego(){
        this.jugador = new Jugador();
        this.ronda = new Ronda(0,2,2,100, new Tienda(List.of(new Descarte("prueba","prueba",1,new Multiplicador(1),new SumarPuntaje())),new Carta(new Diamante(),new As())));
    }

/*
    public void comenzarJuego(){
        jugador
        // inicializamos rondas

        for (Ronda ronda : rondas){
            ronda.comenzar();
            while(ronda.puedoContinuar() && !ronda.superoPuntaje(jugador)){
                //! desconozco como funciona esto secuencialmente con javaFX como para completar
            }
            if(!ronda.superoPuntaje(jugador)){
                terminarJuego();
            }
            }
       }


    }


    public void terminarJuego(){
        //TODO implementar
    }

}
*/



