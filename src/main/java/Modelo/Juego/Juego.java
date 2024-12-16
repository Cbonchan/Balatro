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
    int nroRonda;
    Ronda rondaActual;
    List<Ronda> rondas;

     public Juego(){
        this.jugador = new Jugador();
        nroRonda = 1;
        //aca deberia estar la lectura de los json, creo, sobretodo porque convendria almacenar la info de las rondas en inicializacion en lugar de
        //obtenerla en tiempo de ejecucion
        //this.ronda = new Ronda(0,2,2,100, new Tienda(List.of(new Descarte("prueba","prueba",1,new Multiplicador(1),new SumarPuntaje())),new Carta(new Diamante(),new As())));
    }


    public void comenzarJuego(){
      /*  // inicializamos rondas

        for (Ronda ronda : rondas){
            ronda.comenzar();
            while(ronda.puedoContinuar() && !ronda.superoPuntaje(jugador)){
                //! desconozco como funciona esto secuencialmente con javaFX como para completar

                //!mucho de esto se hace de forma nativa en FX, aca tenemos que inicializar los componentes
                //y facilitar funciones para avanzar, no nos encargamos del loop porque para eso es el controlador
            }
            if(!ronda.superoPuntaje(jugador)){
                terminarJuego();
            }
            }*/
       }

    public void terminarJuego(){
        //TODO implementar
    }

    public void avanzarRonda() {
        this.rondaActual=rondas.get(nroRonda-1);
        nroRonda++;
    }

    }









